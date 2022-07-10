package orangevelvet.androidblueprint.hilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orangevelvet.androidblueprint.hilt.datasource.network.api.DashboardApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideDashboardApi(
        retrofitBuilder: Retrofit.Builder
    ): DashboardApi {
        return retrofitBuilder.build().create(DashboardApi::class.java)
    }
}