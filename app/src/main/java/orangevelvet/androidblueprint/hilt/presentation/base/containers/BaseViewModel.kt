package orangevelvet.androidblueprint.hilt.presentation.base.containers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import orangevelvet.androidblueprint.hilt.presentation.base.state.view.ViewAction
import orangevelvet.androidblueprint.hilt.presentation.base.state.view.ViewEvent
import orangevelvet.androidblueprint.hilt.presentation.base.state.view.ViewState
import orangevelvet.androidblueprint.hilt.presentation.navigation.events.CoordinatorEvent

abstract class BaseViewModel<
        VS: ViewState,
        VE: ViewEvent,
        VA: ViewAction,
        >: ViewModel() {

    abstract fun postAction(action: VA)

    private val _coordinatorEvent = MutableLiveData<CoordinatorEvent>()
    val coordinatorEvent: LiveData<CoordinatorEvent>
        get() = _coordinatorEvent

    protected fun <E : CoordinatorEvent> sendCoordinatorEvent(event: E) {
        _coordinatorEvent.value = event
    }
}