package bluevelvet.blueprint.onboarding.presentation.name

import androidx.fragment.app.viewModels
import bluevelvet.blueprint.core.ui.ToolbarConfiguration
import bluevelvet.blueprint.core.ui.base.BaseFragment
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewState
import bluevelvet.blueprint.onboarding.databinding.FragmentNameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NameFragment: BaseFragment<
        FragmentNameBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
        NameViewModel>(
    FragmentNameBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: NameViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}