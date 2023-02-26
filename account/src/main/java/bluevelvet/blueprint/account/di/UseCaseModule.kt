package bluevelvet.blueprint.account.di

import bluevelvet.blueprint.account.data.local.contract.DashboardLocalService
import bluevelvet.blueprint.account.data.remote.contract.DashboardRemoteService
import bluevelvet.blueprint.account.usercase.dashboard.BookmarkProduct
import bluevelvet.blueprint.account.usercase.dashboard.DashboardUseCases
import bluevelvet.blueprint.account.usercase.dashboard.GetCategories
import bluevelvet.blueprint.account.usercase.dashboard.GetPopularProducts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideEventUseCases(
        localService: DashboardLocalService,
        remoteService: DashboardRemoteService,
    ) = DashboardUseCases(
        getCategories = GetCategories(localService, remoteService),
        getPopularProducts = GetPopularProducts(localService, remoteService),
        bookmarkProduct = BookmarkProduct(localService, remoteService),
    )
}