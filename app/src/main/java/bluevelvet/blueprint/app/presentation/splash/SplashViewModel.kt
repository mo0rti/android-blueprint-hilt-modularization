package bluevelvet.blueprint.app.presentation.splash

import dagger.hilt.android.lifecycle.HiltViewModel
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.viewmodel.BaseViewModel
import bluevelvet.blueprint.core.domain.contract.session.UserSessionManager
import bluevelvet.blueprint.app.navigation.MainCoordinatorEvent
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject
constructor(
    private val userSessionManager: UserSessionManager
) : BaseViewModel<
        EmptyViewState,
        EmptyViewEvent,
        SplashViewAction,
        >() {

    override fun postAction(action: SplashViewAction) {
        when (action) {
            is SplashViewAction.GotoNextScreenAction ->  {
                if (userSessionManager.isUserAuthenticated())
                    sendCoordinatorEvent(MainCoordinatorEvent.AccountFlow)
                else
                    sendCoordinatorEvent(MainCoordinatorEvent.AuthFlow)
            }
        }
    }

    override fun onViewEvent(viewEvent: EmptyViewEvent) {
    }
}
