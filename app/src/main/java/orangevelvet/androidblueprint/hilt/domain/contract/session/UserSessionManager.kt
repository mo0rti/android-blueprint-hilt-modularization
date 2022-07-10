package orangevelvet.androidblueprint.hilt.domain.contract.session

interface UserSessionManager {
    fun isUserAuthenticated(): Boolean
    fun logout()
    fun login()
}