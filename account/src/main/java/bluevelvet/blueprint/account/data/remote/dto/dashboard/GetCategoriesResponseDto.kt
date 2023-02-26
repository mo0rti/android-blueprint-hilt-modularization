package bluevelvet.blueprint.account.data.remote.dto.dashboard

import bluevelvet.blueprint.core.data.remote.model.CategoryDto
import bluevelvet.blueprint.core.data.remote.model.base.ResponseDto
import com.google.gson.annotations.SerializedName

data class GetCategoriesResponseDto (
    @SerializedName("categories")
    val categories: List<CategoryDto>,
): ResponseDto
