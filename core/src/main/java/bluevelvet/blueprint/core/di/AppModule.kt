package bluevelvet.blueprint.core.di

import android.app.Application
import bluevelvet.blueprint.core.BuildConfig
import bluevelvet.blueprint.core.manager.contract.ApplicationStateManager
import bluevelvet.blueprint.core.manager.contract.UserSessionManager
import bluevelvet.blueprint.core.manager.ApplicationStateManagerImpl
import bluevelvet.blueprint.core.manager.UserSessionManagerImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplicationStateManager(
        application: Application,
        gson: Gson
    ): ApplicationStateManager {
        return ApplicationStateManagerImpl(application, gson)
    }

    @Singleton
    @Provides
    fun provideSessionManager(
        applicationStateManager: ApplicationStateManager
    ): UserSessionManager {
        return UserSessionManagerImpl(applicationStateManager)
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson = GsonBuilder().disableHtmlEscaping().create()

    @Singleton
    @Provides
    @LoggingInterceptorOkHttpClient
    fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gson: Gson,
        @LoggingInterceptorOkHttpClient
        loggingInterceptor: HttpLoggingInterceptor
    ): Retrofit.Builder {
        val client: OkHttpClient.Builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG)
            client.addInterceptor(loggingInterceptor)

        return Retrofit.Builder()
            .baseUrl("https://myapi.com/api")
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
}