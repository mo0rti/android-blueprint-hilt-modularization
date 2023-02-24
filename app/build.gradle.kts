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
        create("release") {
            storeFile = rootProject.file("signingkey.keystore")
            keyAlias = "alias"
            storePassword = "123456789"
            keyPassword = "123456789"
        }
    }

    buildTypes {
        Application.DEV.apply {
            getByName(BuildName) {
                buildConfigField("String", "BASE_URL", EndPoint)
                buildConfigField("String", "APP_ICON", "\"${Icon}\"")
                manifestPlaceholders["app_label"] = Label
                manifestPlaceholders["app_icon"] = Icon
                applicationIdSuffix = ApplicationIdSuffix
                signingConfig = signingConfigs.getByName("release")
                isDebuggable = true
            }
        }
        Application.STAGING.apply {
            create(BuildName) {
                initWith(getByName(Application.DEV.BuildName))
                buildConfigField("String", "BASE_URL", EndPoint)
                buildConfigField("String", "APP_ICON", "\"${Icon}\"")
                manifestPlaceholders["app_label"] = Label
                manifestPlaceholders["app_icon"] = Icon
                applicationIdSuffix = ApplicationIdSuffix
                signingConfig = signingConfigs.getByName("release")
            }
        }
        Application.RELEASE.apply {
            getByName(BuildName) {
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                buildConfigField("String", "IDP_BASE_URL", EndPoint)
                buildConfigField("String", "IDP_APP_ICON", "\"${Icon}\"")
                manifestPlaceholders["app_label"] = Label
                manifestPlaceholders["app_icon"] = Icon
                // Should be replaced with azure pipeline signing when it's ready for production
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