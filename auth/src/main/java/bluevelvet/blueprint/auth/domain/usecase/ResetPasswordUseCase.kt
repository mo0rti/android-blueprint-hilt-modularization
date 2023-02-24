package bluevelvet.blueprint.auth.domain.usecase

import bluevelvet.blueprint.core.contract.network.AuthNetworkService
import bluevelvet.blueprint.core.exception.InvalidInputException

class ResetPasswordUseCase
constructor (
    private val networkService: AuthNetworkService
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