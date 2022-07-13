package orangevelvet.blueprint.app.presentation.splash

import orangevelvet.blueprint.core.base.state.view.ViewAction

sealed class SplashViewAction: ViewAction {
    object GotoNextScreenAction: SplashViewAction()
}