package mortitech.blueprint.account.presentation.dashboard.favorites

import androidx.fragment.app.viewModels
import mortitech.blueprint.account.databinding.FragmentFavoritesBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewAction
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment: BaseFragment<
        FragmentFavoritesBinding,
        EmptyViewState,
        EmptyViewAction,
        EmptyViewEvent,
        FavoritesViewModel>(
    FragmentFavoritesBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: FavoritesViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEventReceived(viewEvent: EmptyViewEvent) {
    }

    override fun onViewStateChanged(viewState: EmptyViewState) {
    }
}