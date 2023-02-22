package bluevelvet.blueprint.auth.presentation.login

import bluevelvet.blueprint.core.base.state.view.ViewEffect
import bluevelvet.blueprint.core.base.state.view.ViewEvent
import bluevelvet.blueprint.core.base.state.view.ViewState

/**
 * Contracts for Login view model state and event handling.
 **/

class LoginViewContract {

    data class State(
        val isLoading: Boolean,
        val error: String?,
        val username: String = "",
        val password: String = ""
    ): ViewState

    sealed class Event: ViewEvent {
        object OnLoginButtonClicked: Event()
        data class OnUserNameTextChanged(val username: String): Event()
        data class OnPasswordTextChanged(val password: String): Event()
    }

    sealed class Effect: ViewEffect {
        object ShowToast: Effect()
    }
}