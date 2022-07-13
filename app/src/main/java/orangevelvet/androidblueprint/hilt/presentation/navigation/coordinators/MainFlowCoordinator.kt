package orangevelvet.androidblueprint.hilt.presentation.navigation.coordinators

import orangevelvet.androidblueprint.hilt.R
import orangevelvet.androidblueprint.hilt.presentation.navigation.events.MainCoordinatorEvent
import orangevelvet.androidblueprint.navigation.coordinator.Coordinator
import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent
import orangevelvet.androidblueprint.navigation.navigator.FeatureNavigator
import orangevelvet.androidblueprint.navigation.navigator.StartDestination
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainFlowCoordinator
@Inject
constructor(
    featureNavigator: FeatureNavigator,
) : Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        return StartDestination(destination = R.id.navSplashFragment)
    }

    override fun onEvent(event: CoordinatorEvent): Boolean {
        return when (event) {
            is MainCoordinatorEvent.AuthFlow -> toLogin()
            is MainCoordinatorEvent.AccountFlow -> toAccountFlow()
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
        activity?.startActivity(featureNavigator.auth())
        activity?.finish()
        return true
    }
}
