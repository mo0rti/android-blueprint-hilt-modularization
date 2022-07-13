package orangevelvet.androidblueprint.account.datasource.network.service

import orangevelvet.androidblueprint.account.datasource.network.api.DashboardApi
import orangevelvet.androidblueprint.core.domain.contract.network.DashboardNetworkService
import orangevelvet.androidblueprint.core.domain.model.LatestNews
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
