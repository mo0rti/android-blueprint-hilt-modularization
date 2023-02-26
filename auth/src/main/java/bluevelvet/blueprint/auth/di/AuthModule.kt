package bluevelvet.blueprint.auth.di

import bluevelvet.blueprint.auth.data.service.AuthRemoteServiceImpl
import bluevelvet.blueprint.auth.domain.usecase.AuthUserCases
import bluevelvet.blueprint.auth.domain.usecase.LoginUseCase
import bluevelvet.blueprint.auth.domain.usecase.ResetPasswordUseCase
import bluevelvet.blueprint.auth.domain.usecase.SignupUseCase
import bluevelvet.blueprint.core.data.remote.contract.AuthRemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    fun provideNetworkService(): AuthRemoteService {
        return AuthRemoteServiceImpl()
    }

    @Provides
    fun provideUseCases(networkService: AuthRemoteService) = AuthUserCases(
        loginUseCase = LoginUseCase(networkService),
        signupUseCase = SignupUseCase(networkService),
        resetPasswordUseCase = ResetPasswordUseCase(networkService),
    )
}