package orangevelvet.androidblueprint.hilt.datasource.network.model.currency

import com.google.gson.annotations.SerializedName
import orangevelvet.androidblueprint.hilt.datasource.network.model.base.BaseNetworkResponse

data class GetCurrencyNetworkResponse(
    @SerializedName("data")
    val data: List<CurrencyDto>
): BaseNetworkResponse()