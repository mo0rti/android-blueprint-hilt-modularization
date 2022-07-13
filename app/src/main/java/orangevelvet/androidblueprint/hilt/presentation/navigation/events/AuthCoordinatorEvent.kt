package orangevelvet.androidblueprint.hilt.presentation.navigation.events

import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent

sealed class AuthCoordinatorEvent : CoordinatorEvent {
    object ForgotPinCode : AuthCoordinatorEvent()
    object AccountFlow : AuthCoordinatorEvent()
}
