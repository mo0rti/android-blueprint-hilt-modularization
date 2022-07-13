package orangevelvet.blueprint.account.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orangevelvet.blueprint.account.datasource.network.service.fake.FakeDashboardNetworkNetworkServiceImpl
import orangevelvet.blueprint.core.domain.contract.network.DashboardNetworkService
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