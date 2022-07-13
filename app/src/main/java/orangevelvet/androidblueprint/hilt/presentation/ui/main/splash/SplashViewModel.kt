package orangevelvet.androidblueprint.hilt.presentation.ui.main.splash

import dagger.hilt.android.lifecycle.HiltViewModel
import orangevelvet.androidblueprint.hilt.domain.contract.session.UserSessionManager
import orangevelvet.androidblueprint.hilt.presentation.base.containers.BaseViewModel
import orangevelvet.androidblueprint.hilt.presentation.base.state.view.empty.EmptyViewEvent
import orangevelvet.androidblueprint.hilt.presentation.base.state.view.empty.EmptyViewState
import orangevelvet.androidblueprint.hilt.presentation.navigation.events.MainCoordinatorEvent
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
}
