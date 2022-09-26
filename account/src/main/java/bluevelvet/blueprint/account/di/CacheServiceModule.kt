package bluevelvet.blueprint.account.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import bluevelvet.blueprint.account.datasource.cache.service.EventCacheServiceImpl
import bluevelvet.blueprint.account.domain.contract.EventCacheService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheServiceModule {

    @Singleton
    @Binds
    abstract fun bindEventCacheService(
        eventCacheService: EventCacheServiceImpl
    ): EventCacheService
}