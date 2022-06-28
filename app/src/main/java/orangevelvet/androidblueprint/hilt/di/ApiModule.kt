package orangevelvet.androidblueprint.hilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import orangevelvet.androidblueprint.hilt.datasource.network.api.CurrencyApi
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object ApiModule {

    @Provides
    fun provideCurrencyApi(
        retrofitBuilder: Retrofit.Builder
    ): CurrencyApi {
        return retrofitBuilder.build().create(CurrencyApi::class.java)
    }
}