package orangevelvet.androidblueprint.hilt.presentation.navigation.coordinators

import orangevelvet.androidblueprint.hilt.R
import orangevelvet.androidblueprint.hilt.domain.contract.session.UserSessionManager
import orangevelvet.androidblueprint.hilt.presentation.navigation.events.AccountCoordinatorEvent
import orangevelvet.androidblueprint.navigation.coordinator.Coordinator
import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent
import orangevelvet.androidblueprint.navigation.navigator.FeatureNavigator
import orangevelvet.androidblueprint.navigation.navigator.StartDestination
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
        activity?.startActivity(featureNavigator.main())
        activity?.finish()
        return true
    }
}
