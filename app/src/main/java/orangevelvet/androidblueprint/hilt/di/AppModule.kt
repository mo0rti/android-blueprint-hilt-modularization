package orangevelvet.androidblueprint.hilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import orangevelvet.androidblueprint.hilt.domain.contract.CurrencyService

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    /*
    @Binds
    abstract fun bindCurrencyService(

    ): CurrencyService*/
}