package orangevelvet.blueprint.account.domain.usercase.event

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import orangevelvet.blueprint.account.domain.contract.EventCacheService
import orangevelvet.blueprint.account.domain.contract.EventNetworkService
import orangevelvet.blueprint.account.domain.model.Event

class GetLatestEvents(
    private val cacheService: EventCacheService,
    private val networkService: EventNetworkService,
) {
    suspend operator fun invoke(): Flow<List<Event>> = flow {
        emit(networkService.getLatestEvents())
    }
}