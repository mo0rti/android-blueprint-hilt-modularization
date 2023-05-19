package mortitech.blueprint.app.presentation.splash

import mortitech.blueprint.core.ui.state.view.ViewEvent

class SplashViewContract {
    sealed class Event: ViewEvent {
        object GotoNextScreen: Event()
    }
}