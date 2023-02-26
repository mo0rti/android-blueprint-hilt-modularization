package bluevelvet.blueprint.core.data.remote.model

import bluevelvet.blueprint.core.data.remote.model.base.DtoModel
import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image_url")
    val imageUrl: String
): DtoModel()