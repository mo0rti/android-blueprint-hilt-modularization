plugins {
    id("mortitech.blueprint.gradle.android.library")
}

android {
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":application:style"))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.android.material)
}