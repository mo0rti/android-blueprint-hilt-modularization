package bluevelvet.blueprint.account.presentation.dashboard.cart

import androidx.fragment.app.viewModels
import bluevelvet.blueprint.account.databinding.FragmentCartBinding
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.ui.BaseFragment
import bluevelvet.blueprint.core.base.ui.ToolbarConfiguration
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