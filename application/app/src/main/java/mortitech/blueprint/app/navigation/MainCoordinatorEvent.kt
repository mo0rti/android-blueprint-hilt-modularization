package mortitech.blueprint.app.navigation

import mortitech.blueprint.navigation.event.CoordinatorEvent

sealed class MainCoordinatorEvent : CoordinatorEvent {
    object AuthFlow : MainCoordinatorEvent()
    object AccountFlow : MainCoordinatorEvent()
}
