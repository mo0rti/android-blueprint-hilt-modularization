package bluevelvet.blueprint.account.presentation.dashboard.settings

import androidx.fragment.app.viewModels
import androidx.navigation.ui.setupWithNavController
import bluevelvet.blueprint.account.databinding.FragmentDashboardBinding
import bluevelvet.blueprint.account.databinding.FragmentHomeBinding
import bluevelvet.blueprint.account.databinding.FragmentSettingsBinding
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.view.BaseFragment
import bluevelvet.blueprint.core.base.view.ToolbarConfiguration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment: BaseFragment<
        FragmentSettingsBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
        SettingsViewModel>(
    FragmentSettingsBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: SettingsViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}