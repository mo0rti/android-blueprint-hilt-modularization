package mortitech.blueprint.auth.presentation.login

import mortitech.blueprint.core.ui.state.view.ViewEffect
import mortitech.blueprint.core.ui.state.view.ViewEvent
import mortitech.blueprint.core.ui.state.view.ViewState

/**
 * Contracts for Login view model state and event handling.
 **/

class LoginViewContract {

    data class State(
        val isLoading: Boolean,
        val username: String = "",
        val password: String = "",
    ): ViewState

    sealed class Event: ViewEvent {
        object OnLoginButtonClicked: Event()
        object OnForgotPasswordLinkClicked: Event()
        object OnSignupLinkClicked: Event()
        data class OnUserNameTextChanged(val username: String): Event()
        data class OnPasswordTextChanged(val password: String): Event()
    }

    sealed class Effect: ViewEffect {
        data class ShowErrorToast(
            val error: String?
        ): Effect()
    }
}