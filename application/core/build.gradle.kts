import configuration.Versions
import dependencies.*

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.Build.CompileSdk

    defaultConfig {
        minSdk = Versions.Build.MinSdk

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
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

addAndroidCore()
addCoroutines()
addFragment()
addNavigationCore()
addNavigationUI()
addHilt()
addRetrofit()
addGlide()
addGson()
addRoom()
addAndroidxCoreTesting()
addCoroutineTesting()

dependencies {
    implementation(project(":application:navigation"))
    implementation(project(":application:style"))
}

kapt {
    correctErrorTypes = true
}