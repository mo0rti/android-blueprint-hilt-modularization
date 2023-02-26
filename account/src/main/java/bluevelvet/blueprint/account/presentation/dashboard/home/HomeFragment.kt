package bluevelvet.blueprint.account.presentation.dashboard.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import bluevelvet.blueprint.account.databinding.FragmentHomeBinding
import bluevelvet.blueprint.account.databinding.ListItemProductBinding
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.ui.BaseFragment
import bluevelvet.blueprint.core.base.ui.BaseRecyclerViewAdapter
import bluevelvet.blueprint.core.base.ui.ToolbarConfiguration
import bluevelvet.blueprint.core.model.Category
import bluevelvet.blueprint.core.model.Product
import bluevelvet.blueprint.core.model.ViewInflater
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
            Category("Electronics", "https://example.com/electronics.jpg"),
            Category("Clothing", "https://example.com/clothing.jpg"),
            Category("Home & Garden", "https://example.com/home_garden.jpg"),
            Category("Beauty", "https://example.com/beauty.jpg"),
            Category("Sports", "https://example.com/sports.jpg"),
            Category("Toys & Games", "https://example.com/toys_games.jpg")
        )

        val products = listOf(
            Product("Product 1", "Description 1", "https://example.com/product1.jpg"),
            Product("Product 2", "Description 2", "https://example.com/product2.jpg"),
            Product("Product 3", "Description 3", "https://example.com/product3.jpg"),
            Product("Product 4", "Description 4", "https://example.com/product4.jpg"),
            Product("Product 5", "Description 5", "https://example.com/product5.jpg"),
            Product("Product 6", "Description 6", "https://example.com/product6.jpg")
        )


        val popularProductsAdapter = object: BaseRecyclerViewAdapter<Product, ListItemProductBinding>() {

            override fun bindData(item: Product, binding: ListItemProductBinding) {
                binding.item = item
                //binding.myItemTextview.text = item
            }

            override fun getViewType(position: Int, item: Product): Int {
                return 1
                //return item.length % 2 // arbitrary view type identifier
            }

            override fun getLayoutInflater(viewType: Int): ViewInflater<ListItemProductBinding> {
                return ListItemProductBinding::inflate
            }
        }
        popularProductsAdapter.data = products
        /*
        val categoriesAdapter = BaseAdapter(categories, R.layout.category_grid_item) { holder, item ->
            val categoryViewHolder = holder as CategoryViewHolder

            categoryViewHolder.categoryName.text = item.name

            Glide.with(categoryViewHolder.categoryImage)
                .load(item.imageUrl)
                .centerCrop()
                .placeholder(styleRes.mipmap.img_place_holder)
                .error(styleRes.mipmap.img_place_holder)
                .into(categoryViewHolder.categoryImage)
        }

        binding.categoriesRecyclerView.layoutManager = GridLayoutManager(activity(), 3)
        binding.categoriesRecyclerView.adapter = categoriesAdapter
*/

        /*
        val popularProductsAdapter = BaseAdapter(products, R.layout.list_item_product) { holder, item ->
            val productViewHolder = holder as ProductViewHolder

            productViewHolder.productName.text = item.name
            productViewHolder.productDescription.text = item.description

            Glide.with(productViewHolder.productImage)
                .load(item.imageUrl)
                .centerCrop()
                .placeholder(styleRes.mipmap.img_place_holder)
                .error(styleRes.mipmap.img_place_holder)
                .into(productViewHolder.productImage)
        }*/
        binding.popularProductsRecyclerView.layoutManager = LinearLayoutManager(activity(), LinearLayoutManager.HORIZONTAL, false)
        binding.popularProductsRecyclerView.adapter = popularProductsAdapter
    }

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }

    /*
    class BaseAdapter<T>(
        private val itemList: List<T>,
        private val layoutId: Int,
        private val bindHolder: (holder: BaseViewHolder, item: T) -> Unit
    ) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

        abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
            abstract fun bind(item: Any)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

            return BaseViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
            val currentItem = itemList[position]
            bindHolder(holder, currentItem)
        }

        override fun getItemCount() = itemList.size
    }


    class CategoryViewHolder(binding: CategoryGridItemBinding) : BaseAdapter.BaseViewHolder(binding) {
        override fun bind(item: Any) {
        }

    }

    class ProductViewHolder(binding: ListItemProductBinding) : BaseAdapter.BaseViewHolder(binding) {
        override fun bind(item: Any) {
        }

    }
*/
}

