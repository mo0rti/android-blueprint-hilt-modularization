package mortitech.blueprint.account.data.remote.dto.dashboard

import mortitech.blueprint.core.data.remote.model.ProductDto
import mortitech.blueprint.core.data.remote.model.base.ResponseDto
import com.google.gson.annotations.SerializedName

data class GetPopularProductsResponseDto(
    @SerializedName("products")
    val products: List<ProductDto>,
): ResponseDto
