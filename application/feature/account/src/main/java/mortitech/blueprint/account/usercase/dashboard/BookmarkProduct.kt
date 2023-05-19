package mortitech.blueprint.account.usercase.dashboard

import mortitech.blueprint.account.data.local.contract.DashboardLocalService
import mortitech.blueprint.account.data.remote.contract.DashboardRemoteService
import mortitech.blueprint.core.domain.model.Product

class BookmarkProduct(
    private val cacheService: DashboardLocalService,
    private val networkService: DashboardRemoteService,
) {
    suspend operator fun invoke(product: Product) {
        networkService.bookmarkProduct(product)
    }
}