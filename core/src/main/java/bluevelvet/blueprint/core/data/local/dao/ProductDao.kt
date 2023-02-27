package bluevelvet.blueprint.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bluevelvet.blueprint.core.data.local.model.ProductEntity
import bluevelvet.blueprint.core.data.local.model.ProductEntity.Companion.COL_CATEGORY_ID
import bluevelvet.blueprint.core.data.local.model.ProductEntity.Companion.COL_ID
import bluevelvet.blueprint.core.data.local.model.ProductEntity.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(entity: ProductEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<ProductEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COL_ID = :id")
    fun get(id: String): Flow<ProductEntity?>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COL_CATEGORY_ID = :categoryId")
    fun getByCategoryId(categoryId: String): Flow<List<ProductEntity>>

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()
}