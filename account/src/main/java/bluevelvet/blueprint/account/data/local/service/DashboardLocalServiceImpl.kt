package bluevelvet.blueprint.account.data.local.service

import bluevelvet.blueprint.account.data.local.contract.DashboardLocalService
import bluevelvet.blueprint.core.data.local.dao.CategoryDao
import bluevelvet.blueprint.core.data.local.dao.ProductDao
import bluevelvet.blueprint.core.data.local.model.CategoryEntity
import bluevelvet.blueprint.core.domain.model.Category
import bluevelvet.blueprint.core.domain.model.Product
import javax.inject.Inject

class DashboardLocalServiceImpl
@Inject
constructor(
    private val productDao: ProductDao,
    private val categoryDao: CategoryDao,
): DashboardLocalService {
    override fun getProducts(): List<Product> {
        return productDao.getAll().map { entity ->
            entity.toDomainModel {
                Category("1", "", "")
            }
        }
    }

    override fun getCategories(): List<Category> {
        return categoryDao.getAll().map { entity ->
            entity.toDomainModel()
        }
    }

    override suspend fun insertOrUpdateCategories(categories: List<Category>) {
        categories.map { category ->
            categoryDao.insertOrUpdate(CategoryEntity.fromDomainModel(category))
        }
    }

    override suspend fun insertOrUpdatePopularProducts(popularProducts: List<Product>) {
    }
}
