package orangevelvet.androidblueprint.hilt.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import orangevelvet.androidblueprint.hilt.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    fun provideGsonBuilder(): Gson = GsonBuilder().disableHtmlEscaping().create()

    @Provides
    fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideRetrofit(
        gson: Gson,
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