package dependencies

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import configuration.Versions.AndroidDependencies

fun Project.addFirebase() {
    dependencies {
        add("implementation", platform("com.google.firebase:firebase-bom:${AndroidDependencies.Firebase}"))
        add("implementation", "com.google.firebase:firebase-analytics-ktx:${AndroidDependencies.FirebaseAnalytics}")
        add("implementation", "com.google.firebase:firebase-crashlytics-ktx")
    }
}

fun Project.addAndroidCore() {
    dependencies {
        add("implementation", "androidx.core:core-ktx:${AndroidDependencies.AndroidCore}")
        add("implementation", "androidx.appcompat:appcompat:${AndroidDependencies.AndroidCompat}")
        add("implementation", "androidx.legacy:legacy-support-v4:${AndroidDependencies.AndroidLegacy}")
    }
}

fun Project.addGson() {
    dependencies {
        add("implementation", "com.google.code.gson:gson:${AndroidDependencies.GSON}")
    }
}

fun Project.addRxJava() {
    dependencies {
        add("implementation", "io.reactivex.rxjava3:rxjava:${AndroidDependencies.RxJava}")
        add("implementation", "io.reactivex.rxjava3:rxandroid:${AndroidDependencies.RxAndroid}")
    }
}

fun Project.addFragment() {
    dependencies {
        add("implementation", "androidx.fragment:fragment-ktx:${AndroidDependencies.Fragment}")
    }
}

fun Project.addCardView() {
    dependencies {
        add("implementation", "androidx.cardview:cardview:${AndroidDependencies.CardView}")
    }
}

fun Project.addMaterialDesign() {
    dependencies {
        add("implementation", "com.google.android.material:material:${AndroidDependencies.MaterialDesign}")
    }
}

fun Project.addNavigationCore() {
    dependencies {
        add("implementation", "androidx.navigation:navigation-runtime-ktx:${AndroidDependencies.NavigationComponent}")
        add("implementation", "androidx.navigation:navigation-fragment-ktx:${AndroidDependencies.NavigationComponent}")
    }
}

fun Project.addNavigationUI() {
    dependencies {
        add("implementation", "androidx.navigation:navigation-ui-ktx:${AndroidDependencies.NavigationComponent}")
    }
}

fun Project.addNavigationComponent() {
    dependencies {
        // Feature module Support
        add("implementation", "androidx.navigation:navigation-dynamic-features-fragment:${AndroidDependencies.NavigationComponent}")
        // Testing Navigation
        add("androidTestImplementation", "androidx.navigation:navigation-testing:${AndroidDependencies.NavigationComponent}")
    }
}

fun Project.addLayouts() {
    dependencies {
        add("implementation", "androidx.constraintlayout:constraintlayout:${AndroidDependencies.ConstraintLayout}")
        add("implementation", "com.google.android.flexbox:flexbox:${AndroidDependencies.FlexBoxLayout}")
        add("implementation", "androidx.swiperefreshlayout:swiperefreshlayout:${AndroidDependencies.SwipeRefreshLayout}")
    }
}

fun Project.addViewPager() {
    dependencies {
        add("implementation", "androidx.viewpager2:viewpager2:${AndroidDependencies.ViewPager}")
    }
}

fun Project.addCoroutines() {
    dependencies {
        add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-android:${AndroidDependencies.Coroutine}")
        add("implementation", "androidx.work:work-runtime-ktx:${AndroidDependencies.CoroutineWorker}")
    }
}

fun Project.addLiveCycle() {
    dependencies {
        add("implementation", "androidx.lifecycle:lifecycle-livedata-ktx:${AndroidDependencies.LifeCycle}")
        add("implementation", "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidDependencies.LifeCycle}")
        add("implementation", "androidx.lifecycle:lifecycle-runtime-ktx:${AndroidDependencies.LifeCycle}")
        add("implementation", "androidx.lifecycle:lifecycle-viewmodel-savedstate:${AndroidDependencies.LifeCycle}")
    }
}

fun Project.addHilt() {
    dependencies {
        add("implementation", "com.google.dagger:hilt-android:${AndroidDependencies.Hilt}")
        add("kapt", "com.google.dagger:hilt-compiler:${AndroidDependencies.Hilt}")

        // For instrumentation tests
        add("androidTestImplementation", "com.google.dagger:hilt-android-testing:${AndroidDependencies.Hilt}")
        add("kaptAndroidTest", "com.google.dagger:hilt-compiler:${AndroidDependencies.Hilt}")

        // For local unit tests
        add("testImplementation", "com.google.dagger:hilt-android-testing:${AndroidDependencies.Hilt}")
        add("kaptTest", "com.google.dagger:hilt-compiler:${AndroidDependencies.Hilt}")
    }
}

fun Project.addRoom() {
    dependencies {
        add("implementation", "androidx.room:room-runtime:${AndroidDependencies.Room}")
        add("implementation", "androidx.room:room-ktx:${AndroidDependencies.Room}")
        // Annotations
        add("kapt", "androidx.room:room-compiler:${AndroidDependencies.Room}")
        // Test
        add("testImplementation", "androidx.room:room-testing:${AndroidDependencies.Room}")
    }
}

fun Project.addAndroidSecurity() {
    dependencies {
        //For now keep SecurityCrypto on alpha 01 due to an issue with Tink which is bundled,
        //In May 2022 via Twitter it was said that an update is underway after a silence of almost a year
        add("implementation", "androidx.security:security-crypto:${AndroidDependencies.SecurityCrypto}")
        add("implementation", "androidx.biometric:biometric:${AndroidDependencies.Biometric}")
        add("implementation", "androidx.biometric:biometric-ktx:${AndroidDependencies.Biometric}")
    }
}

fun Project.addExternalUI() {
    dependencies {
        add("implementation", "com.hbb20:ccp:${AndroidDependencies.UICountryPicker}")
    }
}

fun Project.addConfetti() {
    dependencies {
        add("implementation", "nl.dionsegijn:konfetti-xml:2.0.2")
    }
}
