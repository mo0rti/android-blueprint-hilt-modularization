package bluevelvet.blueprint.core.domain.contract.session

interface UserSessionManager {
    fun isUserAuthenticated(): Boolean
    fun logout()
    fun login()
}