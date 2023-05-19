package mortitech.blueprint.core.data.local.provider

import androidx.room.Database
import androidx.room.RoomDatabase
import mortitech.blueprint.core.data.local.dao.CategoryDao
import mortitech.blueprint.core.data.local.dao.ProductDao
import mortitech.blueprint.core.data.local.model.CategoryEntity
import mortitech.blueprint.core.data.local.model.ProductEntity

@Database(
    entities = [
        ProductEntity::class,
        CategoryEntity::class,
    ],
    version = 2,
    exportSchema = false,
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao
}
