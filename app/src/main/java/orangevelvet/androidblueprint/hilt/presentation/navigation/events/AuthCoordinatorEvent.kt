package orangevelvet.androidblueprint.hilt.presentation.navigation.events

sealed class AuthCoordinatorEvent : CoordinatorEvent {
    object ForgotPinCode : AuthCoordinatorEvent()
    object AccountFlow : AuthCoordinatorEvent()
}
