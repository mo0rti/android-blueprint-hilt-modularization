package mortitech.blueprint.account.data.local.contract

import mortitech.blueprint.core.domain.model.Category
import mortitech.blueprint.core.domain.model.Product

interface DashboardLocalService {
    fun getProducts(): List<Product>
    fun getCategories(): List<Category>
    suspend fun insertOrUpdateCategories(categories: List<Category>)
    suspend fun insertOrUpdatePopularProducts(popularProducts: List<Product>)
}