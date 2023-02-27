package bluevelvet.blueprint.account.data.remote.service

import bluevelvet.blueprint.account.data.remote.api.DashboardApi
import bluevelvet.blueprint.account.data.remote.contract.DashboardRemoteService
import bluevelvet.blueprint.core.data.remote.model.CategoryDto
import bluevelvet.blueprint.core.data.remote.model.ProductDto
import bluevelvet.blueprint.core.di.IoDispatcher
import bluevelvet.blueprint.core.domain.model.Category
import bluevelvet.blueprint.core.domain.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import javax.inject.Inject

class DashboardRemoteServiceImpl
@Inject
constructor(
    private val api: DashboardApi,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
): DashboardRemoteService {
    private val categories =
        listOf(
            CategoryDto(id= "1", name = "Electronics", imageUrl = "https://via.placeholder.com/400x300"),
            CategoryDto(id= "2", name = "Clothing", imageUrl = "https://via.placeholder.com/400x300"),
            CategoryDto(id= "3", name = "Home & Garden", imageUrl = "https://via.placeholder.com/400x300"),
            CategoryDto(id= "4", name = "Beauty", imageUrl = "https://via.placeholder.com/400x300"),
            CategoryDto(id= "5", name = "Sports", imageUrl = "https://via.placeholder.com/400x300"),
            CategoryDto(id= "6", name = "Toys & Games", imageUrl = "https://via.placeholder.com/400x300"),
        )

    private val products = listOf(
            ProductDto(id= "1", name = "Product 1", description = "Description 1", imageUrl = "https://via.placeholder.com/400x300", categoryId = "1"),
            ProductDto(id= "2", name = "Product 2", description = "Description 2", imageUrl = "https://via.placeholder.com/400x300", categoryId = "1"),
            ProductDto(id= "3", name = "Product 3", description = "Description 3", imageUrl = "https://via.placeholder.com/400x300", categoryId = "1"),
            ProductDto(id= "4", name = "Product 4", description = "Description 4", imageUrl = "https://via.placeholder.com/400x300", categoryId = "2"),
            ProductDto(id= "5", name = "Product 5", description = "Description 5", imageUrl = "https://via.placeholder.com/400x300", categoryId = "2"),
            ProductDto(id= "6", name = "Product 6", description = "Description 6", imageUrl = "https://via.placeholder.com/400x300", categoryId = "2"),
            ProductDto(id= "7", name = "Product 7", description = "Description 7", imageUrl = "https://via.placeholder.com/400x300", categoryId = "3"),
            ProductDto(id= "8", name = "Product 8", description = "Description 8", imageUrl = "https://via.placeholder.com/400x300", categoryId = "3"),
            ProductDto(id= "9", name = "Product 9", description = "Description 9", imageUrl = "https://via.placeholder.com/400x300", categoryId = "4"),
            ProductDto(id= "10", name = "Product 10", description = "Description 10", imageUrl = "https://via.placeholder.com/400x300", categoryId = "5"),
            ProductDto(id= "11", name = "Product 11", description = "Description 11", imageUrl = "https://via.placeholder.com/400x300", categoryId = "6"),
        )

    override suspend fun getCategories(): List<Category> {
        delay(500)
        return categories.map { dto ->
            Category(dto.id, dto.name, dto.imageUrl)
        }
    }

    override suspend fun getPopularProducts(): List<Product> {
        delay(2000)
        return products.map { dto ->
                Product(
                    dto.id,
                    dto.name,
                    Category(id= "1", name = "Electronics", imageUrl = "https://via.placeholder.com/400x300"),
                    dto.description,
                    dto.imageUrl,
                )
        }
    }

    override suspend fun bookmarkProduct(product: Product): Boolean {
        delay(100)
        return true
    }
}
