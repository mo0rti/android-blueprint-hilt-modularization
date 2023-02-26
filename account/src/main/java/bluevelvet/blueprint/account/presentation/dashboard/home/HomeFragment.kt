package bluevelvet.blueprint.account.presentation.dashboard.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import bluevelvet.blueprint.account.databinding.FragmentHomeBinding
import bluevelvet.blueprint.account.databinding.GridItemCategoryBinding
import bluevelvet.blueprint.account.databinding.ListItemProductBinding
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.ui.base.BaseFragment
import bluevelvet.blueprint.core.ui.base.BaseRecyclerViewAdapter
import bluevelvet.blueprint.core.ui.ToolbarConfiguration
import bluevelvet.blueprint.core.domain.model.Category
import bluevelvet.blueprint.core.domain.model.Product
import bluevelvet.blueprint.core.utils.ImageUtils
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment: BaseFragment<
        FragmentHomeBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
        HomeViewModel>(
    FragmentHomeBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: HomeViewModel by viewModels()

    override fun initializeComponents() {
        val categories = listOf(
            Category(name = "Electronics", imageUrl = "https://example.com/electronics.jpg"),
            Category(name = "Clothing", imageUrl = "https://example.com/clothing.jpg"),
            Category(name = "Home & Garden", imageUrl = "https://example.com/home_garden.jpg"),
            Category(name = "Beauty", imageUrl = "https://example.com/beauty.jpg"),
            Category(name = "Sports", imageUrl = "https://example.com/sports.jpg"),
            Category(name = "Toys & Games", imageUrl = "https://example.com/toys_games.jpg")
        )

        val products = listOf(
            Product(name = "Product 1", description = "Description 1", imageUrl = "https://example.com/product1.jpg", category = categories[0]),
            Product(name = "Product 2", description = "Description 2", imageUrl = "https://example.com/product2.jpg", category = categories[0]),
            Product(name = "Product 3", description = "Description 3", imageUrl = "https://example.com/product3.jpg", category = categories[1]),
            Product(name = "Product 4", description = "Description 4", imageUrl = "https://example.com/product4.jpg", category = categories[0]),
            Product(name = "Product 5", description = "Description 5", imageUrl = "https://example.com/product5.jpg", category = categories[2]),
            Product(name = "Product 6", description = "Description 6", imageUrl = "https://example.com/product6.jpg", category = categories[0])
        )


        val popularProductsAdapter = BaseRecyclerViewAdapter.build<Product, ListItemProductBinding>(ListItemProductBinding::inflate) { product, binding ->
            binding.item = product
            ImageUtils.loadImage(binding.productImage, product.imageUrl)
        }.also { it.data = products }

        val categoriesAdapter = BaseRecyclerViewAdapter.build<Category, GridItemCategoryBinding>(GridItemCategoryBinding::inflate) { category, binding ->
            binding.item = category
            ImageUtils.loadImage(binding.categoryImage, category.imageUrl)
        }.also { it.data = categories }

        binding.categoriesRecyclerView.layoutManager = GridLayoutManager(activity(), 3)
        binding.categoriesRecyclerView.adapter = categoriesAdapter

        binding.popularProductsRecyclerView.layoutManager = LinearLayoutManager(activity(), LinearLayoutManager.HORIZONTAL, false)
        binding.popularProductsRecyclerView.adapter = popularProductsAdapter
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}

