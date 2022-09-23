package orangevelvet.blueprint.account.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orangevelvet.blueprint.account.datasource.network.service.fake.FakeEventNetworkNetworkServiceImpl
import orangevelvet.blueprint.account.domain.contract.EventNetworkService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkServiceModule {

    @Singleton
    @Binds
    abstract fun bindEventNetworkService(
        eventNetworkNetworkService: FakeEventNetworkNetworkServiceImpl
    ): EventNetworkService
}