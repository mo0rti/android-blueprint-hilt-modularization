package orangevelvet.androidblueprint.core.navigation

import android.app.Application
import orangevelvet.androidblueprint.navigation.action.Actions
import orangevelvet.androidblueprint.navigation.navigator.FeatureNavigator
import javax.inject.Inject

class FeatureNavigatorImpl
@Inject
constructor(
    private val application: Application
): FeatureNavigator {
    override fun main() = Actions.openMainIntent(application)
    override fun auth() = Actions.openAuthIntent(application)
    override fun account() = Actions.openAccountIntent(application)
}
