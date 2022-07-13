package orangevelvet.androidblueprint.navigation.navigator

import android.content.Intent

interface FeatureNavigator {
    fun main(): Intent
    fun auth(): Intent
    fun account(): Intent
}