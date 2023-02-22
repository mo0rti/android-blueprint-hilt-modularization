package bluevelvet.blueprint.auth.data.model

import bluevelvet.blueprint.core.base.net.BaseDto
import bluevelvet.blueprint.core.base.net.ResponseDto
import com.google.gson.annotations.SerializedName

data class SignupResponseDto(
    @SerializedName("accessToken")
    val accessToken: String,

    @SerializedName("refreshToken")
    val refreshToken: String
): BaseDto(), ResponseDto