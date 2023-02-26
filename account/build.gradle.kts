import configuration.Versions
import dependencies.*

plugins {
    id("com.android.library")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.Build.CompileSdk

    defaultConfig {
        minSdk = Versions.Build.MinSdk
        targetSdk = Versions.Build.TargetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
addMaterialDesign()
addNavigationCore()
addNavigationUI()
addNavigationComponent()
addGson()
addRetrofit()
addGlide()
addHilt()
addAndroidxCoreTesting()
addUITestUtils()

dependencies {
    implementation(project(":navigation"))
    implementation(project(":style"))
    implementation(project(":core"))
    implementation(project(":ui-components"))
    implementation("androidx.recyclerview:recyclerview:1.2.1")
}

kapt {
    correctErrorTypes = true
}