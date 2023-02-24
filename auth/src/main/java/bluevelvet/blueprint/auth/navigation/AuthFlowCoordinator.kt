package bluevelvet.blueprint.auth.navigation

import bluevelvet.blueprint.auth.R
import bluevelvet.blueprint.auth.presentation.login.LoginFragmentDirections
import bluevelvet.blueprint.navigation.coordinator.Coordinator
import bluevelvet.blueprint.navigation.event.CoordinatorEvent
import bluevelvet.blueprint.navigation.navigator.FeatureNavigator
import bluevelvet.blueprint.navigation.navigator.StartDestination
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthFlowCoordinator
@Inject
constructor(
    featureNavigator: FeatureNavigator,
): Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        return StartDestination(destination = R.id.navLoginFragment)
    }

    override fun onEvent(event: CoordinatorEvent): Boolean {
        return when (event) {
            is AuthCoordinatorEvent.ForgotPinCode -> toForgotPinCode()
            is AuthCoordinatorEvent.BackToLogin -> goBack()
            is AuthCoordinatorEvent.AccountFlow -> toAccountFlow()
            is AuthCoordinatorEvent.OnboardingFlow -> toOnboardingFlow()
            else -> false
        }
    }

    private fun toForgotPinCode(): Boolean {
        navController?.navigate(LoginFragmentDirections.actionLoginToForgotPassword())
        return true
    }

    private fun toAccountFlow(): Boolean {
        activity?.startActivity(featureNavigator.account())
        activity?.finish()
        return true
    }

    private fun toOnboardingFlow(): Boolean {
        activity?.startActivity(featureNavigator.onboarding())
        activity?.finish()
        return true
    }
}
