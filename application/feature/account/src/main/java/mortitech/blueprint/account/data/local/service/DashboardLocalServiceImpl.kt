package mortitech.blueprint.account.data.local.service

import mortitech.blueprint.account.data.local.contract.DashboardLocalService
import mortitech.blueprint.core.data.local.dao.CategoryDao
import mortitech.blueprint.core.data.local.dao.ProductDao
import mortitech.blueprint.core.data.local.model.CategoryEntity
import mortitech.blueprint.core.domain.model.Category
import mortitech.blueprint.core.domain.model.Product
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
