package bluevelvet.blueprint.auth.data.model

import bluevelvet.blueprint.core.base.net.BaseDto
import bluevelvet.blueprint.core.base.net.RequestDto
import com.google.gson.annotations.SerializedName

/**
 * Created by Morteza Taghdisi on 23 Sep 2022
 * https://github.com/mo0rti
 */

data class LoginRequestDto(
    @SerializedName("userId")
    val userId: String,

    @SerializedName("pinCode")
    val pinCode: String
): BaseDto(), RequestDto