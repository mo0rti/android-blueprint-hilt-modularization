package bluevelvet.blueprint.core.manager

import bluevelvet.blueprint.core.contract.session.ApplicationStateManager
import bluevelvet.blueprint.core.contract.session.UserSessionManager
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
        //return _accessToken.isNotEmpty()
        return true
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