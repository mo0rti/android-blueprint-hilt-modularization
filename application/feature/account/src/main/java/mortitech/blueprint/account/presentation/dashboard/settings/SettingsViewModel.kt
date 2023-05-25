package mortitech.blueprint.account.presentation.dashboard.settings

import mortitech.blueprint.core.ui.base.BaseViewModel
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewAction
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
@Inject
constructor(
): BaseViewModel<
        EmptyViewState,
        EmptyViewAction,
        EmptyViewEvent>() {
    override fun createInitialState(): EmptyViewState {
        return EmptyViewState()
    }

    override fun processViewActions(viewEvent: EmptyViewAction) {
    }

}
