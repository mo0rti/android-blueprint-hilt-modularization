package orangevelvet.androidblueprint.hilt.di

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import orangevelvet.androidblueprint.hilt.BuildConfig
import orangevelvet.androidblueprint.hilt.domain.contract.session.ApplicationStateManager
import orangevelvet.androidblueprint.hilt.domain.contract.session.UserSessionManager
import orangevelvet.androidblueprint.hilt.domain.manager.ApplicationStateManagerImpl
import orangevelvet.androidblueprint.hilt.domain.manager.UserSessionManagerImpl
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
            .baseUrl("https://api.coinbase.com")
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
}