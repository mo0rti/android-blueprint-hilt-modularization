package mortitech.blueprint.core.manager

import mortitech.blueprint.core.manager.contract.ApplicationStateManager
import mortitech.blueprint.core.manager.contract.UserSessionManager
import javax.inject.Inject

class UserSessionManagerImpl
@Inject
constructor(
    private val applicationStateManager: ApplicationStateManager
): UserSessionManager {

    private var _accessToken: String

    init {
        // on initialization of the project we can check if the user is logged in before
        _accessToken = applicationStateManager.loadState().isUserRegistered
    }

    override fun isUserAuthenticated(): Boolean {
        return _accessToken.isNotEmpty()
    }

    override fun logout() {
        _accessToken = ""
    }

    override fun login() {
        val applicationState = applicationStateManager.loadState()
        applicationStateManager.saveState(
            applicationState.copy(
                isUserRegistered = _accessToken
            ))
    }
}