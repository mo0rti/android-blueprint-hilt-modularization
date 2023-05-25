package mortitech.blueprint.app.presentation.splash

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import mortitech.blueprint.app.databinding.FragmentSplashBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment: BaseFragment<
        FragmentSplashBinding,
        EmptyViewState,
        SplashViewContract.Action,
        EmptyViewEvent,
        SplashViewModel>(
    FragmentSplashBinding::inflate,
    ToolbarConfiguration(isVisible = false)
) {
    override val viewModel: SplashViewModel by viewModels()

    override fun initializeComponents() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // TODO: You can wait for an api call to finish and then go to the next screen.
                delay(500)
                postAction(SplashViewContract.Action.GotoNextScreen)
            }
        }
    }

    override fun onViewEventReceived(viewEvent: EmptyViewEvent) {
    }

    override fun onViewStateChanged(viewState: EmptyViewState) {
    }
}
