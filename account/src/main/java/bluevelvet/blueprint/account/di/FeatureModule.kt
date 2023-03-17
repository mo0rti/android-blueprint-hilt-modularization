package bluevelvet.blueprint.account.di

import bluevelvet.blueprint.account.data.remote.api.DashboardApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object FeatureModule {

    @ActivityRetainedScoped
    @Provides
    fun provideDashboardApi(
        retrofitBuilder: Retrofit.Builder
    ): DashboardApi {
        return retrofitBuilder.build().create(DashboardApi::class.java)
    }
}
