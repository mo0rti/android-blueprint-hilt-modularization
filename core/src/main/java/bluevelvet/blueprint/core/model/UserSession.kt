package bluevelvet.blueprint.core.model

/**
 * Class to keep the session tokens when user is being authenticated.
 * */
data class UserSession (
    val accessToken: String,
    val refreshToken: String,
)