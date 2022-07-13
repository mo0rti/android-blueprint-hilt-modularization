package orangevelvet.blueprint.core.domain.model

import orangevelvet.blueprint.core.base.domain.BaseDomainModel

data class LatestNews (
    val id: String,
    val name: String,
    val description: String,
    val smallPhoto: String,
    val largePhotoUrl: String
): BaseDomainModel()
