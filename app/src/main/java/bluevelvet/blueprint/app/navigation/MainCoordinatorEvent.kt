package bluevelvet.blueprint.app.navigation

import bluevelvet.blueprint.navigation.event.CoordinatorEvent

sealed class MainCoordinatorEvent : CoordinatorEvent {
    object AuthFlow : MainCoordinatorEvent()
    object AccountFlow : MainCoordinatorEvent()
}
