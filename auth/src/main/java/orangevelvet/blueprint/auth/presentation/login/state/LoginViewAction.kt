package orangevelvet.blueprint.auth.presentation.login.state

import orangevelvet.blueprint.core.base.state.view.ViewAction

sealed class LoginViewAction: ViewAction {
    object InitializeAction: LoginViewAction()
}