package bluevelvet.blueprint.core.manager.contract

interface UserSessionManager {
    fun isUserAuthenticated(): Boolean
    fun logout()
    fun login()
}