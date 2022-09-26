package bluevelvet.blueprint.auth.business

import bluevelvet.blueprint.core.domain.contract.network.AuthNetworkService
import bluevelvet.blueprint.core.domain.exception.InvalidInputException
import kotlin.jvm.Throws

/**
 * Created by Morteza Taghdisi on 23 Sep 2022
 * https://github.com/mo0rti
 */

class SignupUseCase
constructor (
    private val networkService: AuthNetworkService
) {
    @Throws(InvalidInputException::class)
    suspend operator fun invoke(userId: String, pinCode: String) {

        if (userId.isEmpty())
            throw InvalidInputException("Invalid user id")
        if (pinCode.length < 6)
            throw InvalidInputException("Invalid pin code")

        networkService.signup(
            userId = userId,
            pinCode = pinCode
        )
    }
}