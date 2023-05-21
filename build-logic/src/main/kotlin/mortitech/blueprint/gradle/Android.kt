package mortitech.blueprint.gradle

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

internal val Project.androidExtension: BaseExtension
    get() {
        return extensions.findByName("android") as BaseExtension?
            ?: error("no 'android' extension found")
    }

private fun configureAndroidCompileSdk(project: Project) {
    project.androidExtension.compileSdkVersion(33)
}

fun Project.androidSetup() {
    configureKotlinCompiler(project)
    configureAndroidCompileSdk(project)
    enableCoreLibraryDesugaring()
}

fun Project.enableCoreLibraryDesugaring() {

    androidExtension.defaultConfig {
        multiDexEnabled = true
    }
    androidExtension.compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
}