package bluevelvet.blueprint.auth.data.model

import bluevelvet.blueprint.core.data.remote.model.base.DtoModel
import bluevelvet.blueprint.core.data.remote.model.base.ResponseDto
import com.google.gson.annotations.SerializedName

data class LoginResponseDtoModel(
    @SerializedName("accessToken")
    val accessToken: String,

    @SerializedName("refreshToken")
    val refreshToken: String
): DtoModel(), ResponseDto