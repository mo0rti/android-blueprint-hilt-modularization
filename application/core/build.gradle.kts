plugins {
    id("mortitech.blueprint.gradle.android.library")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":application:navigation"))
    implementation(project(":application:style"))

    implementation(libs.gson)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.androidx.fragment)

    // Navigation
    implementation(libs.androidx.navigation.runtime)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    // Glide
    implementation(libs.glide.runtime)
    kapt(libs.glide.compiler)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // LifeCycle
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewmodel)

    // Retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.gson)
    implementation(libs.retrofit2.converter.scalars)
    implementation(libs.okhttp3)
    implementation(libs.okhttp3.logging.interceptor)

    // Hilt
    implementation(libs.hilt.android.core)
    kapt(libs.hilt.compiler)
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.compiler)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)
    testImplementation(libs.room.testing)
}

kapt {
    correctErrorTypes = true
}