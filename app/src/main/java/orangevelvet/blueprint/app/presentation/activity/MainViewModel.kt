package orangevelvet.blueprint.app.presentation.activity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import orangevelvet.blueprint.core.domain.contract.network.DashboardNetworkService
import orangevelvet.blueprint.core.domain.model.LatestNews
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val dashboardNetworkService: DashboardNetworkService
): ViewModel() {

    suspend fun load(): List<LatestNews> {
        return dashboardNetworkService.getLatestNews()
    }
}