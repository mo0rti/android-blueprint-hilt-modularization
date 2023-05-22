package mortitech.blueprint.gradle.plugin

import com.android.build.gradle.BaseExtension
import mortitech.blueprint.gradle.androidSetup
import mortitech.blueprint.gradle.commonSetup
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.apply(mapOf("plugin" to "com.android.library"))
        project.apply(mapOf("plugin" to "kotlin-android"))

        project.commonSetup()
        project.androidSetup()

        project.extensions.findByName("android")!!.apply {
            this as BaseExtension

            defaultConfig.apply {
                consumerProguardFiles("consumer-rules.pro")
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            buildTypes.apply {
                create("acceptance") {
                    initWith(getByName("debug"))
                }
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }
}