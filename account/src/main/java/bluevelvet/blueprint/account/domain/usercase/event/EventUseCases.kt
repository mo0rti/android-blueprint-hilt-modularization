package bluevelvet.blueprint.account.domain.usercase.event

data class EventUseCases(
    val getLatestEvents: GetLatestEvents,
    val bookmarkEvent: BookmarkEvent,
)