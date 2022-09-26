package bluevelvet.blueprint.account.domain.usercase.event

import bluevelvet.blueprint.account.domain.contract.EventCacheService
import bluevelvet.blueprint.account.domain.contract.EventNetworkService
import bluevelvet.blueprint.account.domain.model.Event

class BookmarkEvent(
    private val cacheService: EventCacheService,
    private val networkService: EventNetworkService,
) {
    suspend operator fun invoke(event: Event) {
        networkService.bookmarkEvent(event)
    }
}