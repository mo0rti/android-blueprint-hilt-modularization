package bluevelvet.blueprint.auth.di

import bluevelvet.blueprint.auth.business.AuthUserCases
import bluevelvet.blueprint.auth.business.LoginUseCase
import bluevelvet.blueprint.auth.business.ResetPinCodeUseCase
import bluevelvet.blueprint.auth.business.SignupUseCase
import bluevelvet.blueprint.auth.data.service.AuthNetworkServiceImpl
import bluevelvet.blueprint.core.domain.contract.network.AuthNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    fun provideNetworkService(): AuthNetworkService {
        return AuthNetworkServiceImpl()
    }

    @Provides
    fun provideUseCases(networkService: AuthNetworkService) = AuthUserCases(
        loginUseCase = LoginUseCase(networkService),
        signupUseCase = SignupUseCase(networkService),
        resetPinCodeUseCase = ResetPinCodeUseCase(networkService),
    )
}