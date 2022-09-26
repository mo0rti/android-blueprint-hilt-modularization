package bluevelvet.blueprint.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import bluevelvet.blueprint.core.navigation.FeatureNavigatorImpl
import bluevelvet.blueprint.navigation.navigator.FeatureNavigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Singleton
    @Binds
    abstract fun bindFeatureNavigator(featureNavigator: FeatureNavigatorImpl): FeatureNavigator
}