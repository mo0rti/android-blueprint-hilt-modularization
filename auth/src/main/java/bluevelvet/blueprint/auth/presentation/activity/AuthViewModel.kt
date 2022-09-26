package bluevelvet.blueprint.auth.presentation.activity

import bluevelvet.blueprint.auth.business.AuthUserCases
import bluevelvet.blueprint.auth.presentation.login.state.LoginViewAction
import bluevelvet.blueprint.auth.presentation.login.state.LoginViewEvent
import bluevelvet.blueprint.auth.presentation.login.state.LoginViewState
import bluevelvet.blueprint.core.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel
@Inject
constructor(
    private val authUserCases: AuthUserCases
): BaseViewModel<
        LoginViewState,
        LoginViewEvent,
        LoginViewAction>() {

    private suspend fun login() {
        authUserCases.loginUseCase("", "")
    }

    override fun postAction(action: LoginViewAction) {
        when(action) {
            is LoginViewAction.InitializeAction -> {}
            is LoginViewAction.LoginButtonTappedAction -> {}
        }
    }

    override fun onViewEvent(viewEvent: LoginViewEvent) {
    }
}
