package bluevelvet.blueprint.app.presentation.splash

import bluevelvet.blueprint.core.base.state.view.ViewEvent

class SplashViewContract {
    sealed class Event: ViewEvent {
        object GotoNextScreen: Event()
    }
}