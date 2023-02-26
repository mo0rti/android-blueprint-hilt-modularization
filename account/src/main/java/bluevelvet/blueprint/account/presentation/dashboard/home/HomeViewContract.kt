package bluevelvet.blueprint.account.presentation.dashboard.home

import bluevelvet.blueprint.core.domain.model.Category
import bluevelvet.blueprint.core.domain.model.Product
import bluevelvet.blueprint.core.ui.state.view.ViewEffect
import bluevelvet.blueprint.core.ui.state.view.ViewEvent
import bluevelvet.blueprint.core.ui.state.view.ViewState

class HomeViewContract {

    data class State(
        val isLoading: Boolean,
        val categories: List<Category>,
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