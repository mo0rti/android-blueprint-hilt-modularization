package bluevelvet.blueprint.core.domain.model

/**
 * Created by Morteza Taghdisi on 24 Sep 2022
 * https://github.com/mo0rti
 */

data class ActiveSession (
    val accessToken: String,
    val refreshToken: String,
)