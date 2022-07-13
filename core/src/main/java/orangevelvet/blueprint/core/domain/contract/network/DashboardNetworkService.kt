package orangevelvet.blueprint.core.domain.contract.network

import orangevelvet.blueprint.core.domain.model.LatestNews

interface DashboardNetworkService {
    suspend fun getLatestNews(): List<LatestNews>
}
