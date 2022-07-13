package orangevelvet.androidblueprint.hilt.presentation.ui.main.splash

import orangevelvet.androidblueprint.hilt.presentation.base.state.view.ViewAction

sealed class SplashViewAction: ViewAction {
    object GotoNextScreenAction: SplashViewAction()
}