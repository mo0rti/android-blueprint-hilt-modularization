package bluevelvet.blueprint.auth.domain.usecase

import bluevelvet.blueprint.core.data.remote.contract.AuthRemoteService
import bluevelvet.blueprint.core.exception.InvalidInputException

class ResetPasswordUseCase
constructor (
    private val networkService: AuthRemoteService
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