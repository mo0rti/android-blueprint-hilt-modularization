package bluevelvet.blueprint.account.presentation.dashboard.home

import androidx.lifecycle.viewModelScope
import bluevelvet.blueprint.account.usercase.dashboard.DashboardUseCases
import bluevelvet.blueprint.core.di.IoDispatcher
import bluevelvet.blueprint.core.ui.base.BaseViewModel
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
        HomeViewContract.Event,
        HomeViewContract.Effect>() {

    init {
        handleViewEvent(HomeViewContract.Event.LoadDashboardData)
    }

    override fun createInitialState(): HomeViewContract.State {
        return HomeViewContract.State(
            categories = emptyList(),
            isCategoriesLoading = false,
            popularProducts = emptyList(),
            isPopularProductsLoading = false,
        )
    }

    override fun handleViewEvent(viewEvent: HomeViewContract.Event) {
        when(viewEvent) {
            is HomeViewContract.Event.LoadDashboardData -> {
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
            updateViewEffect(HomeViewContract.Effect.ShowErrorToast(e.message))
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
            updateViewEffect(HomeViewContract.Effect.ShowErrorToast(e.message))
            updateViewState { copy(isPopularProductsLoading = false) }
        }
    }
}
