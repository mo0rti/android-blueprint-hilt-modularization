package bluevelvet.blueprint.onboarding.presentation.name

import androidx.fragment.app.viewModels
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.ui.BaseFragment
import bluevelvet.blueprint.core.base.ui.ToolbarConfiguration
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