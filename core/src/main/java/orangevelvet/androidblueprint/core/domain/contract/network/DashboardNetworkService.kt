package orangevelvet.androidblueprint.core.domain.contract.network

import orangevelvet.androidblueprint.core.domain.model.LatestNews

interface DashboardNetworkService {
    suspend fun getLatestNews(): List<LatestNews>
}
