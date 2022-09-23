package orangevelvet.blueprint.account.domain.model

import orangevelvet.blueprint.core.base.domain.BaseDomainModel

data class Event (
    val id: String,
    val title: String,
    val description: String,
    val smallPhoto: String,
    val largePhotoUrl: String
): BaseDomainModel()
