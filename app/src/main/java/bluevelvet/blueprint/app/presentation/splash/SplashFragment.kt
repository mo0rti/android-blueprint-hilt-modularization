package bluevelvet.blueprint.app.presentation.splash

import androidx.fragment.app.viewModels
import bluevelvet.blueprint.app.databinding.FragmentSplashBinding
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.view.BaseFragment
import bluevelvet.blueprint.core.base.view.ToolbarConfiguration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class SplashFragment: BaseFragment<
        FragmentSplashBinding,
        EmptyViewState,
        SplashViewContract.Event,
        EmptyViewEffect,
        SplashViewModel>(
    FragmentSplashBinding::inflate,
    ToolbarConfiguration(isVisible = false)
), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override val viewModel: SplashViewModel by viewModels()

    override fun initializeComponents() {
        launch {
            // TODO: You can wait for an api call to finish and then go to the next screen.
            delay(2000)
            postEvent(SplashViewContract.Event.GotoNextScreen)
        }
    }
}
