package orangevelvet.androidblueprint.hilt.datasource.network.model.news

import com.google.gson.annotations.SerializedName
import orangevelvet.androidblueprint.hilt.datasource.network.model.base.BaseNetworkResponse

data class GetLatestNewsResponse(
    @SerializedName("data")
    val data: List<LatestNewsDto>
): BaseNetworkResponse()
