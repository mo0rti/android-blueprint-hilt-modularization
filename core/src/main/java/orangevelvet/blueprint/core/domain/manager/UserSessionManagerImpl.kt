package orangevelvet.blueprint.core.domain.manager

import orangevelvet.blueprint.core.domain.contract.session.ApplicationStateManager
import orangevelvet.blueprint.core.domain.contract.session.UserSessionManager
import javax.inject.Inject

class UserSessionManagerImpl
@Inject
constructor(
    private val applicationStateManager: ApplicationStateManager
): UserSessionManager {

    private var _accessToken: String

    init {
        _accessToken = applicationStateManager.loadState().authToken
    }

    override fun isUserAuthenticated(): Boolean {
        return _accessToken.isNotEmpty()
    }

    override fun logout() {
        _accessToken = ""
    }

    override fun login() {
        _accessToken = "AAA"
        val applicationState = applicationStateManager.loadState()
        applicationStateManager.saveState(
            applicationState.copy(
                authToken = _accessToken
            ))
    }
}