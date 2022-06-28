import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import configuration.Versions.ExternalLibraries

fun Project.addRetrofit() {
    dependencies {
        add("implementation", "com.squareup.retrofit2:retrofit:${ExternalLibraries.Retrofit}")

        add("implementation", "com.squareup.retrofit2:adapter-rxjava3:${ExternalLibraries.Retrofit}")
        add("implementation", "com.squareup.okhttp3:logging-interceptor:${ExternalLibraries.Okhttp3}")
        add("implementation", "com.squareup.okhttp3:okhttp:${ExternalLibraries.Okhttp3}")

        add("implementation", "com.squareup.retrofit2:converter-gson:${ExternalLibraries.Retrofit}")
        add("implementation", "com.squareup.retrofit2:converter-scalars:${ExternalLibraries.Retrofit}")
    }
}

fun Project.addGlide() {
    dependencies {
        add("implementation", "com.github.bumptech.glide:glide:${ExternalLibraries.Glide}")
        // Annotations
        add("kapt", "com.github.bumptech.glide:compiler:${ExternalLibraries.Glide}")
    }
}

fun Project.addPDFViewer() {
    dependencies {
        add("implementation", "com.github.barteksc:android-pdf-viewer:${ExternalLibraries.PDFViewer}")
    }
}

fun Project.addJWTDecode() {
    dependencies {
        add("implementation","com.auth0.android:jwtdecode:${ExternalLibraries.JWTDecode}")
    }
}

fun Project.addCircleImageView() {
    dependencies {
        add("implementation", "de.hdodenhof:circleimageview:${ExternalLibraries.CircleImageView}")
    }
}

fun Project.addSVGDecoder() {
    dependencies {
        add("implementation", "com.caverock:androidsvg-aar:${ExternalLibraries.SvgDecoder}")
    }
}

fun Project.addSecurity() {
    dependencies {
        add("implementation", "org.bouncycastle:bcprov-jdk16:${ExternalLibraries.BouncyCastle}")
    }
}