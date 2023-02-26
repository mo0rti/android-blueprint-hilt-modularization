package bluevelvet.blueprint.account.data.remote.contract

import bluevelvet.blueprint.core.domain.model.Category
import bluevelvet.blueprint.core.domain.model.Product

interface DashboardRemoteService {
    suspend fun getCategories(): List<Category>
    suspend fun getPopularProducts(): List<Product>
    suspend fun bookmarkProduct(product: Product): Boolean
}
