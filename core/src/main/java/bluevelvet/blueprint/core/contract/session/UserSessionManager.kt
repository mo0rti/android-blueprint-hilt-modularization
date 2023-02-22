package bluevelvet.blueprint.core.contract.session

interface UserSessionManager {
    fun isUserAuthenticated(): Boolean
    fun logout()
    fun login()
}