package mortitech.blueprint.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.onEach
import mortitech.blueprint.core.domain.model.ViewInflater
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.state.view.ViewEvent
import mortitech.blueprint.core.ui.state.view.ViewAction
import mortitech.blueprint.core.ui.state.view.ViewState
import mortitech.blueprint.navigation.coordinator.Coordinator
import mortitech.blueprint.navigation.coordinator.CoordinatorHost

abstract class BaseFragment<
        VB : ViewBinding,
        VS : ViewState,
        VA : ViewAction,
        VE : ViewEvent,
        VM : BaseViewModel<VS, VA, VE>,
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

        viewModel.viewState.onEach { onViewStateChanged(it) }
        viewModel.viewEvent.onEach { onViewEventReceived(it) }
        viewModel.coordinatorEvent.onEach { activityCoordinator().onEvent(it) }
    }

    override fun onStart() {
        activity().updateToolbar(toolbarConfiguration)
        super.onStart()
    }

    fun activity() = activity?.run {
        (this as BaseActivity<*, *>)
    } ?: throw Exception("Activity is not inherited from BaseActivity")

    //------------------- State and Event
    protected fun postAction(event: VA) {
        viewModel.updateViewAction(event)
    }
    abstract fun onViewEventReceived(viewEvent: VE)
    abstract fun onViewStateChanged(viewState: VS)
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