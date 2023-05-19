package mortitech.blueprint.core.domain.model

/**
 * Class to keep the session tokens when user is being authenticated.
 * */
data class UserSession (
    val accessToken: String,
    val refreshToken: String,
)