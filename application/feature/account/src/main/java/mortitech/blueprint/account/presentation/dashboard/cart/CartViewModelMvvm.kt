package mortitech.blueprint.account.presentation.dashboard.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mortitech.blueprint.account.usercase.cart.CartUseCases
import mortitech.blueprint.core.domain.model.CartItem
import mortitech.blueprint.core.domain.model.Product

class CartViewModelMvvm(private val cartUseCases: CartUseCases) : ViewModel() {
    private val _cart = MutableStateFlow<List<CartItem>>(emptyList())
    val cart: StateFlow<List<CartItem>> = _cart

    fun fetchCartItems() {
        viewModelScope.launch {
            val cartItems = cartUseCases.getCartItems()
            _cart.value = cartItems
        }
    }

    fun addProductToCart(product: Product) {
        viewModelScope.launch {
            cartUseCases.addProductToCart(product)
            val updatedCartItems = cartUseCases.getCartItems()
            _cart.value = updatedCartItems
        }
    }
}