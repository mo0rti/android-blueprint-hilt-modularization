plugins {
    id("mortitech.blueprint.gradle.android.library")
}

android {
    namespace = "mortitech.blueprint.foundation"
}

dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.android.material)

    // Test
    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.ext)
    testImplementation(libs.androidx.test.core.ktx)
    testImplementation(libs.androidx.test.rules)
    testImplementation(libs.androidx.test.runner)

    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.core.ktx)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.espresso)
}