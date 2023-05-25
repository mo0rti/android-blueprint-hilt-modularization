package mortitech.blueprint.app.presentation.splash

import mortitech.blueprint.core.ui.state.view.ViewAction

class SplashViewContract {
    sealed class Action: ViewAction {
        object GotoNextScreen: Action()
    }
}