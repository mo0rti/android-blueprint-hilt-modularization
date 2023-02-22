package bluevelvet.blueprint.auth.presentation.login

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import bluevelvet.blueprint.auth.databinding.FragmentLoginBinding
import bluevelvet.blueprint.core.base.view.BaseFragment
import bluevelvet.blueprint.core.base.view.ToolbarConfiguration
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
        binding.edtPassword.doOnTextChanged { text, _, _, _ ->
            postEvent(LoginViewContract.Event.OnPasswordTextChanged(text.toString()))
        }
        binding.edtUserName.doOnTextChanged { text, _, _, _ ->
            postEvent(LoginViewContract.Event.OnUserNameTextChanged(text.toString()))
        }

        // Collect view state
        lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect {
                binding.loadingIndicator.setVisibility(it.isLoading)
                binding.lytInputs.setVisibility(!it.isLoading)
                binding.btnLogin.isEnabled = !it.isLoading
            }
        }

        // Collect view effect
        lifecycleScope.launchWhenStarted {
            viewModel.viewEffect.collect {
                when(it) {
                    LoginViewContract.Effect.ShowToast -> {
                        showToast(viewModel.viewState.value.error!!)
                    }
                }
            }
        }
    }
}