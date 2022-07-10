package orangevelvet.androidblueprint.hilt.presentation.navigation.coordinators

import orangevelvet.androidblueprint.hilt.R
import orangevelvet.androidblueprint.hilt.domain.contract.session.UserSessionManager
import orangevelvet.androidblueprint.hilt.presentation.navigation.events.AccountCoordinatorEvent
import orangevelvet.androidblueprint.hilt.presentation.navigation.navigators.Coordinator
import orangevelvet.androidblueprint.hilt.presentation.navigation.navigators.FeatureNavigator
import orangevelvet.androidblueprint.hilt.presentation.navigation.navigators.StartDestination
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

    override fun onEvent(event: Any): Boolean {
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
