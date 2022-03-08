import com.android.build.gradle.internal.dsl.ProductFlavor

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
}
android {
    compileSdkVersion(Config.SdkVersions.compileSdkVersion)
    defaultConfig {
        applicationId = Config.SdkVersions.appId
        minSdkVersion(Config.SdkVersions.minSdkVersion)
        targetSdkVersion(Config.SdkVersions.targetSdkVersion)
        versionCode = Config.SdkVersions.versionCode
        versionName = Config.SdkVersions.versionName
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = mapOf("includeCompileClasspath" to "true")
            }
        }
        vectorDrawables.useSupportLibrary = true
    }
    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
            ext.set("enableCrashlytics", false)
            ext.set("alwaysUpdateBuildId", false)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    flavorDimensions("default")

    productFlavors {
        configureFlavors("dev", "prod", "cal")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    kapt(Libs.kapt_moshi_codegen)
    kapt(Libs.kapt_room)
    kapt("com.android.databinding:compiler:3.5.3")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin_stdlib_jdk8)
    implementation(Libs.appcompat)
    implementation(Libs.core_ktx)
    implementation(Libs.constraintlayout)
    implementation(Libs.material)
    implementation(Libs.cardview)
    implementation(Libs.kotlin_logging)
    implementation(Libs.moshi)
    implementation(Libs.koin_android_viewmodel)

    /**
     * Joda time
     */
    implementation(Libs.joda_time)

    /**
     * Multidex
     */
    implementation(Libs.multidex)
    implementation(Libs.navigation_ui)
    implementation(Libs.navigation_fragment)

    androidTestImplementation(Libs.espresso_core)

    implementation(Libs.swipe_refresh_layout)

    /**
     * Retrofit
     */
    implementation(Libs.retrofit)
    implementation(Libs.retrofit_converter_moshi)
    implementation(Libs.logging_interceptor)

    /**
     * Room
     */
    implementation(Libs.room)
    implementation(Libs.room_ktx)
    kapt(Libs.kapt_room)

    /**
     * Lifecycle
     */
    implementation(Libs.lifecycle_extensions)
    implementation(Libs.lifecycle)
    implementation(Libs.livedata)
    implementation(Libs.lifecycle_viewmodel)

    /**
     * Tempo, libreria para el NTP
     */
    implementation(Libs.gson)

    /**
     * Work manager
     */
    implementation(Libs.work_runtime_ktx)

    testImplementation(Libs.junit)

    implementation(project(":dein"))

    /**
     * Mockk
     */
    testImplementation(Libs.mockk)

    implementation(Libs.recycler_view_swipe)
    implementation(Libs.gson_converter)
    implementation(Libs.material_progress_bar)
    implementation(Libs.junit_ktx)
    implementation(Libs.espresso_contrib)

}

fun getProjectConfig(type: String): Config.ProjectProperty {
    return Config.Project.config[type] ?: Config.ProjectProperty("")
}

fun NamedDomainObjectContainer<ProductFlavor>.configureFlavors(vararg flavorNames: String) {
    flavorNames.forEach { name ->
        val projectConfig = getProjectConfig(name)
        create(name) {
            setDimension("default")
            buildConfigField("String", "BASE_URL", projectConfig.apiUrl)
        }
    }

}
