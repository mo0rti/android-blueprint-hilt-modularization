package bluevelvet.blueprint.account.datasource.network.service

import bluevelvet.blueprint.account.datasource.network.api.DashboardApi
import bluevelvet.blueprint.account.domain.contract.EventNetworkService
import bluevelvet.blueprint.account.domain.model.Event
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
