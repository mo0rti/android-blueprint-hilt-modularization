package bluevelvet.blueprint.core.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import bluevelvet.blueprint.core.base.state.view.ViewEffect
import bluevelvet.blueprint.core.base.state.view.ViewEvent
import bluevelvet.blueprint.core.base.state.view.ViewState
import bluevelvet.blueprint.core.base.viewmodel.BaseViewModel
import bluevelvet.blueprint.core.model.ViewInflater
import bluevelvet.blueprint.navigation.coordinator.Coordinator
import bluevelvet.blueprint.navigation.coordinator.CoordinatorHost

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

        lifecycleScope.launchWhenStarted {
            viewModel.coordinatorEvent.collect { coordinatorEvent ->
                activityCoordinator().onEvent(coordinatorEvent)
            }
        }

        initializeComponents()

        // Collect view state
        lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect {
                onViewStateChange(it)
            }
        }

        // Collect view effect
        lifecycleScope.launchWhenStarted {
            viewModel.viewEffect.collect {
                onViewEffectReceived(it)
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