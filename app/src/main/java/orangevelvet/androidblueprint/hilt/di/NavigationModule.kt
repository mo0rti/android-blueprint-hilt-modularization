package orangevelvet.androidblueprint.hilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orangevelvet.androidblueprint.hilt.presentation.navigation.navigators.FeatureNavigatorImpl
import orangevelvet.androidblueprint.navigation.navigator.FeatureNavigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Singleton
    @Binds
    abstract fun bindFeatureNavigator(featureNavigator: FeatureNavigatorImpl): FeatureNavigator

}