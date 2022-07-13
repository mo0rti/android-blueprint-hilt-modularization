package orangevelvet.androidblueprint.hilt.presentation.navigation.events

sealed class MainCoordinatorEvent : CoordinatorEvent {
    object AuthFlow : MainCoordinatorEvent()
    object AccountFlow : MainCoordinatorEvent()
}
