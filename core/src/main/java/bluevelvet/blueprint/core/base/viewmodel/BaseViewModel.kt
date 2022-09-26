package bluevelvet.blueprint.core.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bluevelvet.blueprint.core.base.state.view.ViewAction
import bluevelvet.blueprint.core.base.state.view.ViewEvent
import bluevelvet.blueprint.core.base.state.view.ViewState
import bluevelvet.blueprint.navigation.event.CoordinatorEvent

abstract class BaseViewModel<
        VS: ViewState,
        VE: ViewEvent,
        VA: ViewAction,
        >: ViewModel() {

    abstract fun postAction(action: VA)
    abstract fun onViewEvent(viewEvent: VE)

    private val _coordinatorEvent = MutableLiveData<CoordinatorEvent>()
    val coordinatorEvent: LiveData<CoordinatorEvent>
        get() = _coordinatorEvent

    protected fun <E : CoordinatorEvent> sendCoordinatorEvent(event: E) {
        _coordinatorEvent.value = event
    }
}