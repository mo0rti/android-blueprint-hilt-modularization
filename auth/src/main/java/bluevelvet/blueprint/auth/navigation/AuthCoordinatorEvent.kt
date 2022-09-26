package bluevelvet.blueprint.auth.navigation

import bluevelvet.blueprint.navigation.event.CoordinatorEvent

sealed class AuthCoordinatorEvent : CoordinatorEvent {
    object ForgotPinCode : AuthCoordinatorEvent()
    object AccountFlow : AuthCoordinatorEvent()
}
