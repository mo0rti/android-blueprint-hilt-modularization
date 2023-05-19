package mortitech.blueprint.account.navigation

import mortitech.blueprint.navigation.event.CoordinatorEvent

sealed class AccountCoordinatorEvent : CoordinatorEvent {
    object Logout : AccountCoordinatorEvent()
}
