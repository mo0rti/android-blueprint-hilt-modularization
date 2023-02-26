package bluevelvet.blueprint.account.usercase.dashboard

data class DashboardUseCases(
    val getCategories: GetCategories,
    val getPopularProducts: GetPopularProducts,
    val bookmarkProduct: BookmarkProduct,
)