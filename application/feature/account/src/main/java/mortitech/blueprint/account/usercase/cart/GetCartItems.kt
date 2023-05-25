package mortitech.blueprint.account.usercase.cart

import mortitech.blueprint.core.domain.model.CartItem

class GetCartItems(
) {
    suspend operator fun invoke(): List<CartItem> {
        return emptyList()
    }
}