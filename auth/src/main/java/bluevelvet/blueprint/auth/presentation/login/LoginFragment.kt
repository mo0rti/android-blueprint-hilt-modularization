package bluevelvet.blueprint.auth.presentation.login

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import bluevelvet.blueprint.auth.databinding.FragmentLoginBinding
import bluevelvet.blueprint.core.base.ui.BaseFragment
import bluevelvet.blueprint.core.base.ui.ToolbarConfiguration
import bluevelvet.blueprint.style.view.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<
        FragmentLoginBinding,
        LoginViewContract.State,
        LoginViewContract.Event,
        LoginViewContract.Effect,
        LoginViewModel>(
    FragmentLoginBinding::inflate,
    ToolbarConfiguration(title = "")
) {

    override val viewModel: LoginViewModel by viewModels()

    override fun initializeComponents() {
        binding.btnLogin.setOnClickListener {
            postEvent(LoginViewContract.Event.OnLoginButtonClicked)
        }
        binding.tvForgotPassword.setOnClickListener {
            postEvent(LoginViewContract.Event.OnForgotPasswordLinkClicked)
        }
        binding.tvSignup.setOnClickListener {
            postEvent(LoginViewContract.Event.OnSignupLinkClicked)
        }
        binding.edtPassword.doOnTextChanged { text, _, _, _ ->
            postEvent(LoginViewContract.Event.OnPasswordTextChanged(text.toString()))
        }
        binding.edtUserName.doOnTextChanged { text, _, _, _ ->
            postEvent(LoginViewContract.Event.OnUserNameTextChanged(text.toString()))
        }
    }

    override fun onViewEffectReceived(viewEffect: LoginViewContract.Effect) {
        when(viewEffect) {
            is LoginViewContract.Effect.ShowErrorToast -> {
                showToast(viewEffect.error)
            }
        }
    }

    override fun onViewStateChange(viewState: LoginViewContract.State) {
        binding.pbLoading.setVisibility(viewState.isLoading)
        binding.grpInput.setVisibility(!viewState.isLoading)
        binding.btnLogin.isEnabled = !viewState.isLoading
    }
}