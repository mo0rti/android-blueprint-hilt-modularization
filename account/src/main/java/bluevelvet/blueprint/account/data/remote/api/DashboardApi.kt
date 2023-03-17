package bluevelvet.blueprint.account.data.remote.api

import bluevelvet.blueprint.account.data.remote.dto.dashboard.GetCategoriesResponseDto
import bluevelvet.blueprint.account.data.remote.dto.dashboard.GetPopularProductsResponseDto
import retrofit2.http.GET

interface DashboardApi {

    @GET(AccountEndPoints.GetCategories)
    suspend fun getCategories(): GetCategoriesResponseDto

    @GET(AccountEndPoints.GetProducts)
    suspend fun getPopularProducts(): GetPopularProductsResponseDto

    @GET(AccountEndPoints.BookmarkProduct)
    suspend fun bookmarkProduct(isBookmarked: Boolean): GetPopularProductsResponseDto
}
