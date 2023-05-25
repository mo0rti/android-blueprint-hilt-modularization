package mortitech.blueprint.account.presentation.dashboard.cart

import androidx.fragment.app.viewModels
import mortitech.blueprint.account.databinding.FragmentCartBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewAction
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment: BaseFragment<
        FragmentCartBinding,
        EmptyViewState,
        EmptyViewAction,
        EmptyViewEvent,
        CartViewModel>(
    FragmentCartBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: CartViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEventReceived(viewEvent: EmptyViewEvent) {
    }

    override fun onViewStateChanged(viewState: EmptyViewState) {
    }
}