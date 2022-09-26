package bluevelvet.blueprint.account.domain.usercase.event

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import bluevelvet.blueprint.account.domain.contract.EventCacheService
import bluevelvet.blueprint.account.domain.contract.EventNetworkService
import bluevelvet.blueprint.account.domain.model.Event

class GetLatestEvents(
    private val cacheService: EventCacheService,
    private val networkService: EventNetworkService,
) {
    suspend operator fun invoke(): Flow<List<Event>> = flow {
        emit(networkService.getLatestEvents())
    }
}