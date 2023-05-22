package mortitech.blueprint.gradle.plugin

import com.android.build.gradle.BaseExtension
import mortitech.blueprint.gradle.androidSetup
import mortitech.blueprint.gradle.commonSetup
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.Properties

class AndroidApplicationPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.apply(mapOf("plugin" to "com.android.application"))
        project.apply(mapOf("plugin" to "kotlin-android"))
        project.apply(mapOf("plugin" to "com.google.gms.google-services"))
        project.apply(mapOf("plugin" to "com.google.firebase.crashlytics"))
        project.apply(mapOf("plugin" to "org.jetbrains.kotlin.android"))
        project.apply(mapOf("plugin" to "kotlin-kapt"))
        project.apply(mapOf("plugin" to "kotlin-parcelize"))
        project.apply(mapOf("plugin" to "androidx.navigation.safeargs"))
        project.apply(mapOf("plugin" to "dagger.hilt.android.plugin"))

        project.commonSetup()
        project.androidSetup()

        project.extensions.findByName("android")!!.apply {
            this as BaseExtension

            buildToolsVersion = "33.0.0"

            defaultConfig.apply {
                applicationId = "mortitech.blueprint.mvi"
                targetSdk = 33
                versionCode = 1
                versionName = "1.0.0"

                // Specifies the application ID for the test APK.
                testApplicationId = "mortitech.blueprint.mvi.testing"
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            buildFeatures.viewBinding = true
            dataBinding {
                enable = true
            }

            val f = project.file("${project.rootDir}/keys/keystore.properties")
            signingConfigs.apply {
                val props = Properties()
                if (f.exists()) {
                    props.load(f.reader())
                }
                create("release").apply {
                    keyAlias = props.getProperty("keyAlias")
                    keyPassword = props.getProperty("keyAliasPassword")
                    storeFile = project.file("keystore.release")
                    storePassword = props.getProperty("keyAliasPassword")
                }

                getByName("debug").apply {
                    keyAlias = "android"
                    keyPassword = "android"
                    storeFile = project.file("${project.rootDir}/keys/keystore.debug")
                    storePassword = "android"
                }
            }

            buildTypes.apply {
                getByName("debug") {
                    signingConfig = signingConfigs.getByName("debug")
                    buildConfigField("String", "BASE_URL", "\"http://localhost:8080\"")
                    manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
                    applicationIdSuffix = ".dev"
                }
                create("acceptance") {
                    initWith(getByName("debug"))
                    buildConfigField("String", "BASE_URL", "\"http://localhost:8080\"")
                    manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
                    applicationIdSuffix = ".acc"
                }
                getByName("release").apply {
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android.txt"),
                        "proguard-rules.pro"
                    )
                    if (f.exists()) {
                        signingConfig = signingConfigs.getByName("release")
                    }

                    buildConfigField("String", "BASE_URL", "\"http://localhost:8080\"")
                    manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
                }
            }
        }
    }
}
