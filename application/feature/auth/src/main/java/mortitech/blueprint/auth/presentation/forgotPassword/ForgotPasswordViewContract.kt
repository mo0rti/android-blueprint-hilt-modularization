package mortitech.blueprint.auth.presentation.forgotPassword

import androidx.annotation.StringRes
import mortitech.blueprint.auth.R
import mortitech.blueprint.core.ui.state.view.ViewEvent
import mortitech.blueprint.core.ui.state.view.ViewAction
import mortitech.blueprint.core.ui.state.view.ViewState

/**
 * Contracts for Forgot password view model state and event handling.
 **/

class ForgotPasswordViewContract {

    data class State(
        val isLoading: Boolean,
        val username: String = "",
    ): ViewState

    sealed class Action: ViewAction {
        object OnResetButtonClicked: Action()
        object OnBackToLoginLinkClicked: Action()
        data class OnUserNameTextChanged(val username: String): Action()
    }

    sealed class Event: ViewEvent {
        data class ShowErrorToast(
            val error: String?
        ): Event()

        data class ShowSuccessDialog(
            @StringRes
            val message: Int = R.string.reset_password_success
        ): Event()
    }
}