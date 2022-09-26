package bluevelvet.blueprint.navigation.action

import android.app.Application
import android.content.Intent

/**
 * Inspired by: https://jeroenmols.com/blog/2019/04/02/modularizationexample/
 */
object Actions {
    fun openAppIntent(application: Application) =
        internalIntent(application, "bluevelvet.blueprint.hilt.app.open")

    fun openAuthIntent(application: Application) =
        internalIntent(application, "bluevelvet.blueprint.hilt.auth.open")

    fun openAccountIntent(application: Application) =
        internalIntent(application, "bluevelvet.blueprint.hilt.account.open")

    fun openOnboardingIntent(application: Application) =
        internalIntent(application, "bluevelvet.blueprint.hilt.onboarding.open")

    private fun internalIntent(application: Application, action: String) =
        Intent(action).setPackage(application.packageName)
}
