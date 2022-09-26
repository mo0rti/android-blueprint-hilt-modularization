package bluevelvet.blueprint.account.datasource.network.model.event

import com.google.gson.annotations.SerializedName
import bluevelvet.blueprint.core.base.net.ResponseDto

data class GetLatestEventsResponseDto(
    @SerializedName("data")
    val data: List<LatestEventDto>
): ResponseDto
