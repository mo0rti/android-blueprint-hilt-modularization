package bluevelvet.blueprint.account.presentation.dashboard.home

import androidx.fragment.app.viewModels
import androidx.navigation.ui.setupWithNavController
import bluevelvet.blueprint.account.databinding.FragmentDashboardBinding
import bluevelvet.blueprint.account.databinding.FragmentHomeBinding
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.view.BaseFragment
import bluevelvet.blueprint.core.base.view.ToolbarConfiguration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<
        FragmentHomeBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
        HomeViewModel>(
    FragmentHomeBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: HomeViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}