plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("maven-publish")
}

android {
    compileSdkVersion(Config.SdkVersions.compileSdkVersion)
    defaultConfig {
        minSdkVersion(Config.SdkVersions.minSdkVersion)
        targetSdkVersion(Config.SdkVersions.targetSdkVersion)
        versionCode = Config.Dein.versionCode
        versionName = Config.Dein.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin_stdlib_jdk8)
    implementation(Libs.appcompat)
    implementation(Libs.core_ktx)
    implementation(Libs.constraintlayout)
    implementation(Libs.gson)

    implementation(Libs.moshi)

    implementation(Libs.work_runtime_ktx)
    implementation(Libs.koin_android_viewmodel)

    implementation(Libs.androix_annotation)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.espresso_core)
}
