import dependencies.addFragment

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
}

addFragment()

dependencies {
    implementation("androidx.navigation:navigation-runtime-ktx:2.5.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.0")
}
