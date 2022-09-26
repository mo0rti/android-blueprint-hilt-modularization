package bluevelvet.blueprint.core.domain.contract.network

import bluevelvet.blueprint.core.domain.model.ActiveSession

/**
 * Created by Morteza Taghdisi on 23 Sep 2022
 * https://github.com/mo0rti
 */

interface AuthNetworkService {
    suspend fun login(userId: String, pinCode: String): ActiveSession
    suspend fun signup(userId: String, pinCode: String): ActiveSession
    suspend fun resetPinCode(userId: String)
}