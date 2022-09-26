package bluevelvet.blueprint.app.presentation.splash

import bluevelvet.blueprint.core.base.state.view.ViewAction

sealed class SplashViewAction: ViewAction {
    object GotoNextScreenAction: SplashViewAction()
}