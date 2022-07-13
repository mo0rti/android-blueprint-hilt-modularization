package orangevelvet.androidblueprint.hilt.presentation.ui.main.splash

import orangevelvet.androidblueprint.core.base.state.view.ViewAction

sealed class SplashViewAction: ViewAction {
    object GotoNextScreenAction: SplashViewAction()
}