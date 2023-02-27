package bluevelvet.blueprint.core.data.local.provider

import androidx.room.Database
import androidx.room.RoomDatabase
import bluevelvet.blueprint.core.data.local.dao.CategoryDao
import bluevelvet.blueprint.core.data.local.dao.ProductDao
import bluevelvet.blueprint.core.data.local.model.CategoryEntity
import bluevelvet.blueprint.core.data.local.model.ProductEntity

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
