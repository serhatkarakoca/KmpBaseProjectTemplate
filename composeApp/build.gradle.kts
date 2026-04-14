import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)

    /** If you want to add Firebase, uncomment it

    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")

     **/

    alias(libs.plugins.ksp)
    alias(libs.plugins.gradleBuildConfig)
    //  alias(libs.plugins.room)
}

kotlin {
    tasks.register("testClasses")
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            //linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.compose.preview)
            api(libs.androidx.startup)
            implementation(libs.room.runtime.android)
            implementation(libs.android.accompanist.permissions)
            implementation(project.dependencies.platform(libs.firebase.android.bom))
            implementation(libs.firebase.android.crashlytics.ktx)
            implementation(libs.firebase.android.messaging)
            implementation(libs.firebase.android.inappmessaging)
            implementation(libs.firebase.android.firestore)
            implementation(libs.androidx.workmanager)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.preview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(libs.bundles.ktor)
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.lifecycle.viewmodel)
            implementation(libs.navigation.compose)
            implementation(libs.kamel)
            implementation(libs.androidx.data.store.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kmp.shimmer)
            implementation(libs.room.runtime)
            implementation(libs.sqlite.bundled)
            implementation(libs.kermit)
            implementation(libs.haze)
            implementation(libs.haze.materials)
            implementation(libs.lottie)
            implementation(libs.gitlive.analytics)
            implementation(libs.gitlive.auth)
            implementation(libs.gitlive.storage)
            implementation(libs.material.icons)
            api(libs.compose.webview.multiplatform)
        }
    }
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        // Common compiler options applied to all Kotlin source sets
        freeCompilerArgs.add("-Xexpect-actual-classes")
        optIn.add("kotlin.time.ExperimentalTime")
    }
}

android {
    namespace = "com.karakoca.baseproject"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.karakoca.baseproject"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    signingConfigs {
        create("release") {
            val properties = Properties()
            properties.load(FileInputStream(project.rootProject.file("gradle.properties")))
            storeFile = file(properties.getProperty("STORE_FILE"))
            storePassword = properties.getProperty("STORE_PASSWORD")
            keyPassword = properties.getProperty("KEY_PASSWORD")
            keyAlias = properties.getProperty("KEY_ALIAS")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")

        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    dependencies {
        debugImplementation(libs.compose.preview)
        debugImplementation(libs.library)
        releaseImplementation(libs.library.no.op)
    }
}

buildConfig {
    val properties = Properties()
    properties.load(project.rootProject.file("local.properties").reader())
    val apiKey = properties.getProperty("api_key")

    buildConfigField("API_KEY", apiKey)
}

dependencies {
    //   add("kspCommonMainMetadata", libs.room.compiler)

    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)


}

ksp {
    arg("room.schemaLocation", "${projectDir}/schemas")
}
/*
tasks.withType<KotlinCompilationTask<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}
*/
