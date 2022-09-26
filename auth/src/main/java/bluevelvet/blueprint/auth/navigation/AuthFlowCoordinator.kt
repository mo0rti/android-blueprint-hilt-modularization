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
            is AuthCoordinatorEvent.AccountFlow -> toAccountFlow()
            else -> false
        }
    }

    override fun onPop() {
    }

    private fun toForgotPinCode(): Boolean {
        navController?.navigate(LoginFragmentDirections.actionLoginToForgotPinCode())
        return true
    }

    private fun toAccountFlow(): Boolean {
        activity?.startActivity(featureNavigator.account())
        activity?.finish()
        return true
    }
}
