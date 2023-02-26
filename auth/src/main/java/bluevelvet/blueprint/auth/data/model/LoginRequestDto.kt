package bluevelvet.blueprint.auth.data.model

import bluevelvet.blueprint.core.data.remote.model.Dto
import bluevelvet.blueprint.core.data.remote.model.RequestDto
import com.google.gson.annotations.SerializedName

/**
 * Dto for login request.
 */
data class LoginRequestDto(
    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String
): Dto(), RequestDto