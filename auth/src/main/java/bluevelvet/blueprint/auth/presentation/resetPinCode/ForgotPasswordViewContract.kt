package bluevelvet.blueprint.auth.presentation.resetPinCode

import androidx.annotation.StringRes
import bluevelvet.blueprint.auth.R
import bluevelvet.blueprint.core.base.state.view.ViewEffect
import bluevelvet.blueprint.core.base.state.view.ViewEvent
import bluevelvet.blueprint.core.base.state.view.ViewState

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