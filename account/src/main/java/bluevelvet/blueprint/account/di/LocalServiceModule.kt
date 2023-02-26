package bluevelvet.blueprint.account.di

import bluevelvet.blueprint.account.data.local.contract.DashboardLocalService
import bluevelvet.blueprint.account.data.local.service.DashboardLocalServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalServiceModule {

    @Singleton
    @Binds
    abstract fun bindDashboardLocalService(
        localService: DashboardLocalServiceImpl
    ): DashboardLocalService
}