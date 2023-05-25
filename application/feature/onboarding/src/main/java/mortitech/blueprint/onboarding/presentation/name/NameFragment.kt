package mortitech.blueprint.onboarding.presentation.name

import androidx.fragment.app.viewModels
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewAction
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import mortitech.blueprint.onboarding.databinding.FragmentNameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NameFragment: BaseFragment<
        FragmentNameBinding,
        EmptyViewState,
        EmptyViewAction,
        EmptyViewEvent,
        NameViewModel>(
    FragmentNameBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: NameViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEventReceived(viewEvent: EmptyViewEvent) {
    }

    override fun onViewStateChanged(viewState: EmptyViewState) {
    }
}