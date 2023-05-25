package mortitech.blueprint.account.presentation.dashboard.home

import androidx.lifecycle.viewModelScope
import mortitech.blueprint.account.usercase.dashboard.DashboardUseCases
import mortitech.blueprint.core.di.IoDispatcher
import mortitech.blueprint.core.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val dashboardUseCases: DashboardUseCases,
    @IoDispatcher
    private val IoDispatcher: CoroutineDispatcher
): BaseViewModel<
        HomeViewContract.State,
        HomeViewContract.Action,
        HomeViewContract.Event>() {

    init {
        processViewActions(HomeViewContract.Action.LoadDashboardData)
    }

    override fun createInitialState(): HomeViewContract.State {
        return HomeViewContract.State(
            categories = emptyList(),
            isCategoriesLoading = false,
            popularProducts = emptyList(),
            isPopularProductsLoading = false,
        )
    }

    override fun processViewActions(viewEvent: HomeViewContract.Action) {
        when(viewEvent) {
            is HomeViewContract.Action.LoadDashboardData -> {
                loadDashboardInfo()
            }
        }
    }

    private fun loadDashboardInfo() {
        loadCategories()
        loadPopularProducts()
    }

    private fun loadCategories() {
        try {
            viewModelScope.launch(IoDispatcher) {
                updateViewState { copy(isCategoriesLoading = true) }
                dashboardUseCases.getCategories().collect {
                    updateViewState { copy(categories = it, isCategoriesLoading = false) }
                }
            }
        } catch (e: Exception) {
            updateViewState { copy(isCategoriesLoading = false) }
            updateViewEvent(HomeViewContract.Event.ShowErrorToast(e.message))
        }
    }

    private fun loadPopularProducts() {
        try {
            viewModelScope.launch(IoDispatcher) {
                updateViewState { copy(isPopularProductsLoading = true) }
                dashboardUseCases.getPopularProducts().collect {
                    updateViewState { copy(popularProducts = it, isPopularProductsLoading = false) }
                }
            }
        } catch (e: Exception) {
            updateViewEvent(HomeViewContract.Event.ShowErrorToast(e.message))
            updateViewState { copy(isPopularProductsLoading = false) }
        }
    }
}
