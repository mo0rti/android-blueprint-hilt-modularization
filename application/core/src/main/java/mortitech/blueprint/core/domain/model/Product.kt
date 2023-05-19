package mortitech.blueprint.core.domain.model

import mortitech.blueprint.core.extensions.randomId

data class Product(
    val id: String = "".randomId(),
    val name: String,
    val category: Category,
    val description: String,
    val imageUrl: String
): DomainModel()