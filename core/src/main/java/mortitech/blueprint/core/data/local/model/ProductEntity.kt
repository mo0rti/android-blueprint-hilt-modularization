package mortitech.blueprint.core.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import mortitech.blueprint.core.data.local.model.ProductEntity.Companion.TABLE_NAME
import mortitech.blueprint.core.data.local.model.base.EntityModel
import mortitech.blueprint.core.domain.model.Category
import mortitech.blueprint.core.domain.model.Product

@Entity(tableName = TABLE_NAME)
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = COL_ID)
    val id: String = "",

    @ColumnInfo(name = COL_NAME)
    val name: String = "",

    @ColumnInfo(name = COL_CATEGORY_ID)
    val categoryId: String = "",

    @ColumnInfo(name = COL_DESCRIPTION)
    val description: String = "",

    @ColumnInfo(name = COL_IMAGE)
    val imageUrl: String = "",

    ): EntityModel() {
    companion object {
        const val TABLE_NAME = "product"
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_CATEGORY_ID = "categoryId"
        const val COL_DESCRIPTION = "description"
        const val COL_IMAGE = "imageUrl"
    }

    fun toDomainModel(findCategory: (String) -> Category): Product {
        return Product(
            id = id,
            name = name,
            category = findCategory(categoryId),
            description = description,
            imageUrl = imageUrl
        )
    }
}