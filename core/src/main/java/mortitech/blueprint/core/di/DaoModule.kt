package mortitech.blueprint.core.di

import mortitech.blueprint.core.data.local.dao.CategoryDao
import mortitech.blueprint.core.data.local.dao.ProductDao
import mortitech.blueprint.core.data.local.provider.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao = appDatabase.categoryDao()

    @Provides
    fun provideProductDao(appDatabase: AppDatabase): ProductDao = appDatabase.productDao()
}