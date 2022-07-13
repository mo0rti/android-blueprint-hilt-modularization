package orangevelvet.blueprint.account.datasource.network.service

import orangevelvet.blueprint.account.datasource.network.api.DashboardApi
import orangevelvet.blueprint.core.domain.contract.network.DashboardNetworkService
import orangevelvet.blueprint.core.domain.model.LatestNews
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
