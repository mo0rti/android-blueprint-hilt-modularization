package bluevelvet.blueprint.account.di

import bluevelvet.blueprint.account.domain.contract.EventCacheService
import bluevelvet.blueprint.account.domain.contract.EventNetworkService
import bluevelvet.blueprint.account.domain.usercase.event.BookmarkEvent
import bluevelvet.blueprint.account.domain.usercase.event.EventUseCases
import bluevelvet.blueprint.account.domain.usercase.event.GetLatestEvents
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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