package mortitech.blueprint.app.presentation.splash

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import mortitech.blueprint.app.databinding.FragmentSplashBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEffect
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class SplashFragment: BaseFragment<
        FragmentSplashBinding,
        EmptyViewState,
        SplashViewContract.Event,
        EmptyViewEffect,
        SplashViewModel>(
    FragmentSplashBinding::inflate,
    ToolbarConfiguration(isVisible = false)
) {
    override val viewModel: SplashViewModel by viewModels()

    override fun initializeComponents() {
        lifecycleScope.launchWhenStarted {
            // TODO: You can wait for an api call to finish and then go to the next screen.
            delay(500)
            postEvent(SplashViewContract.Event.GotoNextScreen)
        }
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}
