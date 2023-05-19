package mortitech.blueprint.auth.usecase

data class AuthUserCases(
    val loginUseCase: LoginUseCase,
    val signupUseCase: SignupUseCase,
    val resetPasswordUseCase: ResetPasswordUseCase,
)