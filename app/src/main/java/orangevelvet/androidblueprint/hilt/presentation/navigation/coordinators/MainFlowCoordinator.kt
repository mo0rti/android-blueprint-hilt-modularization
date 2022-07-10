package orangevelvet.androidblueprint.hilt.presentation.navigation.coordinators

import orangevelvet.androidblueprint.hilt.R
import orangevelvet.androidblueprint.hilt.domain.contract.session.UserSessionManager
import orangevelvet.androidblueprint.hilt.presentation.navigation.events.MainCoordinatorEvent
import orangevelvet.androidblueprint.hilt.presentation.navigation.navigators.Coordinator
import orangevelvet.androidblueprint.hilt.presentation.navigation.navigators.FeatureNavigator
import orangevelvet.androidblueprint.hilt.presentation.navigation.navigators.StartDestination
import orangevelvet.androidblueprint.hilt.presentation.ui.main.splash.SplashFragmentDirections
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainFlowCoordinator
@Inject
constructor(
    featureNavigator: FeatureNavigator,
    private val userSessionManager: UserSessionManager,
) : Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        return if (userSessionManager.isUserAuthenticated())
            StartDestination(destination = R.id.navLoginFragment)
        else
            StartDestination(destination = R.id.navSplashFragment)
    }

    override fun onEvent(event: Any): Boolean {
        return when (event) {
            is MainCoordinatorEvent.Login -> toLogin()
            is MainCoordinatorEvent.Account -> toAccountFlow()
            else -> false
        }
    }

    override fun onPop() {
    }

    private fun toAccountFlow(): Boolean {
        activity?.startActivity(featureNavigator.account())
        activity?.finish()
        return true
    }

    private fun toLogin(): Boolean {
        navController?.navigate(SplashFragmentDirections.actionSplashToLogin())
        return true
    }
}
