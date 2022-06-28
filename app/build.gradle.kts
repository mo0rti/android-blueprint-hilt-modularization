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

    buildTypes {
        Application.DEV.apply {
            getByName(BuildName) {
                buildConfigField("String", "BASE_URL", EndPoint)
                buildConfigField("String", "APP_ICON", "\"${Icon}\"")
                manifestPlaceholders["app_label"] = Label
                manifestPlaceholders["app_icon"] = Icon
                applicationIdSuffix = ApplicationIdSuffix
                signingConfig = signingConfigs.getByName("debug")
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
                signingConfig = signingConfigs.getByName("debug")
            }
        }
        Application.RELEASE.apply {
            getByName(BuildName) {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                buildConfigField("String", "IDP_BASE_URL", EndPoint)
                buildConfigField("String", "IDP_APP_ICON", "\"${Icon}\"")
                manifestPlaceholders["app_label"] = Label
                manifestPlaceholders["app_icon"] = Icon
                // Should be replaced with azure pipeline signing when it's ready for production
                signingConfig = signingConfigs.getByName("debug")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
addMaterialDesign()
addLayouts()
addHilt()

addAndroidxCoreTesting()
addUITestUtils()
