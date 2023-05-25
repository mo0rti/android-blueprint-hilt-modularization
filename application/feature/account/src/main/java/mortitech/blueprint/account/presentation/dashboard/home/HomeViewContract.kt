package mortitech.blueprint.account.presentation.dashboard.home

import mortitech.blueprint.core.domain.model.Category
import mortitech.blueprint.core.domain.model.Product
import mortitech.blueprint.core.ui.state.view.ViewEvent
import mortitech.blueprint.core.ui.state.view.ViewAction
import mortitech.blueprint.core.ui.state.view.ViewState

class HomeViewContract {

    data class State(
        val isCategoriesLoading: Boolean,
        val categories: List<Category>,
        val isPopularProductsLoading: Boolean,
        val popularProducts: List<Product>,
    ): ViewState

    sealed class Action: ViewAction {
        object LoadDashboardData: Action()
    }

    sealed class Event: ViewEvent {
        data class ShowErrorToast(
            val error: String?
        ): Event()
    }
}