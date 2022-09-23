package orangevelvet.blueprint.account.domain.contract

import orangevelvet.blueprint.account.domain.model.Event

interface EventNetworkService {
    suspend fun getLatestEvents(): List<Event>
    suspend fun bookmarkEvent(event: Event): Boolean
}
