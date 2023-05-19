package mortitech.blueprint.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import mortitech.blueprint.core.domain.model.ViewInflater
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.state.view.ViewEffect
import mortitech.blueprint.core.ui.state.view.ViewEvent
import mortitech.blueprint.core.ui.state.view.ViewState
import mortitech.blueprint.navigation.coordinator.Coordinator
import mortitech.blueprint.navigation.coordinator.CoordinatorHost
import kotlinx.coroutines.launch

abstract class BaseFragment<
        VB : ViewBinding,
        VS : ViewState,
        VE : ViewEvent,
        VF : ViewEffect,
        VM : BaseViewModel<VS, VE, VF>,
        >
constructor(
    private val viewInflater: ViewInflater<VB>,
    private val toolbarConfiguration: ToolbarConfiguration,
) : Fragment() {

    private lateinit  var _binding: VB
    val binding get() = _binding

    protected abstract val viewModel: VM

    // Handle UI related events such as onclick, onchange, list adapter initialization
    abstract fun initializeComponents()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = viewInflater.invoke(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeComponents()

        viewLifecycleOwner.lifecycleScope.launch {
            // Suspend the coroutine until the lifecycle is DESTROYED.
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Safely collect from locations when the lifecycle is STARTED
                // and stop collecting when the lifecycle is STOPPED

                // Collect view state
                viewModel.viewState.collect {
                    onViewStateChange(it)
                }
            }
            // Note: at this point, the lifecycle is DESTROYED!
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Collect view effect
                viewModel.viewEffect.collect {
                    onViewEffectReceived(it)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Collect coordinator events to navigate to the other screens
                viewModel.coordinatorEvent.collect { coordinatorEvent ->
                    activityCoordinator().onEvent(coordinatorEvent)
                }
            }
        }
    }

    override fun onStart() {
        activity().updateToolbar(toolbarConfiguration)
        super.onStart()
    }

    fun activity() = activity?.run {
        (this as BaseActivity<*, *>)
    } ?: throw Exception("Activity is not inherited from BaseActivity")

    //------------------- State and Event
    protected fun postEvent(event: VE) {
        viewModel.updateViewEvent(event)
    }
    abstract fun onViewEffectReceived(viewEffect: VF)
    abstract fun onViewStateChange(viewState: VS)
    //------------------- Navigation
    private fun activityCoordinator(): Coordinator {
        return (requireActivity() as CoordinatorHost<*>).coordinator
    }

    private fun hostFragment(fragment: Fragment?): Fragment? {
        if (fragment == null) return null
        if (fragment is CoordinatorHost<*>) return fragment
        return hostFragment(fragment.parentFragment)
    }

    private fun coordinatorHost(): CoordinatorHost<*> {
        return (hostFragment(this) as? CoordinatorHost<*>)
            ?: (this.requireActivity() as? CoordinatorHost<*>)
            ?: throw Exception("The fragment must be opened in a CoordinatorHost fragment/activity")
    }

    fun showToast(message: String?) {
        activity().showToast(message ?: "Invalid message")
    }

    fun showDialog(
        message: String?,
        callBack: (() -> Unit)? = null
    ) {
        activity().showDialog(message ?: "Invalid message", callBack)
    }
}