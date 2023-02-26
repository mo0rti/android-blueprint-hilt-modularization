package bluevelvet.blueprint.account.presentation.dashboard.favorites

import androidx.fragment.app.viewModels
import bluevelvet.blueprint.account.databinding.FragmentFavoritesBinding
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.ui.BaseFragment
import bluevelvet.blueprint.core.base.ui.ToolbarConfiguration
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