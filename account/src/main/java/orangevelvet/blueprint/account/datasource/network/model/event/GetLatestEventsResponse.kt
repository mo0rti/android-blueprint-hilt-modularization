package orangevelvet.blueprint.account.datasource.network.model.event

import com.google.gson.annotations.SerializedName
import orangevelvet.blueprint.core.base.net.BaseNetworkResponse

data class GetLatestEventsResponse(
    @SerializedName("data")
    val data: List<LatestEventDto>
): BaseNetworkResponse()
