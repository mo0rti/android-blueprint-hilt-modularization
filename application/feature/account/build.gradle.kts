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
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
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
addMockUtils()
addUITestUtils()

dependencies {
    implementation(project(":application:navigation"))
    implementation(project(":application:style"))
    implementation(project(":application:core"))
    implementation(project(":application:ui-components"))
}

kapt {
    correctErrorTypes = true
}