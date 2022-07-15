package orangevelvet.blueprint.auth.presentation.activity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import orangevelvet.blueprint.core.domain.contract.network.DashboardNetworkService
import orangevelvet.blueprint.core.domain.model.LatestNews
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