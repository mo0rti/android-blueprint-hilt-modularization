package mortitech.blueprint.core.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Class to keep track of the current state of the application.
 * */
data class ApplicationState(
    @SerializedName("isUserRegistered")
    var isUserRegistered: String,
)