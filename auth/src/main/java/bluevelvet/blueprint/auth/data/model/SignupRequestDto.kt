package bluevelvet.blueprint.auth.data.model

import bluevelvet.blueprint.core.data.remote.model.Dto
import bluevelvet.blueprint.core.data.remote.model.RequestDto
import com.google.gson.annotations.SerializedName

/**
 * Dto for signup request.
 */
data class SignupRequestDto(
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
): Dto(), RequestDto