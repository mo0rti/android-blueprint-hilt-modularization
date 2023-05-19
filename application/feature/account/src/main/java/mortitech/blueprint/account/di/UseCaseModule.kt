package mortitech.blueprint.account.di

import mortitech.blueprint.account.data.local.contract.DashboardLocalService
import mortitech.blueprint.account.data.remote.contract.DashboardRemoteService
import mortitech.blueprint.account.usercase.dashboard.BookmarkProduct
import mortitech.blueprint.account.usercase.dashboard.DashboardUseCases
import mortitech.blueprint.account.usercase.dashboard.GetCategories
import mortitech.blueprint.account.usercase.dashboard.GetPopularProducts
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
