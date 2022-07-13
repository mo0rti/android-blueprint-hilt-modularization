package orangevelvet.androidblueprint.account.datasource.network.model.news

import com.google.gson.annotations.SerializedName
import orangevelvet.androidblueprint.core.base.net.BaseNetworkResponse

data class GetLatestNewsResponse(
    @SerializedName("data")
    val data: List<LatestNewsDto>
): BaseNetworkResponse()
