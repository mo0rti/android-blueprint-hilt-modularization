package bluevelvet.blueprint.core.model

import bluevelvet.blueprint.core.base.domain.BaseDomainModel

data class Product(val name: String, val description: String, val imageUrl: String): BaseDomainModel()