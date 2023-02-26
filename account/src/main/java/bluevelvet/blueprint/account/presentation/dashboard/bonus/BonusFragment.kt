package bluevelvet.blueprint.account.presentation.dashboard.bonus

import androidx.fragment.app.viewModels
import bluevelvet.blueprint.account.databinding.FragmentBonusBinding
import bluevelvet.blueprint.core.ui.ToolbarConfiguration
import bluevelvet.blueprint.core.ui.base.BaseFragment
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewState
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