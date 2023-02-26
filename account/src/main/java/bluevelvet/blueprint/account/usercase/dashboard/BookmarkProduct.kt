package bluevelvet.blueprint.account.usercase.dashboard

import bluevelvet.blueprint.account.data.local.contract.DashboardLocalService
import bluevelvet.blueprint.account.data.remote.contract.DashboardRemoteService
import bluevelvet.blueprint.core.domain.model.Product

class BookmarkProduct(
    private val cacheService: DashboardLocalService,
    private val networkService: DashboardRemoteService,
) {
    suspend operator fun invoke(product: Product) {
        networkService.bookmarkProduct(product)
    }
}