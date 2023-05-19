package mortitech.blueprint.auth.data.model

import mortitech.blueprint.core.data.remote.model.base.DtoModel
import mortitech.blueprint.core.data.remote.model.base.RequestDto
import com.google.gson.annotations.SerializedName

/**
 * Dto for signup request.
 */
data class SignupRequestDtoModel(
    @SerializedName("fullName")
    val fullName: String,

    @SerializedName("gender")
    val gender: Int,

    @SerializedName("birthDate")
    val birthDate: Long,

    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String,
): DtoModel(), RequestDto