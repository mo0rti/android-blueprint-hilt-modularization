import dependencies.*

plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 29
        targetSdk = 32

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
addHilt()
addAndroidxCoreTesting()
addUITestUtils()

dependencies {
    implementation(project(":navigation"))
    implementation(project(":style"))
    implementation(project(":core"))
}

kapt {
    correctErrorTypes = true
}