package bluevelvet.blueprint.account.presentation.dashboard

import androidx.fragment.app.viewModels
import bluevelvet.blueprint.account.databinding.FragmentDashboardBinding
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.view.BaseFragment
import bluevelvet.blueprint.core.base.view.ToolbarConfiguration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment: BaseFragment<
        FragmentDashboardBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
        DashboardViewModel>(
    FragmentDashboardBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: DashboardViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}