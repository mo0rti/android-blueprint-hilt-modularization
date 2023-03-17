package bluevelvet.blueprint.account.di

import bluevelvet.blueprint.account.data.remote.contract.DashboardRemoteService
import bluevelvet.blueprint.account.data.remote.service.DashboardRemoteServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteServiceModule {

    @ViewModelScoped
    @Binds
    abstract fun bindDashboardRemoteService(
        remoteService: DashboardRemoteServiceImpl
    ): DashboardRemoteService
}
