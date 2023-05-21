package mortitech.blueprint.gradle.plugin

import com.android.build.gradle.BaseExtension
import mortitech.blueprint.gradle.androidSetup
import mortitech.blueprint.gradle.commonSetup
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.*

class AndroidApplicationPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.apply(mapOf("plugin" to "com.android.application"))
        project.apply(mapOf("plugin" to "kotlin-android"))
        project.apply(mapOf("plugin" to "com.google.gms.google-services"))
        project.apply(mapOf("plugin" to "com.google.firebase.crashlytics"))

        project.commonSetup()
        project.androidSetup()

        project.extensions.findByName("android")!!.apply {
            this as BaseExtension
            defaultConfig.apply {
                namespace = "mortitech.blueprint.mvi"
                minSdk = 29
                targetSdk = 33
                versionCode = 1
                versionName = "1.0.0"
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                // Sets Java compatibility to Java 8
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }

            buildFeatures.viewBinding = true

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
                    storeFile = project.file("keystore.debug")
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

