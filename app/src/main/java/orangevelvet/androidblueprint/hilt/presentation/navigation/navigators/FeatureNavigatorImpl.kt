package orangevelvet.androidblueprint.hilt.presentation.navigation.navigators

import android.app.Application
import orangevelvet.androidblueprint.hilt.presentation.navigation.actions.Actions
import javax.inject.Inject

class FeatureNavigatorImpl
@Inject
constructor(
    private val application: Application
): FeatureNavigator {
    override fun main() = Actions.openMainIntent(application)
    override fun account() = Actions.openAccountIntent(application)
}
