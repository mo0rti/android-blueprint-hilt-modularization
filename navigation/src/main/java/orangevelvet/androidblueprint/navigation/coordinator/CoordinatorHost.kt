package orangevelvet.androidblueprint.navigation.coordinator

interface CoordinatorHost<C: Coordinator> {
    val coordinator: C
}