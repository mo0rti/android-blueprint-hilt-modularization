package orangevelvet.androidblueprint.account.navigation

import orangevelvet.androidblueprint.navigation.event.CoordinatorEvent

sealed class AccountCoordinatorEvent : CoordinatorEvent {
    object Logout : AccountCoordinatorEvent()
}
