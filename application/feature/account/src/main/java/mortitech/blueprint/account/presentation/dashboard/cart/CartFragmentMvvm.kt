package mortitech.blueprint.account.presentation.dashboard.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import mortitech.blueprint.core.domain.model.Category
import mortitech.blueprint.core.domain.model.Product

class CartFragmentMvvm: Fragment() {
    private val viewModel: CartViewModelMvvm by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.cart.collect { cartItems ->
                    // Update UI with the cart items
                }
            }
        }

        // Load cart items when activity is created
        viewModel.fetchCartItems()

        /*
        // Add product to cart button click listener
        addButton.setOnClickListener {
            val product = // fetch or create the product to add
            viewModel.addProductToCart(product)
        }*/
    }
}