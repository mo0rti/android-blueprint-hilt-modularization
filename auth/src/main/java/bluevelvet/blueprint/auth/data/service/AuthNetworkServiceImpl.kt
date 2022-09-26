package bluevelvet.blueprint.auth.data.service

import bluevelvet.blueprint.core.domain.contract.network.AuthNetworkService
import bluevelvet.blueprint.core.domain.model.ActiveSession

/**
 * Created by Morteza Taghdisi on 23 Sep 2022
 * https://github.com/mo0rti
 */

class AuthNetworkServiceImpl: AuthNetworkService {
    override suspend fun login(userId: String, pinCode: String): ActiveSession {
        // TODO: make the api call here using LoginRequestDto
        return ActiveSession("A", "R")
    }

    override suspend fun signup(userId: String, pinCode: String): ActiveSession {
        return ActiveSession("A", "R")
    }

    override suspend fun resetPinCode(userId: String) {
        // TODO: send data to api
    }
}