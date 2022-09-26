package bluevelvet.blueprint.account.datasource.network.model.event

import com.google.gson.annotations.SerializedName
import bluevelvet.blueprint.core.base.net.BaseDto
import bluevelvet.blueprint.account.domain.model.Event

data class LatestEventDto (
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("small_photo")
    val smallPhoto: String,

    @SerializedName("large_photo")
    val largePhoto: String,
): BaseDto() {
    fun convertToDomainModel() = Event(
        id, title, description, smallPhoto, largePhoto
    )
}
