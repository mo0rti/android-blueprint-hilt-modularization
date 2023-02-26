package bluevelvet.blueprint.auth.data.model

import bluevelvet.blueprint.core.data.remote.model.Dto
import bluevelvet.blueprint.core.data.remote.model.ResponseDto
import com.google.gson.annotations.SerializedName

data class LoginResponseDto(
    @SerializedName("accessToken")
    val accessToken: String,

    @SerializedName("refreshToken")
    val refreshToken: String
): Dto(), ResponseDto