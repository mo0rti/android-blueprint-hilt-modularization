package bluevelvet.blueprint.core.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import bluevelvet.blueprint.core.data.local.model.CategoryEntity.Companion.TABLE_NAME
import bluevelvet.blueprint.core.data.local.model.base.EntityModel
import bluevelvet.blueprint.core.domain.model.Category

@Entity(tableName = TABLE_NAME)
class CategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = COL_ID)
    val id: String = "",

    @ColumnInfo(name = COL_NAME)
    val name: String = "",

    @ColumnInfo(name = COL_IMAGE)
    val imageUrl: String = "",

    ): EntityModel() {
    companion object {
        const val TABLE_NAME = "category"
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_IMAGE = "imageUrl"

        fun fromDomainModel(domain: Category): CategoryEntity {
            return CategoryEntity(
                id = domain.id,
                name = domain.name,
                imageUrl = domain.imageUrl
            )
        }
    }

    fun toDomainModel(): Category {
        return Category(
            id = id,
            name = name,
            imageUrl = imageUrl
        )
    }
}