package bluevelvet.blueprint.account.di

import bluevelvet.blueprint.account.datasource.network.api.DashboardApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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