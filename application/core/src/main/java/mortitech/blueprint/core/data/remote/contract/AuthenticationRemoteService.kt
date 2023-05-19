package mortitech.blueprint.core.data.remote.contract

import mortitech.blueprint.core.domain.model.UserSession

interface AuthenticationRemoteService {
    suspend fun login(username: String, password: String): UserSession
    suspend fun signup(
        fullName: String,
        gender: Int,
        birthDate: Long,
        username: String,
        password: String
    ): UserSession
    suspend fun resetPinCode(username: String)
}