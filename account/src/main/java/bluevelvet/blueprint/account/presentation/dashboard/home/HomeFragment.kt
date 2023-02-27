package bluevelvet.blueprint.account.presentation.dashboard.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import bluevelvet.blueprint.account.databinding.FragmentHomeBinding
import bluevelvet.blueprint.account.databinding.GridItemCategoryBinding
import bluevelvet.blueprint.account.databinding.ListItemProductBinding
import bluevelvet.blueprint.core.domain.model.Category
import bluevelvet.blueprint.core.domain.model.Product
import bluevelvet.blueprint.core.ui.ToolbarConfiguration
import bluevelvet.blueprint.core.ui.base.BaseFragment
import bluevelvet.blueprint.core.ui.base.BaseRecyclerViewAdapter
import bluevelvet.blueprint.core.utils.ImageUtils
import bluevelvet.blueprint.style.view.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<
        FragmentHomeBinding,
        HomeViewContract.State,
        HomeViewContract.Event,
        HomeViewContract.Effect,
        HomeViewModel>(
    FragmentHomeBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: HomeViewModel by viewModels()

    private lateinit var categoriesAdapter: BaseRecyclerViewAdapter<Category, GridItemCategoryBinding>
    private lateinit var popularProductsAdapter: BaseRecyclerViewAdapter<Product, ListItemProductBinding>

    override fun initializeComponents() {
        setupCategories()
        setupPopularProducts()
    }

    private fun setupCategories() {
        categoriesAdapter = BaseRecyclerViewAdapter.build(GridItemCategoryBinding::inflate) { category, binding ->
            binding.item = category
            ImageUtils.loadImage(binding.categoryImage, category.imageUrl)
        }

        binding.categoriesRecyclerView.layoutManager = GridLayoutManager(activity(), 3)
        binding.categoriesRecyclerView.adapter = categoriesAdapter
    }

    private fun setupPopularProducts() {
        popularProductsAdapter = BaseRecyclerViewAdapter.build(ListItemProductBinding::inflate) { product, binding ->
            binding.item = product
            ImageUtils.loadImage(binding.productImage, product.imageUrl)
        }

        binding.popularProductsRecyclerView.layoutManager = LinearLayoutManager(activity(), LinearLayoutManager.HORIZONTAL, false)
        binding.popularProductsRecyclerView.adapter = popularProductsAdapter
    }

    override fun onViewEffectReceived(viewEffect: HomeViewContract.Effect) {
        when(viewEffect) {
            is HomeViewContract.Effect.ShowErrorToast -> {
                showToast(viewEffect.error)
            }
        }
    }

    override fun onViewStateChange(viewState: HomeViewContract.State) {
        categoriesAdapter.data = viewState.categories
        popularProductsAdapter.data = viewState.popularProducts

        Log.d("-----", "${viewState.isCategoriesLoading} ${viewState.isPopularProductsLoading}")
        binding.pbCategories.setVisibility(viewState.isCategoriesLoading)
        binding.pbPopularProducts.setVisibility(viewState.isPopularProductsLoading)
    }
}

