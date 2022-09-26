import dependencies.*

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = configuration.Versions.Build.CompileSdk
    buildToolsVersion = configuration.Versions.Build.BuildTools

    defaultConfig {
        minSdk = configuration.Versions.Build.MinSdk
        targetSdk = configuration.Versions.Build.TargetSdk

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
addFragment()
addNavigationCore()
addNavigationUI()
addHilt()
addRetrofit()
addGson()

dependencies {
    implementation(project(":navigation"))
    implementation(project(":style"))
    implementation("androidx.test.ext:junit-ktx:1.1.3")
}

kapt {
    correctErrorTypes = true
}