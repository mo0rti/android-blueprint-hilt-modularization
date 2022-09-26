package bluevelvet.blueprint.navigation.coordinator

interface CoordinatorHost<C: Coordinator> {
    val coordinator: C
}