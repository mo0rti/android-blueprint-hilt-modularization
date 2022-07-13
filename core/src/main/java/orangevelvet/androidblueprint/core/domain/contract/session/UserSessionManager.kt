package orangevelvet.androidblueprint.core.domain.contract.session

interface UserSessionManager {
    fun isUserAuthenticated(): Boolean
    fun logout()
    fun login()
}