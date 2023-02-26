package bluevelvet.blueprint.account.presentation.dashboard.cart

import androidx.fragment.app.viewModels
import bluevelvet.blueprint.account.databinding.FragmentCartBinding
import bluevelvet.blueprint.core.ui.ToolbarConfiguration
import bluevelvet.blueprint.core.ui.base.BaseFragment
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewState
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