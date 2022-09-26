package bluevelvet.blueprint.account.navigation

import bluevelvet.blueprint.navigation.event.CoordinatorEvent

sealed class AccountCoordinatorEvent : CoordinatorEvent {
    object Logout : AccountCoordinatorEvent()
}
