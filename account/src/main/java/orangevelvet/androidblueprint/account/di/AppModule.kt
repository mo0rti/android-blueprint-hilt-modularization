package orangevelvet.androidblueprint.account.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orangevelvet.androidblueprint.account.datasource.network.api.DashboardApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDashboardApi(
        retrofitBuilder: Retrofit.Builder
    ): DashboardApi {
        return retrofitBuilder.build().create(DashboardApi::class.java)
    }
}