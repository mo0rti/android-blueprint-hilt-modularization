package mortitech.blueprint.account.navigation

import mortitech.blueprint.account.R
import mortitech.blueprint.core.manager.contract.UserSessionManager
import mortitech.blueprint.navigation.coordinator.Coordinator
import mortitech.blueprint.navigation.event.CoordinatorEvent
import mortitech.blueprint.navigation.navigator.FeatureNavigator
import mortitech.blueprint.navigation.navigator.StartDestination
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
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

    private fun logout(): Boolean {
        userSessionManager.logout()
        activity?.startActivity(featureNavigator.app())
        activity?.finish()
        return true
    }
}
