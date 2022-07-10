package orangevelvet.androidblueprint.hilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orangevelvet.androidblueprint.hilt.datasource.network.service.fake.FakeDashboardNetworkNetworkServiceImpl
import orangevelvet.androidblueprint.hilt.domain.contract.network.DashboardNetworkService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkServiceModule {

    @Singleton
    @Binds
    abstract fun bindDashboardNetworkService(
        dashboardNetworkNetworkServiceImpl: FakeDashboardNetworkNetworkServiceImpl
    ): DashboardNetworkService
}