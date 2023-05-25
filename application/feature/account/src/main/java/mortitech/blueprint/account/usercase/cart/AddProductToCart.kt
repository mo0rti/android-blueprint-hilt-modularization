package mortitech.blueprint.account.usercase.cart

import mortitech.blueprint.core.domain.model.Product

class AddProductToCart(
) {
    suspend operator fun invoke(product: Product) {
    }
}