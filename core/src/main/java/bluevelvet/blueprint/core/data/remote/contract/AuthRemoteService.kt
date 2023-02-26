package bluevelvet.blueprint.core.data.remote.contract

import bluevelvet.blueprint.core.domain.model.UserSession

interface AuthRemoteService {
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