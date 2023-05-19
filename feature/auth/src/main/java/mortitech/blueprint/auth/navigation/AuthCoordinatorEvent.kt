package mortitech.blueprint.auth.navigation

import mortitech.blueprint.navigation.event.CoordinatorEvent

sealed class AuthCoordinatorEvent : CoordinatorEvent {
    object ForgotPinCode : AuthCoordinatorEvent()
    object BackToLogin : AuthCoordinatorEvent()
    object AccountFlow : AuthCoordinatorEvent()
    object OnboardingFlow : AuthCoordinatorEvent()
}
