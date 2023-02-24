package bluevelvet.blueprint.auth.presentation.login

import androidx.lifecycle.viewModelScope
import bluevelvet.blueprint.auth.domain.usecase.AuthUserCases
import bluevelvet.blueprint.auth.navigation.AuthCoordinatorEvent
import bluevelvet.blueprint.core.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(
    private val authUserCases: AuthUserCases
) : BaseViewModel<
        LoginViewContract.State,
        LoginViewContract.Event,
        LoginViewContract.Effect,
        >() {

    override fun createInitialState() = LoginViewContract.State(
        isLoading = false,
    )

    override fun handleViewEvent(viewEvent: LoginViewContract.Event) {
        when(viewEvent) {
            is LoginViewContract.Event.OnLoginButtonClicked -> {
                with(currentViewState()) {
                    login(username, password)
                }
            }
            is LoginViewContract.Event.OnForgotPasswordLinkClicked -> {
                sendCoordinatorEvent(AuthCoordinatorEvent.ForgotPinCode)
            }
            is LoginViewContract.Event.OnSignupLinkClicked -> {
                sendCoordinatorEvent(AuthCoordinatorEvent.OnboardingFlow)
            }
            is LoginViewContract.Event.OnUserNameTextChanged -> {
                updateViewState { copy(username = viewEvent.username) }
            }
            is LoginViewContract.Event.OnPasswordTextChanged -> {
                updateViewState { copy(password = viewEvent.password) }
            }
        }
    }

    private fun login(
        username: String,
        password: String
    ) {
        viewModelScope.launch {
            try {
                updateViewState { copy(isLoading = true) }
                authUserCases.loginUseCase(username, password)
                sendCoordinatorEvent(AuthCoordinatorEvent.AccountFlow)
            } catch (e: Exception) {
                updateViewEffect(LoginViewContract.Effect.ShowErrorToast(e.message))
            } finally {
                updateViewState { copy(isLoading = false) }
            }
        }
    }
}