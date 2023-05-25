package mortitech.blueprint.account.presentation.dashboard.settings

import androidx.fragment.app.viewModels
import mortitech.blueprint.account.databinding.FragmentSettingsBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewAction
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment: BaseFragment<
        FragmentSettingsBinding,
        EmptyViewState,
        EmptyViewAction,
        EmptyViewEvent,
        SettingsViewModel>(
    FragmentSettingsBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: SettingsViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEventReceived(viewEvent: EmptyViewEvent) {
    }

    override fun onViewStateChanged(viewState: EmptyViewState) {
    }
}