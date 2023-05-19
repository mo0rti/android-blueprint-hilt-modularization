package mortitech.blueprint.auth.data.service

import mortitech.blueprint.auth.data.model.LoginRequestDtoModel
import mortitech.blueprint.auth.data.model.LoginResponseDtoModel
import mortitech.blueprint.auth.data.model.SignupRequestDtoModel
import mortitech.blueprint.auth.data.model.SignupResponseDtoModel
import mortitech.blueprint.core.data.remote.contract.AuthenticationRemoteService
import mortitech.blueprint.core.domain.model.UserSession
import kotlinx.coroutines.delay

/**
 * Authentication network service for Login and Signup flows
 */
class AuthenticationRemoteServiceImpl: AuthenticationRemoteService {
    override suspend fun login(username: String, password: String): UserSession {
        val request = LoginRequestDtoModel(
            username = username,
            password = password
        )

        // TODO: make the api call here using LoginRequestDto
        delay(1000)

        val response = LoginResponseDtoModel(
            accessToken = "access token",
            refreshToken = "refresh token"
        )
        return UserSession(response.accessToken, response.refreshToken)
    }

    override suspend fun signup(
        fullName: String,
        gender: Int,
        birthDate: Long,
        username: String,
        password: String
    ): UserSession {
        val request = SignupRequestDtoModel(
            fullName = fullName,
            gender = gender,
            birthDate = birthDate,
            username = username,
            password = password
        )
        // TODO: make the api call here using SignupRequestDto
        delay(1000)

        val response = SignupResponseDtoModel(
            accessToken = "access token",
            refreshToken = "refresh token"
        )
        return UserSession(response.accessToken, response.refreshToken)
    }

    override suspend fun resetPinCode(username: String) {
        // TODO: make the api call here using LoginRequestDto
        delay(1000)
    }
}