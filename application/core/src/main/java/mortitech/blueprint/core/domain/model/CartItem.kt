package mortitech.blueprint.core.domain.model

data class CartItem(
    val productId: String,
    val productName: String,
    val productPrice: Double,
    var quantity: Int
)
