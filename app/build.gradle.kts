import configuration.Application
import configuration.Versions
import dependencies.*

plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs")
    id("com.google.firebase.crashlytics")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Versions.Build.CompileSdk
    buildToolsVersion = Versions.Build.BuildTools

    defaultConfig {
        applicationId = Application.Id
        minSdk = Versions.Build.MinSdk
        targetSdk = Versions.Build.TargetSdk
        versionCode = Application.VersionCode
        versionName = Application.VersionName

        // Specifies the application ID for the test APK.
        testApplicationId = "${Application.Id}.testing"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file("certificates/debug_signing.keystore")
            keyAlias = "alias"
            storePassword = "123456789"
            keyPassword = "123456789"
        }
        create("release") {
            // This variables should be set via release pipeline
            storeFile = rootProject.file(System.getenv("KEYSTORE_FILE") ?: ".")
            keyAlias = System.getenv("KEYSTORE_ALIAS")
            storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyPassword = System.getenv("KEYSTORE_PASSWORD")
        }
    }

    buildTypes {
        Application.DEVELOPMENT.apply {
            getByName(BuildName) {
                buildConfigField("String", "BASE_URL", EndPoint)
                manifestPlaceholders["app_icon"] = Icon
                applicationIdSuffix = ApplicationIdSuffix
                signingConfig = signingConfigs.getByName("debug")
                isDebuggable = true
            }
        }
        Application.ACCEPTANCE.apply {
            create(BuildName) {
                initWith(getByName(Application.DEVELOPMENT.BuildName))
                buildConfigField("String", "BASE_URL", EndPoint)
                manifestPlaceholders["app_icon"] = Icon
                applicationIdSuffix = ApplicationIdSuffix
                signingConfig = signingConfigs.getByName("debug")
            }
        }
        Application.RELEASE.apply {
            getByName(BuildName) {
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                buildConfigField("String", "IDP_BASE_URL", EndPoint)
                manifestPlaceholders["app_icon"] = Icon
                signingConfig = signingConfigs.getByName("release")
                isDebuggable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

addAndroidCore()
addFragment()
addNavigationCore()
addNavigationUI()
addFirebase()
addNavigationComponent()
addMaterialDesign()
addLayouts()
addHilt()
addRetrofit()
addGson()
addCoroutines()

addAndroidxCoreTesting()
addUITestUtils()

dependencies {
    implementation(project(":navigation"))
    implementation(project(":core"))
    implementation(project(":account"))
    implementation(project(":auth"))
    implementation(project(":style"))
}

kapt {
    correctErrorTypes = true
}