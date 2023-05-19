package mortitech.blueprint.account.presentation.dashboard.bonus

import androidx.fragment.app.viewModels
import mortitech.blueprint.account.databinding.FragmentBonusBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEffect
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BonusFragment: BaseFragment<
        FragmentBonusBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
        BonusViewModel>(
    FragmentBonusBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: BonusViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}