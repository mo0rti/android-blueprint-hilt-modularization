package bluevelvet.blueprint.auth.data.service

import bluevelvet.blueprint.auth.data.model.LoginRequestDto
import bluevelvet.blueprint.auth.data.model.LoginResponseDto
import bluevelvet.blueprint.auth.data.model.SignupRequestDto
import bluevelvet.blueprint.auth.data.model.SignupResponseDto
import bluevelvet.blueprint.core.contract.network.AuthNetworkService
import bluevelvet.blueprint.core.model.UserSession
import kotlinx.coroutines.delay

/**
 * Authentication network service for Login and Signup flows
 */
class AuthNetworkServiceImpl: AuthNetworkService {
    override suspend fun login(username: String, password: String): UserSession {
        val request = LoginRequestDto(
            username = username,
            password = password
        )

        // TODO: make the api call here using LoginRequestDto
        delay(1000)

        val response = LoginResponseDto(
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
        val request = SignupRequestDto(
            fullName = fullName,
            gender = gender,
            birthDate = birthDate,
            username = username,
            password = password
        )
        // TODO: make the api call here using SignupRequestDto
        delay(1000)

        val response = SignupResponseDto(
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