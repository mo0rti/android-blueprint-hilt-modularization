package mortitech.blueprint.account.presentation.dashboard.bonus

import androidx.fragment.app.viewModels
import mortitech.blueprint.account.databinding.FragmentBonusBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewAction
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BonusFragment: BaseFragment<
        FragmentBonusBinding,
        EmptyViewState,
        EmptyViewAction,
        EmptyViewEvent,
        BonusViewModel>(
    FragmentBonusBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: BonusViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEventReceived(viewEvent: EmptyViewEvent) {
    }

    override fun onViewStateChanged(viewState: EmptyViewState) {
    }
}