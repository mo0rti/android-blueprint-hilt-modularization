plugins {
    id("mortitech.blueprint.gradle.android.library")
}

dependencies {
    implementation(libs.androidx.fragment)

    implementation(libs.androidx.navigation.runtime)
    implementation(libs.androidx.navigation.fragment)
}
