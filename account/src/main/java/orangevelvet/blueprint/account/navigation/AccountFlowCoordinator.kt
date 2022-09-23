package orangevelvet.blueprint.account.navigation

import orangevelvet.blueprint.account.R
import orangevelvet.blueprint.core.domain.contract.session.UserSessionManager
import orangevelvet.blueprint.navigation.coordinator.Coordinator
import orangevelvet.blueprint.navigation.event.CoordinatorEvent
import orangevelvet.blueprint.navigation.navigator.FeatureNavigator
import orangevelvet.blueprint.navigation.navigator.StartDestination
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
