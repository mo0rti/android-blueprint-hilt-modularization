package orangevelvet.androidblueprint.hilt.presentation.ui.main.splash

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import orangevelvet.androidblueprint.core.base.state.view.empty.EmptyViewEvent
import orangevelvet.androidblueprint.core.base.state.view.empty.EmptyViewState
import orangevelvet.androidblueprint.core.base.view.BaseFragment
import orangevelvet.androidblueprint.core.base.view.ToolbarConfiguration
import orangevelvet.androidblueprint.hilt.databinding.FragmentSplashBinding
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class SplashFragment: BaseFragment<
        FragmentSplashBinding,
        EmptyViewState,
        EmptyViewEvent,
        SplashViewAction,
        SplashViewModel
        >
    (
    FragmentSplashBinding::inflate,
    ToolbarConfiguration(isVisible = false)
), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override val viewModel: SplashViewModel by viewModels()

    override fun initializeComponents() {
        launch {
            delay(500)
            postAction(SplashViewAction.GotoNextScreenAction)
        }
    }
}
