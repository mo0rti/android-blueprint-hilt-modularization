package mortitech.blueprint.account.usercase.cart

data class CartUseCases(
    val addProductToCart: AddProductToCart,
    val getCartItems: GetCartItems
)