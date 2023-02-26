package bluevelvet.blueprint.account.di

import bluevelvet.blueprint.account.data.remote.contract.DashboardRemoteService
import bluevelvet.blueprint.account.data.remote.service.DashboardRemoteServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteServiceModule {

    @Singleton
    @Binds
    abstract fun bindDashboardRemoteService(
        remoteService: DashboardRemoteServiceImpl
    ): DashboardRemoteService
}