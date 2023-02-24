package bluevelvet.blueprint.onboarding.navigation

import bluevelvet.blueprint.navigation.event.CoordinatorEvent

sealed class OnboardingCoordinatorEvent : CoordinatorEvent {
    object BackToLogin : OnboardingCoordinatorEvent()
    object AccountFlow : OnboardingCoordinatorEvent()
}
