package orangevelvet.blueprint.account.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orangevelvet.blueprint.account.domain.contract.EventCacheService
import orangevelvet.blueprint.account.domain.contract.EventNetworkService
import orangevelvet.blueprint.account.domain.usercase.event.BookmarkEvent
import orangevelvet.blueprint.account.domain.usercase.event.EventUseCases
import orangevelvet.blueprint.account.domain.usercase.event.GetLatestEvents
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideEventUseCases(
        cacheService: EventCacheService,
        networkService: EventNetworkService,
    ) = EventUseCases(
        getLatestEvents = GetLatestEvents(cacheService, networkService),
        bookmarkEvent = BookmarkEvent(cacheService, networkService),
    )
}