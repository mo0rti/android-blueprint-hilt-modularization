package bluevelvet.blueprint.onboarding.navigation

import bluevelvet.blueprint.navigation.coordinator.Coordinator
import bluevelvet.blueprint.navigation.event.CoordinatorEvent
import bluevelvet.blueprint.navigation.navigator.FeatureNavigator
import bluevelvet.blueprint.navigation.navigator.StartDestination
import bluevelvet.blueprint.onboarding.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OnboardingFlowCoordinator
@Inject
constructor(
    featureNavigator: FeatureNavigator,
): Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        return StartDestination(destination = R.id.navNameFragment)
    }

    override fun onEvent(event: CoordinatorEvent): Boolean {
        return when (event) {
            is OnboardingCoordinatorEvent.BackToLogin -> goBack()
            is OnboardingCoordinatorEvent.AccountFlow -> toAccountFlow()
            else -> false
        }
    }

    private fun toAccountFlow(): Boolean {
        activity?.startActivity(featureNavigator.account())
        activity?.finish()
        return true
    }
}
