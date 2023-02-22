package bluevelvet.blueprint.core.contract.network

import bluevelvet.blueprint.core.model.UserSession

/**
 * Created by Morteza Taghdisi on 23 Sep 2022
 * https://github.com/mo0rti
 */

interface AuthNetworkService {
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