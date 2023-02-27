package bluevelvet.blueprint.core.domain.model

import bluevelvet.blueprint.core.extensions.randomId

data class Category(
    val id: String = "".randomId(),
    val name: String,
    val imageUrl: String
): DomainModel()
