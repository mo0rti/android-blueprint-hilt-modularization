package mortitech.blueprint.account.presentation.dashboard.favorites

import androidx.fragment.app.viewModels
import mortitech.blueprint.account.databinding.FragmentFavoritesBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEffect
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment: BaseFragment<
        FragmentFavoritesBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
        FavoritesViewModel>(
    FragmentFavoritesBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: FavoritesViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}