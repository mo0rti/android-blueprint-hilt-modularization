package bluevelvet.blueprint.account.di

import bluevelvet.blueprint.account.data.remote.api.DashboardApi
import bluevelvet.blueprint.core.di.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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

    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}