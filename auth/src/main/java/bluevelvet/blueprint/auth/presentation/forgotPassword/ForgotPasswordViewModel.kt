package bluevelvet.blueprint.auth.presentation.forgotPassword

import androidx.lifecycle.viewModelScope
import bluevelvet.blueprint.auth.usecase.AuthUserCases
import bluevelvet.blueprint.auth.navigation.AuthCoordinatorEvent
import bluevelvet.blueprint.core.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel
@Inject
constructor(
    private val authUserCases: AuthUserCases
) : BaseViewModel<
        ForgotPasswordViewContract.State,
        ForgotPasswordViewContract.Event,
        ForgotPasswordViewContract.Effect,
        >() {

    override fun createInitialState() = ForgotPasswordViewContract.State(
        isLoading = false,
    )

    override fun handleViewEvent(viewEvent: ForgotPasswordViewContract.Event) {
        when(viewEvent) {
            is ForgotPasswordViewContract.Event.OnResetButtonClicked -> {
                with(currentViewState()) {
                    resetPinCode(username)
                }
            }
            is ForgotPasswordViewContract.Event.OnBackToLoginLinkClicked -> {
                sendCoordinatorEvent(AuthCoordinatorEvent.BackToLogin)
            }
            is ForgotPasswordViewContract.Event.OnUserNameTextChanged -> {
                updateViewState { copy(username = viewEvent.username) }
            }
        }
    }

    private fun resetPinCode(
        username: String
    ) {
        viewModelScope.launch {
            try {
                updateViewState { copy(isLoading = true) }
                authUserCases.resetPasswordUseCase(username)
                updateViewEffect(ForgotPasswordViewContract.Effect.ShowSuccessDialog())
            } catch (e: Exception) {
                updateViewEffect(ForgotPasswordViewContract.Effect.ShowErrorToast(e.message))
            } finally {
                updateViewState { copy(isLoading = false) }
            }
        }
    }
}