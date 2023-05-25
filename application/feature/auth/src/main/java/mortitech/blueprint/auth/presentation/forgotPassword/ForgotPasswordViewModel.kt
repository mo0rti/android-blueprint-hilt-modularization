package mortitech.blueprint.auth.presentation.forgotPassword

import androidx.lifecycle.viewModelScope
import mortitech.blueprint.auth.navigation.AuthCoordinatorEvent
import mortitech.blueprint.auth.usecase.AuthUserCases
import mortitech.blueprint.core.ui.base.BaseViewModel
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
        ForgotPasswordViewContract.Action,
        ForgotPasswordViewContract.Event,
        >() {

    override fun createInitialState() = ForgotPasswordViewContract.State(
        isLoading = false,
    )

    override fun processViewActions(viewEvent: ForgotPasswordViewContract.Action) {
        when(viewEvent) {
            is ForgotPasswordViewContract.Action.OnResetButtonClicked -> {
                with(currentViewState()) {
                    resetPinCode(username)
                }
            }
            is ForgotPasswordViewContract.Action.OnBackToLoginLinkClicked -> {
                sendCoordinatorEvent(AuthCoordinatorEvent.BackToLogin)
            }
            is ForgotPasswordViewContract.Action.OnUserNameTextChanged -> {
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
                updateViewEvent(ForgotPasswordViewContract.Event.ShowSuccessDialog())
            } catch (e: Exception) {
                updateViewEvent(ForgotPasswordViewContract.Event.ShowErrorToast(e.message))
            } finally {
                updateViewState { copy(isLoading = false) }
            }
        }
    }
}