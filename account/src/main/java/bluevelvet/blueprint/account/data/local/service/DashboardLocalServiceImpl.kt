package bluevelvet.blueprint.account.data.local.service

import bluevelvet.blueprint.account.data.local.contract.DashboardLocalService
import bluevelvet.blueprint.core.data.local.dao.CategoryDao
import bluevelvet.blueprint.core.data.local.dao.ProductDao
import bluevelvet.blueprint.core.data.local.model.CategoryEntity
import bluevelvet.blueprint.core.domain.model.Category
import bluevelvet.blueprint.core.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DashboardLocalServiceImpl
@Inject
constructor(
    private val productDao: ProductDao,
    private val categoryDao: CategoryDao,
): DashboardLocalService {
    override fun getCategories(): Flow<List<Category>> = flow {
        categoryDao.getAll().map {
            it.map { entity ->
                entity.toDomainModel()
            }
        }
    }

    override suspend fun insertOrUpdateCategories(categories: List<Category>) {
        categoryDao.deleteAll()
        categories.map { category ->
            categoryDao.insert(CategoryEntity.fromDomainModel(category))
        }
    }

    override suspend fun insertOrUpdatePopularProducts(popularProducts: List<Product>) {
    }
}
