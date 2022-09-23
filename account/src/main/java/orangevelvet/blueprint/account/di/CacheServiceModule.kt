package orangevelvet.blueprint.account.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orangevelvet.blueprint.account.datasource.cache.service.EventCacheServiceImpl
import orangevelvet.blueprint.account.datasource.network.service.fake.FakeEventNetworkNetworkServiceImpl
import orangevelvet.blueprint.account.domain.contract.EventCacheService
import orangevelvet.blueprint.account.domain.contract.EventNetworkService
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