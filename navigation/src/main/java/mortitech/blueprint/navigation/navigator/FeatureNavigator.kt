package mortitech.blueprint.navigation.navigator

import android.content.Intent

interface FeatureNavigator {
    fun app(): Intent
    fun auth(): Intent
    fun account(): Intent
    fun onboarding(): Intent
}