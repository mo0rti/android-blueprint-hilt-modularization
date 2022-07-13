package orangevelvet.androidblueprint.hilt.presentation.activity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import orangevelvet.androidblueprint.core.domain.contract.network.DashboardNetworkService
import orangevelvet.androidblueprint.core.domain.model.LatestNews
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