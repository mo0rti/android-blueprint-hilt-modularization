package orangevelvet.androidblueprint.hilt.presentation.ui.auth.activity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import orangevelvet.androidblueprint.hilt.domain.contract.network.DashboardNetworkService
import orangevelvet.androidblueprint.hilt.domain.model.LatestNews
import javax.inject.Inject

@HiltViewModel
class AuthViewModel
@Inject
constructor(
    private val dashboardNetworkService: DashboardNetworkService
): ViewModel() {

    suspend fun load(): List<LatestNews> {
        return dashboardNetworkService.getLatestNews()
    }
}