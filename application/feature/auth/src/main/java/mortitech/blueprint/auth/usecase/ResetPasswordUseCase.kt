package mortitech.blueprint.auth.usecase

import mortitech.blueprint.core.data.remote.contract.AuthenticationRemoteService
import mortitech.blueprint.core.exception.InvalidInputException

class ResetPasswordUseCase
constructor (
    private val networkService: AuthenticationRemoteService
) {
    @Throws(InvalidInputException::class)
    suspend operator fun invoke(username: String) {

        if (username.isEmpty())
            throw InvalidInputException("User name cannot be empty")

        networkService.resetPinCode(
            username = username
        )
    }
}