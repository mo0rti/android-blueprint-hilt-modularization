package bluevelvet.blueprint.account.domain.model

import bluevelvet.blueprint.core.domain.model.DomainModel

data class Event (
    val id: String,
    val title: String,
    val description: String,
    val smallPhoto: String,
    val largePhotoUrl: String
): DomainModel()
