package bluevelvet.blueprint.auth.data.model

import bluevelvet.blueprint.core.base.net.BaseDto
import bluevelvet.blueprint.core.base.net.RequestDto
import com.google.gson.annotations.SerializedName

/**
 * Dto for login request.
 */
data class LoginRequestDto(
    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String
): BaseDto(), RequestDto