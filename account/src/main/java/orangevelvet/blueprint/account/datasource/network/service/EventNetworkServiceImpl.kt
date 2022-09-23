package orangevelvet.blueprint.account.datasource.network.service

import orangevelvet.blueprint.account.datasource.network.api.DashboardApi
import orangevelvet.blueprint.account.domain.contract.EventNetworkService
import orangevelvet.blueprint.account.domain.model.Event
import javax.inject.Inject

class EventNetworkServiceImpl
@Inject
constructor(
    private val api: DashboardApi
): EventNetworkService {
    override suspend fun getLatestEvents(): List<Event> {
        return api.getLatestEvents().data.map { it.convertToDomainModel() }
    }

    override suspend fun bookmarkEvent(event: Event): Boolean {
        return true
    }
}
