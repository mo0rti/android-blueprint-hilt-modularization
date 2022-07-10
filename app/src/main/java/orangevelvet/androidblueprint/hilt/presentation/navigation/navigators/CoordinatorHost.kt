package orangevelvet.androidblueprint.hilt.presentation.navigation.navigators

interface CoordinatorHost<C: Coordinator> {
    val coordinator: C
}