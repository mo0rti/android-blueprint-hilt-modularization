package orangevelvet.blueprint.auth.presentation.login

import dagger.hilt.android.lifecycle.HiltViewModel
import orangevelvet.blueprint.auth.navigation.AuthCoordinatorEvent
import orangevelvet.blueprint.auth.presentation.login.state.LoginViewAction
import orangevelvet.blueprint.auth.presentation.login.state.LoginViewEvent
import orangevelvet.blueprint.auth.presentation.login.state.LoginViewState
import orangevelvet.blueprint.core.base.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(
) : BaseViewModel<
        LoginViewState,
        LoginViewEvent,
        LoginViewAction
        >() {

    override fun postAction(action: LoginViewAction) {
        sendCoordinatorEvent(AuthCoordinatorEvent.AccountFlow)
    }
}