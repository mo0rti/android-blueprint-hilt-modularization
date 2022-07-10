package orangevelvet.androidblueprint.hilt.domain.contract.network

import orangevelvet.androidblueprint.hilt.domain.model.LatestNews

interface DashboardNetworkService {
    suspend fun getLatestNews(): List<LatestNews>
}
