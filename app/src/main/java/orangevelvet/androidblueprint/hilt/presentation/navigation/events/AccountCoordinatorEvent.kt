package orangevelvet.androidblueprint.hilt.presentation.navigation.events

sealed class AccountCoordinatorEvent : CoordinatorEvent {
    object Logout : AccountCoordinatorEvent()
}
