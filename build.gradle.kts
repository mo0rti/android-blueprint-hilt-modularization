// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${configuration.Versions.Build.Gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${configuration.Versions.AndroidDependencies.NavigationComponent}")
        classpath("com.google.gms:google-services:${configuration.Versions.AndroidDependencies.GoogleServices}")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${configuration.Versions.AndroidDependencies.Hilt}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}