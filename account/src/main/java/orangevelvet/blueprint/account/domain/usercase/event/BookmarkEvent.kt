package orangevelvet.blueprint.account.domain.usercase.event

import orangevelvet.blueprint.account.domain.contract.EventCacheService
import orangevelvet.blueprint.account.domain.contract.EventNetworkService
import orangevelvet.blueprint.account.domain.model.Event

class BookmarkEvent(
    private val cacheService: EventCacheService,
    private val networkService: EventNetworkService,
) {
    suspend operator fun invoke(event: Event) {
        networkService.bookmarkEvent(event)
    }
}