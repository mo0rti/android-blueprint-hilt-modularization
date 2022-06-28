package orangevelvet.androidblueprint.hilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import orangevelvet.androidblueprint.hilt.datasource.network.service.CurrencyNetworkNetworkServiceImpl
import orangevelvet.androidblueprint.hilt.domain.contract.CurrencyNetworkService

@Module
@InstallIn(ActivityComponent::class)
abstract class NetworkServiceModule {

    @Binds
    abstract fun bindCurrencyNetworkService(
        currencyNetworkServiceImpl: CurrencyNetworkNetworkServiceImpl
    ): CurrencyNetworkService
}