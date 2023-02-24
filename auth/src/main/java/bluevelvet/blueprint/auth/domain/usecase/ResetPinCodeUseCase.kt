package bluevelvet.blueprint.auth.domain.usecase

import bluevelvet.blueprint.core.contract.network.AuthNetworkService
import bluevelvet.blueprint.core.exception.InvalidInputException

/**
 * Created by Morteza Taghdisi on 23 Sep 2022
 * https://github.com/mo0rti
 */

class ResetPinCodeUseCase
constructor (
    private val networkService: AuthNetworkService
) {
    @Throws(InvalidInputException::class)
    suspend operator fun invoke(userId: String) {

        if (userId.isEmpty())
            throw InvalidInputException("Invalid user id")

        networkService.resetPinCode(
            username = userId
        )
    }
}