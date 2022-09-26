package bluevelvet.blueprint.app.presentation.splash

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.view.BaseFragment
import bluevelvet.blueprint.core.base.view.ToolbarConfiguration
import bluevelvet.blueprint.app.databinding.FragmentSplashBinding
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class SplashFragment: BaseFragment<
        FragmentSplashBinding,
        EmptyViewState,
        EmptyViewEvent,
        SplashViewAction,
        SplashViewModel>(
    FragmentSplashBinding::inflate,
    ToolbarConfiguration(isVisible = false)
), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override val viewModel: SplashViewModel by viewModels()

    override fun initializeComponents() {
        launch {
            delay(2000)
            postAction(SplashViewAction.GotoNextScreenAction)
        }
    }
}
