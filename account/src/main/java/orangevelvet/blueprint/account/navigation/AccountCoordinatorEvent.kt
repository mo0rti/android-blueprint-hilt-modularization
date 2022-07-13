package orangevelvet.blueprint.account.navigation

import orangevelvet.blueprint.navigation.event.CoordinatorEvent

sealed class AccountCoordinatorEvent : CoordinatorEvent {
    object Logout : AccountCoordinatorEvent()
}
