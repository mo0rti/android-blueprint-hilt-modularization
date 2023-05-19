package mortitech.blueprint.auth.data.model

import mortitech.blueprint.core.data.remote.model.base.DtoModel
import mortitech.blueprint.core.data.remote.model.base.ResponseDto
import com.google.gson.annotations.SerializedName

data class SignupResponseDtoModel(
    @SerializedName("accessToken")
    val accessToken: String,

    @SerializedName("refreshToken")
    val refreshToken: String
): DtoModel(), ResponseDto