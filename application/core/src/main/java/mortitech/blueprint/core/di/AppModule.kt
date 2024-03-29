package mortitech.blueprint.core.di

import android.app.Application
import androidx.room.Room
import mortitech.blueprint.core.BuildConfig
import mortitech.blueprint.core.data.local.provider.AppDatabase
import mortitech.blueprint.core.manager.ApplicationStateManagerImpl
import mortitech.blueprint.core.manager.UserSessionManagerImpl
import mortitech.blueprint.core.manager.contract.ApplicationStateManager
import mortitech.blueprint.core.manager.contract.UserSessionManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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
            .baseUrl("https://myapi.com/api/")
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "db")
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}