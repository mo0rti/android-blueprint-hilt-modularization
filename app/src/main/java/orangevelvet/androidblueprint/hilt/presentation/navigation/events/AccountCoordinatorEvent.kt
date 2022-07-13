package orangevelvet.androidblueprint.hilt.presentation.navigation.events

import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent

sealed class AccountCoordinatorEvent : CoordinatorEvent {
    object Logout : AccountCoordinatorEvent()
}
