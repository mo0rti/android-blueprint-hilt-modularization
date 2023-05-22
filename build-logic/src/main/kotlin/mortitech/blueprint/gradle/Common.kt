package mortitech.blueprint.gradle

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension


fun configureKotlinCompiler(project: Project) {
    project.kotlinExtension.sourceSets.all {
        languageSettings {
            optIn("kotlin.RequiresOptIn")
        }
    }
}

fun Project.catalogVersion(name: String): String = extensions.findByType(VersionCatalogsExtension::class.java)!!
    .named("libs")
    .findVersion(name)
    .get()
    .displayName

fun Project.catalogDependency(name: String): String = extensions.findByType(VersionCatalogsExtension::class.java)!!
    .named("libs")
    .findLibrary(name)
    .get()
    .get()
    .run {
        "$module:${versionConstraint.displayName}"
    }

fun Project.commonSetup() {
    val bytecodeVersion = JavaVersion.VERSION_11.toString()

    extensions.findByType(JavaPluginExtension::class.java)!!.apply {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(11))
        }

        sourceCompatibility = JavaVersion.toVersion(bytecodeVersion)
        targetCompatibility = JavaVersion.toVersion(bytecodeVersion)
    }

    tasks.withType(KotlinCompile::class.java).configureEach {
        kotlinOptions {
            if (this is KotlinJvmOptions) {
                jvmTarget = bytecodeVersion
            }
        }
    }

    extensions.findByName("android").apply {
        this as BaseExtension
        compileOptions {
            sourceCompatibility = JavaVersion.toVersion(bytecodeVersion)
            targetCompatibility = JavaVersion.toVersion(bytecodeVersion)
        }
    }
}