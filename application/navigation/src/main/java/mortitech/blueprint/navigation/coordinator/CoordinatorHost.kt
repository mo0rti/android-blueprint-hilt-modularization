package mortitech.blueprint.navigation.coordinator

interface CoordinatorHost<C: Coordinator> {
    val coordinator: C
}