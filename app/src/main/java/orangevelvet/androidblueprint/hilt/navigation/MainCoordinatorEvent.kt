package orangevelvet.androidblueprint.hilt.navigation

import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent

sealed class MainCoordinatorEvent : CoordinatorEvent {
    object AuthFlow : MainCoordinatorEvent()
    object AccountFlow : MainCoordinatorEvent()
}
