package bluevelvet.blueprint.auth.data.model

import bluevelvet.blueprint.core.data.remote.model.base.DtoModel
import bluevelvet.blueprint.core.data.remote.model.base.RequestDto
import com.google.gson.annotations.SerializedName

/**
 * Dto for login request.
 */
data class LoginRequestDtoModel(
    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String
): DtoModel(), RequestDto