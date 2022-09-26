package bluevelvet.blueprint.auth.presentation.login

import dagger.hilt.android.lifecycle.HiltViewModel
import bluevelvet.blueprint.auth.navigation.AuthCoordinatorEvent
import bluevelvet.blueprint.auth.presentation.login.state.LoginViewAction
import bluevelvet.blueprint.auth.presentation.login.state.LoginViewEvent
import bluevelvet.blueprint.auth.presentation.login.state.LoginViewState
import bluevelvet.blueprint.core.base.viewmodel.BaseViewModel
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

    override fun onViewEvent(viewEvent: LoginViewEvent) {
    }
}