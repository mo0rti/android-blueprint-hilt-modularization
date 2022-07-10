package orangevelvet.androidblueprint.hilt.presentation.navigation.events

sealed class MainCoordinatorEvent : CoordinatorEvent {
    object Login : MainCoordinatorEvent()
    object Account : MainCoordinatorEvent()
}
