package orangevelvet.androidblueprint.account.datasource.network.api

import orangevelvet.androidblueprint.account.datasource.network.endpoint.AccountEndPoints
import orangevelvet.androidblueprint.account.datasource.network.model.news.GetLatestNewsResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface DashboardApi {

    @GET(AccountEndPoints.GetLatestNews)
    suspend fun getLatestNews(): GetLatestNewsResponse

}