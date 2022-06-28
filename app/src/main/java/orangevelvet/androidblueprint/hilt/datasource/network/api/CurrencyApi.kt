package orangevelvet.androidblueprint.hilt.datasource.network.api

import orangevelvet.androidblueprint.hilt.common.ApiEndPoints
import orangevelvet.androidblueprint.hilt.datasource.network.model.currency.GetCurrencyNetworkResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface CurrencyApi {

    @GET(ApiEndPoints.GetCurrencies)
    suspend fun getCurrencies(): GetCurrencyNetworkResponse

}