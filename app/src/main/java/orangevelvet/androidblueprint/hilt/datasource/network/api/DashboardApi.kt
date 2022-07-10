package orangevelvet.androidblueprint.hilt.datasource.network.api

import orangevelvet.androidblueprint.hilt.common.ApiEndPoints
import orangevelvet.androidblueprint.hilt.datasource.network.model.news.GetLatestNewsResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface DashboardApi {

    @GET(ApiEndPoints.GetLatestNews)
    suspend fun getLatestNews(): GetLatestNewsResponse

}