package orangevelvet.blueprint.account.datasource.network.model.news

import com.google.gson.annotations.SerializedName
import orangevelvet.blueprint.core.base.net.BaseNetworkResponse

data class GetLatestNewsResponse(
    @SerializedName("data")
    val data: List<LatestNewsDto>
): BaseNetworkResponse()
