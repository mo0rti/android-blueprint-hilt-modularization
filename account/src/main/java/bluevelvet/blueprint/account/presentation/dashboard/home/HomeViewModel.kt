package bluevelvet.blueprint.account.presentation.dashboard.home

import androidx.lifecycle.viewModelScope
import bluevelvet.blueprint.account.usercase.dashboard.DashboardUseCases
import bluevelvet.blueprint.core.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val dashboardUseCases: DashboardUseCases
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
            popularProducts = emptyList(),
            isLoading = false,
        )
    }

    override fun handleViewEvent(viewEvent: HomeViewContract.Event) {
        when(viewEvent) {
            is HomeViewContract.Event.LoadDashboardData -> {
                loadDashboardInformation()
            }
        }
    }

    private fun loadDashboardInformation() {
        viewModelScope.launch {
            try {
                combine(
                    dashboardUseCases.getCategories(),
                    dashboardUseCases.getPopularProducts()
                ) { categories, popularProducts ->
                    categories to popularProducts
                }.collect { (categories, popularProducts) ->
                    updateViewState {
                        copy(
                            categories = categories,
                            popularProducts = popularProducts,
                        )
                    }
                }
            } catch (e: Exception) {
                updateViewEffect(HomeViewContract.Effect.ShowErrorToast(e.message))
            } finally {
                updateViewState { copy(isLoading = false) }
            }
        }
    }
}
