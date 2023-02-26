package bluevelvet.blueprint.account.datasource.network.model.event

import bluevelvet.blueprint.core.data.remote.model.ResponseDto
import com.google.gson.annotations.SerializedName

data class GetLatestEventsResponseDto(
    @SerializedName("data")
    val data: List<LatestEventDto>
): ResponseDto
