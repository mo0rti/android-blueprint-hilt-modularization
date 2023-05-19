package mortitech.blueprint.account.presentation.dashboard.home

import mortitech.blueprint.core.domain.model.Category
import mortitech.blueprint.core.domain.model.Product
import mortitech.blueprint.core.ui.state.view.ViewEffect
import mortitech.blueprint.core.ui.state.view.ViewEvent
import mortitech.blueprint.core.ui.state.view.ViewState

class HomeViewContract {

    data class State(
        val isCategoriesLoading: Boolean,
        val categories: List<Category>,
        val isPopularProductsLoading: Boolean,
        val popularProducts: List<Product>,
    ): ViewState

    sealed class Event: ViewEvent {
        object LoadDashboardData: Event()
    }

    sealed class Effect: ViewEffect {
        data class ShowErrorToast(
            val error: String?
        ): Effect()
    }
}