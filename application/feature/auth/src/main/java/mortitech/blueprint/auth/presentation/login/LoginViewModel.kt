package mortitech.blueprint.auth.presentation.login

import androidx.lifecycle.viewModelScope
import mortitech.blueprint.auth.navigation.AuthCoordinatorEvent
import mortitech.blueprint.auth.usecase.AuthUserCases
import mortitech.blueprint.core.di.IoDispatcher
import mortitech.blueprint.core.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(
    private val authUserCases: AuthUserCases,
    @IoDispatcher
    private val IoDispatcher: CoroutineDispatcher
) : BaseViewModel<
        LoginViewContract.State,
        LoginViewContract.Action,
        LoginViewContract.Event,
        >() {

    override fun createInitialState() = LoginViewContract.State(
        isLoading = false,
    )

    override fun processViewActions(viewEvent: LoginViewContract.Action) {
        when(viewEvent) {
            is LoginViewContract.Action.OnLoginButtonClicked -> {
                with(currentViewState()) {
                    login(username, password)
                }
            }
            is LoginViewContract.Action.OnForgotPasswordLinkClicked -> {
                sendCoordinatorEvent(AuthCoordinatorEvent.ForgotPinCode)
            }
            is LoginViewContract.Action.OnSignupLinkClicked -> {
                sendCoordinatorEvent(AuthCoordinatorEvent.OnboardingFlow)
            }
            is LoginViewContract.Action.OnUserNameTextChanged -> {
                updateViewState { copy(username = viewEvent.username) }
            }
            is LoginViewContract.Action.OnPasswordTextChanged -> {
                updateViewState { copy(password = viewEvent.password) }
            }
        }
    }

    private fun login(
        username: String,
        password: String
    ) {
        viewModelScope.launch(IoDispatcher) {
            try {
                updateViewState { copy(isLoading = true) }
                authUserCases.loginUseCase(username, password)
                sendCoordinatorEvent(AuthCoordinatorEvent.AccountFlow)
            } catch (e: Exception) {
                updateViewEvent(LoginViewContract.Event.ShowErrorToast(e.message))
            } finally {
                updateViewState { copy(isLoading = false) }
            }
        }
    }
}