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
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideEventUseCases(
        localService: DashboardLocalService,
        remoteService: DashboardRemoteService,
    ): DashboardUseCases {
        return DashboardUseCases(
            getCategories = GetCategories(localService, remoteService),
            getPopularProducts = GetPopularProducts(localService, remoteService),
            bookmarkProduct = BookmarkProduct(localService, remoteService),
        )
    }
}
