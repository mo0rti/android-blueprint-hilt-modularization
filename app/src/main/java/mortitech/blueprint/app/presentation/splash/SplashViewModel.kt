package mortitech.blueprint.app.presentation.splash

import mortitech.blueprint.app.navigation.MainCoordinatorEvent
import mortitech.blueprint.core.manager.contract.UserSessionManager
import mortitech.blueprint.core.ui.base.BaseViewModel
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEffect
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject
constructor(
    private val userSessionManager: UserSessionManager
) : BaseViewModel<
        EmptyViewState,
        SplashViewContract.Event,
        EmptyViewEffect,
        >() {

    override fun handleViewEvent(viewEvent: SplashViewContract.Event) {
        when(viewEvent) {
            is SplashViewContract.Event.GotoNextScreen -> {
                // Decide which flow should be shown
                if (userSessionManager.isUserAuthenticated())
                    sendCoordinatorEvent(MainCoordinatorEvent.AccountFlow)
                else
                    sendCoordinatorEvent(MainCoordinatorEvent.AuthFlow)
            }
        }
    }

    override fun createInitialState() = EmptyViewState()
}
