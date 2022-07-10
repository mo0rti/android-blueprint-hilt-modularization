package orangevelvet.androidblueprint.hilt.presentation.navigation.navigators

import android.content.Intent

interface FeatureNavigator {
    fun main(): Intent
    fun account(): Intent
}