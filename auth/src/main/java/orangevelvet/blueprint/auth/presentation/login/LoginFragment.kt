package orangevelvet.blueprint.auth.presentation.login

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import orangevelvet.blueprint.auth.databinding.FragmentLoginBinding
import orangevelvet.blueprint.auth.presentation.login.state.LoginViewAction
import orangevelvet.blueprint.auth.presentation.login.state.LoginViewEvent
import orangevelvet.blueprint.auth.presentation.login.state.LoginViewState
import orangevelvet.blueprint.core.base.view.BaseFragment
import orangevelvet.blueprint.core.base.view.ToolbarConfiguration

@AndroidEntryPoint
class LoginFragment : BaseFragment<
        FragmentLoginBinding,
        LoginViewState,
        LoginViewEvent,
        LoginViewAction,
        LoginViewModel>(
    FragmentLoginBinding::inflate,
    ToolbarConfiguration(title = "")
) {

    override val viewModel: LoginViewModel by viewModels()

    override fun initializeComponents() {
        postAction(LoginViewAction.InitializeAction)
        binding.pinPad.isEnabled = false
    }
}