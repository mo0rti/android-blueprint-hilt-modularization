package orangevelvet.androidblueprint.auth.navigation

import orangevelvet.androidblueprint.auth.R
import orangevelvet.androidblueprint.auth.presentation.login.LoginFragmentDirections
import orangevelvet.androidblueprint.navigation.coordinator.Coordinator
import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent
import orangevelvet.androidblueprint.navigation.navigator.FeatureNavigator
import orangevelvet.androidblueprint.navigation.navigator.StartDestination
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthFlowCoordinator
@Inject
constructor(
    featureNavigator: FeatureNavigator,
) : Coordinator(featureNavigator) {

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
