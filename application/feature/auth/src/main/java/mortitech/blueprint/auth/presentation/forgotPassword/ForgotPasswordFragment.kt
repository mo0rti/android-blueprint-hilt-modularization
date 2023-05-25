package mortitech.blueprint.auth.presentation.forgotPassword

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import mortitech.blueprint.auth.databinding.FragmentForgotPasswordBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.style.view.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : BaseFragment<
        FragmentForgotPasswordBinding,
        ForgotPasswordViewContract.State,
        ForgotPasswordViewContract.Action,
        ForgotPasswordViewContract.Event,
        ForgotPasswordViewModel>(
    FragmentForgotPasswordBinding::inflate,
    ToolbarConfiguration(title = "")
) {

    override val viewModel: ForgotPasswordViewModel by viewModels()
    override fun initializeComponents() {
        binding.btnResetPassword.setOnClickListener {
            postAction(ForgotPasswordViewContract.Action.OnResetButtonClicked)
        }
        binding.tvBackToLogin.setOnClickListener {
            postAction(ForgotPasswordViewContract.Action.OnBackToLoginLinkClicked)
        }
        binding.edtUserName.doOnTextChanged { text, _, _, _ ->
            postAction(ForgotPasswordViewContract.Action.OnUserNameTextChanged(text.toString()))
        }
    }

    override fun onViewEventReceived(viewEvent: ForgotPasswordViewContract.Event) {
        when(viewEvent) {
            is ForgotPasswordViewContract.Event.ShowErrorToast -> {
                showToast(viewEvent.error)
            }
            is ForgotPasswordViewContract.Event.ShowSuccessDialog -> {
                showDialog(getString(viewEvent.message))
            }
        }
    }

    override fun onViewStateChanged(viewState: ForgotPasswordViewContract.State) {
        binding.pbLoading.setVisibility(viewState.isLoading)
        binding.grpInput.setVisibility(!viewState.isLoading)
        binding.btnResetPassword.isEnabled = !viewState.isLoading
    }
}
