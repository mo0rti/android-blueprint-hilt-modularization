package mortitech.blueprint.auth.di

import mortitech.blueprint.auth.data.service.AuthenticationRemoteServiceImpl
import mortitech.blueprint.auth.usecase.AuthUserCases
import mortitech.blueprint.auth.usecase.LoginUseCase
import mortitech.blueprint.auth.usecase.ResetPasswordUseCase
import mortitech.blueprint.auth.usecase.SignupUseCase
import mortitech.blueprint.core.data.remote.contract.AuthenticationRemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AuthModule {

    @ViewModelScoped
    @Provides
    fun provideNetworkService(): AuthenticationRemoteService {
        return AuthenticationRemoteServiceImpl()
    }

    @ViewModelScoped
    @Provides
    fun provideUseCases(networkService: AuthenticationRemoteService): AuthUserCases {
        return AuthUserCases(
            loginUseCase = LoginUseCase(networkService),
            signupUseCase = SignupUseCase(networkService),
            resetPasswordUseCase = ResetPasswordUseCase(networkService),
        )
    }
}
