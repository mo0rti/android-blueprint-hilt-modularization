package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.apply(mapOf("plugin" to "com.android.application"))
        project.apply(mapOf("plugin" to "kotlin-android"))
        project.apply(mapOf("plugin" to "com.google.gms.google-services"))
        project.apply(mapOf("plugin" to "com.google.firebase.crashlytics"))

        project.extensions.findByName("android")!!.apply {
        }
    }
}

