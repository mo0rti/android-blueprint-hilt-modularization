package mortitech.blueprint.core.navigation

import android.app.Application
import mortitech.blueprint.navigation.action.Actions
import mortitech.blueprint.navigation.navigator.FeatureNavigator
import javax.inject.Inject

class FeatureNavigatorImpl
@Inject
constructor(
    private val application: Application
): FeatureNavigator {
    override fun app() = Actions.openAppIntent(application)
    override fun auth() = Actions.openAuthIntent(application)
    override fun account() = Actions.openAccountIntent(application)
    override fun onboarding() = Actions.openOnboardingIntent(application)
}
