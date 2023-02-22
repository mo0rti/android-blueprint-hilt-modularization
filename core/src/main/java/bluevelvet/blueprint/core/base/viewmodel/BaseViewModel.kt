package bluevelvet.blueprint.core.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bluevelvet.blueprint.core.base.state.view.ViewEffect
import bluevelvet.blueprint.core.base.state.view.ViewEvent
import bluevelvet.blueprint.core.base.state.view.ViewState
import bluevelvet.blueprint.navigation.event.CoordinatorEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<
        VS: ViewState,
        VE: ViewEvent,
        VF: ViewEffect,
        >: ViewModel() {

    // Using stateFlow instead of LiveData with initial state
    private val _initialState: VS by lazy { createInitialState() }
    private val _viewState = MutableStateFlow(_initialState)
    val viewState = _viewState.asStateFlow()

    // View events as sharedFlow to broadcast state changes to an unknown number of subscribers
    // Events should processed immediately or not at all.
    private val _viewEvent: MutableSharedFlow<VE> = MutableSharedFlow(
        extraBufferCapacity = 1
    )
    val viewEvent = _viewEvent.asSharedFlow()

    // View effect to deliver events to a single subscriber, replacement for SingleLiveEvent
    // Usage for displaying toast, and navigation
    private val _viewEffect: Channel<VF> = Channel()
    val viewEffect = _viewEffect.receiveAsFlow()

    abstract fun createInitialState(): VS
    abstract fun handleViewEvent(viewEvent: VE)

    init {
        subscribeViewEvents()
    }

    fun currentViewState(): VS {
        return _viewState.value
    }

    protected fun updateViewState(newState: VS.() -> VS) {
        val newState = currentViewState().newState()
        _viewState.value = newState
    }

    fun updateViewEvent(event: VE) {
        _viewEvent.tryEmit(event)
    }

    protected fun updateViewEffect(effect: VF) {
        viewModelScope.launch { _viewEffect.send(effect) }
    }

    private fun subscribeViewEvents() {
        viewModelScope.launch {
            _viewEvent.collect { event ->
                handleViewEvent(event)
            }
        }
    }

    private val _coordinatorEvent = MutableLiveData<CoordinatorEvent>()
    val coordinatorEvent: LiveData<CoordinatorEvent>
        get() = _coordinatorEvent

    protected fun <E : CoordinatorEvent> sendCoordinatorEvent(event: E) {
        _coordinatorEvent.value = event
    }
}