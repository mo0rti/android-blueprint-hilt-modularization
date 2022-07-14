package orangevelvet.blueprint.auth.presentation.login

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import orangevelvet.blueprint.auth.databinding.FragmentLoginBinding
import orangevelvet.blueprint.core.base.state.view.empty.EmptyViewAction
import orangevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import orangevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import orangevelvet.blueprint.core.base.view.BaseFragment
import orangevelvet.blueprint.core.base.view.ToolbarConfiguration

@AndroidEntryPoint
class LoginFragment : BaseFragment<
        FragmentLoginBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewAction,
        LoginViewModel>(
    FragmentLoginBinding::inflate,
    ToolbarConfiguration(title = "")
) {

    override val viewModel: LoginViewModel by viewModels()

    override fun initializeComponents() {
    }
}