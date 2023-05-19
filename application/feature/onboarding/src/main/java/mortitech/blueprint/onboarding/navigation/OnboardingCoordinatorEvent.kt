package mortitech.blueprint.onboarding.navigation

import mortitech.blueprint.navigation.event.CoordinatorEvent

sealed class OnboardingCoordinatorEvent : CoordinatorEvent {
    object BackToLogin : OnboardingCoordinatorEvent()
    object AccountFlow : OnboardingCoordinatorEvent()
}
