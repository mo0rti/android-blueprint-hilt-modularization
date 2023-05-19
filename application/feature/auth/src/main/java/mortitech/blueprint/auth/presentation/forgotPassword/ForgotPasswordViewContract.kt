package mortitech.blueprint.auth.presentation.forgotPassword

import androidx.annotation.StringRes
import mortitech.blueprint.auth.R
import mortitech.blueprint.core.ui.state.view.ViewEffect
import mortitech.blueprint.core.ui.state.view.ViewEvent
import mortitech.blueprint.core.ui.state.view.ViewState

/**
 * Contracts for Forgot password view model state and event handling.
 **/

class ForgotPasswordViewContract {

    data class State(
        val isLoading: Boolean,
        val username: String = "",
    ): ViewState

    sealed class Event: ViewEvent {
        object OnResetButtonClicked: Event()
        object OnBackToLoginLinkClicked: Event()
        data class OnUserNameTextChanged(val username: String): Event()
    }

    sealed class Effect: ViewEffect {
        data class ShowErrorToast(
            val error: String?
        ): Effect()

        data class ShowSuccessDialog(
            @StringRes
            val message: Int = R.string.reset_password_success
        ): Effect()
    }
}