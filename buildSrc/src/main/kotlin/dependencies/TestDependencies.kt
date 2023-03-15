package dependencies

import configuration.Versions.TestDependencies
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.addUITestUtils() {
    dependencies {
        add("androidTestImplementation", "androidx.test.espresso:espresso-core:${TestDependencies.Espresso}")
        add("androidTestImplementation", "androidx.test.espresso:espresso-intents:${TestDependencies.Espresso}")
        add("androidTestImplementation", "androidx.test.espresso:espresso-web:${TestDependencies.Espresso}")
        add("androidTestImplementation", "androidx.test.espresso.idling:idling-concurrent:${TestDependencies.Espresso}")

        add("testImplementation", "org.robolectric:robolectric:${TestDependencies.Robolectric}")
        add("androidTestImplementation", "com.android.support.test.uiautomator:uiautomator-v18:${TestDependencies.UIAutomator}")
    }
}

fun Project.addMockUtils() {
    dependencies {
        add("testImplementation", "io.mockk:mockk:${TestDependencies.Mockk}")
        add("androidTestImplementation", "io.mockk:mockk-android:${TestDependencies.Mockk}")
        add("testImplementation", "org.mockito:mockito-core:${TestDependencies.Mockito}")
    }
}

fun Project.addAndroidxCoreTesting() {
    dependencies {
        add("testImplementation", "androidx.arch.core:core-common:${TestDependencies.AndroidxCoreTesting}")
        add("testImplementation", "androidx.arch.core:core-runtime:${TestDependencies.AndroidxCoreTesting}")
        add("testImplementation", "androidx.arch.core:core-testing:${TestDependencies.AndroidxCoreTesting}")

        add("testImplementation", "junit:junit:${TestDependencies.JUnit}")
        add("testImplementation", "androidx.test:rules:${TestDependencies.AndroidxTesting}")
        add("testImplementation", "androidx.test:core:${TestDependencies.AndroidxTesting}")
        add("testImplementation", "androidx.test:runner:${TestDependencies.AndroidxTesting}")
        add("testImplementation", "androidx.test.ext:junit-ktx:${TestDependencies.AndroidxJunit}")
        add("testImplementation", "androidx.test.ext:junit:${TestDependencies.AndroidxJunit}")

        add("androidTestImplementation", "androidx.arch.core:core-common:${TestDependencies.AndroidxCoreTesting}")
        add("androidTestImplementation", "androidx.arch.core:core-runtime:${TestDependencies.AndroidxCoreTesting}")
        add("androidTestImplementation", "androidx.arch.core:core-testing:${TestDependencies.AndroidxCoreTesting}")

        add("androidTestImplementation", "androidx.test:core:${TestDependencies.AndroidxTesting}")
        add("androidTestImplementation", "androidx.test.ext:junit-ktx:${TestDependencies.AndroidxJunit}")
        add("androidTestImplementation", "androidx.test.ext:junit:${TestDependencies.AndroidxJunit}")
    }
}

fun Project.addCoroutineTesting() {
    dependencies {
        add("testImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestDependencies.CoroutineTesting}")
        add("testImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:${TestDependencies.CoroutineTesting}")

        add("androidTestImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:${TestDependencies.CoroutineTesting}")
        add("androidTestImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestDependencies.CoroutineTesting}")
    }
}

object TestDependencies {
    const val InstrumentationRunner = "MyUITestRunner"
}