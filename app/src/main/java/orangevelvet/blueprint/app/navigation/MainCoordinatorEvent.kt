package orangevelvet.blueprint.app.navigation

import orangevelvet.blueprint.navigation.event.CoordinatorEvent

sealed class MainCoordinatorEvent : CoordinatorEvent {
    object AuthFlow : MainCoordinatorEvent()
    object AccountFlow : MainCoordinatorEvent()
}
