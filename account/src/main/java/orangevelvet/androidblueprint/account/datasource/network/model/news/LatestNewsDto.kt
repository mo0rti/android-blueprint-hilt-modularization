package orangevelvet.androidblueprint.account.datasource.network.model.news

import com.google.gson.annotations.SerializedName
import orangevelvet.androidblueprint.core.base.net.BaseNetworkModel
import orangevelvet.androidblueprint.core.domain.model.LatestNews

data class LatestNewsDto (
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
): BaseNetworkModel() {
    fun convertToDomainModel() = LatestNews(
        id, title, description, smallPhoto, largePhoto
    )
}
