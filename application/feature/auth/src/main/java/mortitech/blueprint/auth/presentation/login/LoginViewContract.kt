package mortitech.blueprint.auth.presentation.login

import mortitech.blueprint.core.ui.state.view.ViewEvent
import mortitech.blueprint.core.ui.state.view.ViewAction
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

    sealed class Action: ViewAction {
        object OnLoginButtonClicked: Action()
        object OnForgotPasswordLinkClicked: Action()
        object OnSignupLinkClicked: Action()
        data class OnUserNameTextChanged(val username: String): Action()
        data class OnPasswordTextChanged(val password: String): Action()
    }

    sealed class Event: ViewEvent {
        data class ShowErrorToast(
            val error: String?
        ): Event()
    }
}