package bluevelvet.blueprint.account.datasource.network.api

import bluevelvet.blueprint.account.datasource.network.endpoint.AccountEndPoints
import bluevelvet.blueprint.account.datasource.network.model.event.GetLatestEventsResponseDto
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface DashboardApi {

    @GET(AccountEndPoints.GetLatestEvents)
    suspend fun getLatestEvents(): GetLatestEventsResponseDto
}