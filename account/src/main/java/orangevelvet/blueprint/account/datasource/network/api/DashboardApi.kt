package orangevelvet.blueprint.account.datasource.network.api

import orangevelvet.blueprint.account.datasource.network.endpoint.AccountEndPoints
import orangevelvet.blueprint.account.datasource.network.model.event.GetLatestEventsResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface DashboardApi {

    @GET(AccountEndPoints.GetLatestEvents)
    suspend fun getLatestEvents(): GetLatestEventsResponse
}