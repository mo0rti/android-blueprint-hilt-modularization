package mortitech.blueprint.auth.presentation.login

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import mortitech.blueprint.auth.databinding.FragmentLoginBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.style.view.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<
        FragmentLoginBinding,
        LoginViewContract.State,
        LoginViewContract.Action,
        LoginViewContract.Event,
        LoginViewModel>(
    FragmentLoginBinding::inflate,
    ToolbarConfiguration(title = "")
) {

    override val viewModel: LoginViewModel by viewModels()

    override fun initializeComponents() {
        binding.btnLogin.setOnClickListener {
            postAction(LoginViewContract.Action.OnLoginButtonClicked)
        }
        binding.tvForgotPassword.setOnClickListener {
            postAction(LoginViewContract.Action.OnForgotPasswordLinkClicked)
        }
        binding.tvSignup.setOnClickListener {
            postAction(LoginViewContract.Action.OnSignupLinkClicked)
        }
        binding.edtPassword.doOnTextChanged { text, _, _, _ ->
            postAction(LoginViewContract.Action.OnPasswordTextChanged(text.toString()))
        }
        binding.edtUserName.doOnTextChanged { text, _, _, _ ->
            postAction(LoginViewContract.Action.OnUserNameTextChanged(text.toString()))
        }
    }

    override fun onViewEventReceived(viewEvent: LoginViewContract.Event) {
        when(viewEvent) {
            is LoginViewContract.Event.ShowErrorToast -> {
                showToast(viewEvent.error)
            }
        }
    }

    override fun onViewStateChanged(viewState: LoginViewContract.State) {
        binding.pbLoading.setVisibility(viewState.isLoading)
        binding.grpInput.setVisibility(!viewState.isLoading)
        binding.btnLogin.isEnabled = !viewState.isLoading
    }
}