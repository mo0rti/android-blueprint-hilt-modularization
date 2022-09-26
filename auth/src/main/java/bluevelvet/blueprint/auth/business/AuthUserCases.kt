package bluevelvet.blueprint.auth.business

/**
 * Created by Morteza Taghdisi on 23 Sep 2022
 * https://github.com/mo0rti
 */

data class AuthUserCases(
    val loginUseCase: LoginUseCase,
    val signupUseCase: SignupUseCase,
    val resetPinCodeUseCase: ResetPinCodeUseCase,
)