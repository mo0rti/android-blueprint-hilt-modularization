package orangevelvet.androidblueprint.hilt.datasource.network.service

import orangevelvet.androidblueprint.hilt.datasource.network.api.DashboardApi
import orangevelvet.androidblueprint.hilt.domain.contract.network.DashboardNetworkService
import orangevelvet.androidblueprint.hilt.domain.model.LatestNews
import javax.inject.Inject

class DashboardNetworkServiceImpl
@Inject
constructor(
    private val api: DashboardApi
): DashboardNetworkService {
    override suspend fun getLatestNews(): List<LatestNews> {
        return api.getLatestNews().data.map { it.convertToDomainModel() }
    }
}
