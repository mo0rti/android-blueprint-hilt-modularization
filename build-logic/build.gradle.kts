import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    `embedded-kotlin`
    `java-gradle-plugin`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.google.services)
    implementation(libs.firebase.crashlytics.gradle)
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        create("embedded-kotlin") {
            id = "mortitech.blueprint.gradle.android.application"
            implementationClass = "mortitech.blueprint.gradle.plugin.AndroidApplicationPlugin"
        }
    }
}