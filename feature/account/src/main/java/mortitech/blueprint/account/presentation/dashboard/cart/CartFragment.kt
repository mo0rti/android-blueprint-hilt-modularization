package mortitech.blueprint.account.presentation.dashboard.cart

import androidx.fragment.app.viewModels
import mortitech.blueprint.account.databinding.FragmentCartBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEffect
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment: BaseFragment<
        FragmentCartBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
        CartViewModel>(
    FragmentCartBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: CartViewModel by viewModels()

    override fun initializeComponents() {
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}