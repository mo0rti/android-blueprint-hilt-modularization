package bluevelvet.blueprint.auth.presentation.resetPinCode

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import bluevelvet.blueprint.auth.databinding.FragmentForgotPasswordBinding
import bluevelvet.blueprint.core.base.view.BaseFragment
import bluevelvet.blueprint.core.base.view.ToolbarConfiguration
import bluevelvet.blueprint.style.view.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : BaseFragment<
        FragmentForgotPasswordBinding,
        ForgotPasswordViewContract.State,
        ForgotPasswordViewContract.Event,
        ForgotPasswordViewContract.Effect,
        ForgotPasswordViewModel>(
    FragmentForgotPasswordBinding::inflate,
    ToolbarConfiguration(title = "")
) {

    override val viewModel: ForgotPasswordViewModel by viewModels()
    override fun initializeComponents() {
        binding.btnResetPassword.setOnClickListener {
            postEvent(ForgotPasswordViewContract.Event.OnResetButtonClicked)
        }
        binding.tvBackToLogin.setOnClickListener {
            postEvent(ForgotPasswordViewContract.Event.OnBackToLoginLinkClicked)
        }
        binding.edtUserName.doOnTextChanged { text, _, _, _ ->
            postEvent(ForgotPasswordViewContract.Event.OnUserNameTextChanged(text.toString()))
        }
    }

    override fun onViewEffectReceived(viewEffect: ForgotPasswordViewContract.Effect) {
        when(viewEffect) {
            is ForgotPasswordViewContract.Effect.ShowErrorToast -> {
                showToast(viewEffect.error)
            }
            is ForgotPasswordViewContract.Effect.ShowSuccessDialog -> {
                showDialog(getString(viewEffect.message))
            }
        }
    }

    override fun onViewStateChange(viewState: ForgotPasswordViewContract.State) {
        binding.pbLoading.setVisibility(viewState.isLoading)
        binding.grpInput.setVisibility(!viewState.isLoading)
        binding.btnResetPassword.isEnabled = !viewState.isLoading
    }
}
