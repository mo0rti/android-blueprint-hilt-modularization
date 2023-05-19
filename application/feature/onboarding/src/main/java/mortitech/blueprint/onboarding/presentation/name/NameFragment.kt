package mortitech.blueprint.onboarding.presentation.name

import androidx.fragment.app.viewModels
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEffect
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import mortitech.blueprint.onboarding.databinding.FragmentNameBinding
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