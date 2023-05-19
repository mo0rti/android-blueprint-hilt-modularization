package mortitech.blueprint.account.presentation.dashboard.favorites

import mortitech.blueprint.core.ui.base.BaseViewModel
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEffect
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel
@Inject
constructor(
): BaseViewModel<
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect>() {
    override fun createInitialState(): EmptyViewState {
        return EmptyViewState()
    }

    override fun handleViewEvent(viewEvent: EmptyViewEvent) {
    }

}
