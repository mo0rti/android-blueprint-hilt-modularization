package bluevelvet.blueprint.auth.presentation.login.state

import bluevelvet.blueprint.core.base.state.view.ViewAction

sealed class LoginViewAction: ViewAction {
    object InitializeAction: LoginViewAction()
    object LoginButtonTappedAction: LoginViewAction()
}