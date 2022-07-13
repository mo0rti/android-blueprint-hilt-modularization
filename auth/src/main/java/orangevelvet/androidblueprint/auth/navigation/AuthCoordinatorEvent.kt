package orangevelvet.androidblueprint.auth.navigation

import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent

sealed class AuthCoordinatorEvent : CoordinatorEvent {
    object ForgotPinCode : AuthCoordinatorEvent()
    object AccountFlow : AuthCoordinatorEvent()
}
