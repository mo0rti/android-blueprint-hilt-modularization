package orangevelvet.blueprint.core.navigation

import android.app.Application
import orangevelvet.blueprint.navigation.action.Actions
import orangevelvet.blueprint.navigation.navigator.FeatureNavigator
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
