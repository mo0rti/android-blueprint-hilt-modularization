package orangevelvet.androidblueprint.hilt.presentation.navigation.events

import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent

sealed class MainCoordinatorEvent : CoordinatorEvent {
    object AuthFlow : MainCoordinatorEvent()
    object AccountFlow : MainCoordinatorEvent()
}
