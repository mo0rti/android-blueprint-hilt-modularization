package configuration

object Versions {

    object Build {
        const val Gradle = "7.1.3"

        const val CompileSdk = 31
        const val MinSdk = 29
        const val TargetSdk = 31
        const val BuildTools = "32.0.0"

        const val Kotlin = "1.6.10"
    }

    object AndroidDependencies {

        const val GoogleServices = "4.3.10"
        const val Firebase = "28.3.1"
        const val FirebaseAnalytics = "9.0.3"
        const val AndroidCore = "1.8.0"
        const val AndroidCompat = "1.4.2"
        const val AndroidLegacy = "1.0.0"
        const val GSON = "2.8.9"

        const val Biometric = "1.2.0-alpha04"

        const val RxJava = "3.1.2"
        const val RxAndroid = "3.0.0"

        const val NavigationComponent = "2.5.0"
        const val LifeCycle = "2.4.0"
        const val Coroutine = "1.4.1"
        const val CoroutineWorker = "2.7.1"
        const val Room = "2.3.0-alpha04"

        const val Fragment = "1.5.0"
        const val CardView = "1.0.0"
        const val ConstraintLayout = "2.1.4"
        const val FlexBoxLayout = "3.0.0"
        const val SwipeRefreshLayout = "1.1.0"
        const val MaterialDesign = "1.6.1"
        const val ViewPager = "1.0.0"

        const val Hilt = "2.42"
        const val SecurityCrypto = "1.1.0-alpha01"
        const val UICountryPicker = "2.5.4"
    }

    object TestDependencies {
        const val JUnit = "4.13.2"
        const val Espresso = "3.4.0"
        const val Robolectric = "4.6.1"
        const val UIAutomator = "2.1.3"
        const val Mockk = "1.12.1"
        const val Mockito = "3.12.4"
        const val AndroidxCoreTesting = "2.1.0"
        const val AndroidxTesting = "1.4.0"
        const val AndroidxJunit = "1.1.3"
        const val CoroutineTesting = "1.6.0"
    }

    object ExternalLibraries {
        const val BouncyCastle = "1.45"
        const val SvgDecoder = "1.4"
        const val CircleImageView = "3.1.0"
        const val Okhttp3 = "4.9.3"
        const val Retrofit = "2.9.0"
        const val Glide = "4.12.0"
        const val Balloon = "1.4.0"
        const val PDFViewer = "3.2.0-beta.1"

        const val Onfido = "11.2.0"
        const val JWTDecode = "2.0.1"
    }
}
