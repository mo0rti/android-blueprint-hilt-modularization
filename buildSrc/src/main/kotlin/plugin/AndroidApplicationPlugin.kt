package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.apply(mapOf("plugin" to "com.android.application"))
        target.apply(mapOf("plugin" to "kotlin-android"))
        target.apply(mapOf("plugin" to "com.google.gms.google-services"))
        target.apply(mapOf("plugin" to "com.google.firebase.crashlytics"))

        target.extensions.findByName("android")!!.apply {
        }
    }
}

