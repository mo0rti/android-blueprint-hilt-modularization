package mortitech.blueprint.auth.navigation

import mortitech.blueprint.auth.R
import mortitech.blueprint.auth.presentation.login.LoginFragmentDirections
import mortitech.blueprint.navigation.coordinator.Coordinator
import mortitech.blueprint.navigation.event.CoordinatorEvent
import mortitech.blueprint.navigation.navigator.FeatureNavigator
import mortitech.blueprint.navigation.navigator.StartDestination
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
