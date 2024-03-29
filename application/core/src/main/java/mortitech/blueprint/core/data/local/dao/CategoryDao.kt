package mortitech.blueprint.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mortitech.blueprint.core.data.local.model.CategoryEntity
import mortitech.blueprint.core.data.local.model.CategoryEntity.Companion.COL_ID
import mortitech.blueprint.core.data.local.model.CategoryEntity.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(entity: CategoryEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<CategoryEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COL_ID = :id")
    fun get(id: String): Flow<CategoryEntity?>

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()
}