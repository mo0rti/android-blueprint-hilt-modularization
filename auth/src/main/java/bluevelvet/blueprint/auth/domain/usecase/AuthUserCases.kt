package bluevelvet.blueprint.auth.domain.usecase

data class AuthUserCases(
    val loginUseCase: LoginUseCase,
    val signupUseCase: SignupUseCase,
    val resetPasswordUseCase: ResetPasswordUseCase,
)