package bluevelvet.blueprint.account.navigation

import bluevelvet.blueprint.account.R
import bluevelvet.blueprint.core.contract.session.UserSessionManager
import bluevelvet.blueprint.navigation.coordinator.Coordinator
import bluevelvet.blueprint.navigation.event.CoordinatorEvent
import bluevelvet.blueprint.navigation.navigator.FeatureNavigator
import bluevelvet.blueprint.navigation.navigator.StartDestination
import javax.inject.Inject

class AccountFlowCoordinator
@Inject
constructor(
    featureNavigator: FeatureNavigator,
    private val userSessionManager: UserSessionManager,
) : Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        return StartDestination(destination = R.id.navDashboardFragment, args = null)
    }

    override fun onEvent(event: CoordinatorEvent): Boolean {
        return when (event) {
            is AccountCoordinatorEvent.Logout -> logout()
            else -> false
        }
    }

    override fun onPop() {
    }

    private fun logout(): Boolean {
        userSessionManager.logout()
        activity?.startActivity(featureNavigator.app())
        activity?.finish()
        return true
    }
}
