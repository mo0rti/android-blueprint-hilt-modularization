package orangevelvet.blueprint.auth.navigation

import orangevelvet.blueprint.navigation.event.CoordinatorEvent

sealed class AuthCoordinatorEvent : CoordinatorEvent {
    object ForgotPinCode : AuthCoordinatorEvent()
    object AccountFlow : AuthCoordinatorEvent()
}
