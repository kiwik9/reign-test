import kotlin.String

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Update this file with
 *   `$ ./gradlew buildSrcVersions`
 */
object Libs {
    /**
     * https://developer.android.com/jetpack/androidx
     */
    const val appcompat: String = "androidx.appcompat:appcompat:" + Versions.appcompat

    /**
     * http://tools.android.com
     */
    const val constraintlayout: String = "androidx.constraintlayout:constraintlayout:" +
            Versions.constraintlayout

    /**
     * http://developer.android.com/tools/extras/support-library.html
     */
    const val core_ktx: String = "androidx.core:core-ktx:" + Versions.core_ktx

    /**
     * https://developer.android.com/testing
     */
    const val espresso_core: String =
        "androidx.test.espresso:espresso-core:" + Versions.espresso_core

    /**
     * https://developer.android.com/testing
     */
    const val androidx_test_runner: String = "androidx.test:runner:" + Versions.androidx_test_runner

    /**
     * https://developer.android.com/studio
     */
    const val aapt2: String = "com.android.tools.build:aapt2:" + Versions.aapt2

    /**
     * https://developer.android.com/studio
     */
    const val com_android_tools_build_gradle: String = "com.android.tools.build:gradle:" +
            Versions.com_android_tools_build_gradle

    /**
     * https://developer.android.com/studio
     */
    const val lint_gradle: String = "com.android.tools.lint:lint-gradle:" + Versions.lint_gradle

    const val de_fayard_buildsrcversions_gradle_plugin: String =
        "de.fayard.buildSrcVersions:de.fayard.buildSrcVersions.gradle.plugin:" +
                Versions.de_fayard_buildsrcversions_gradle_plugin

    /**
     * http://junit.org
     */
    const val junit: String = "junit:junit:" + Versions.junit

    /**
     * https://kotlinlang.org/
     */
    const val kotlin_android_extensions_runtime: String =
        "org.jetbrains.kotlin:kotlin-android-extensions-runtime:" + Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/
     */
    const val kotlin_android_extensions: String =
        "org.jetbrains.kotlin:kotlin-android-extensions:" +
                Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/
     */
    const val kotlin_annotation_processing_gradle: String =
        "org.jetbrains.kotlin:kotlin-annotation-processing-gradle:" + Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/
     */
    const val kotlin_gradle_plugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/
     */
    const val kotlin_stdlib_jdk7: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:" +
            Versions.org_jetbrains_kotlin

    const val kotlin_stdlib_jdk8: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:" +
            Versions.org_jetbrains_kotlin

    const val glide: String = "com.github.bumptech.glide:glide:" + Versions.glide

    const val circleimageview: String = "de.hdodenhof:circleimageview:" + Versions.circleimageview
    const val bottom_navigation: String =
        "com.aurelhubert:ahbottomnavigation:" + Versions.ahbottomnavigation
    const val material_dialog = "com.afollestad.material-dialogs:core:" + Versions.materialDialog
    const val material_dialog_lifecycle =
        "com.afollestad.material-dialogs:lifecycle:" + Versions.materialDialog
    const val material_dialog_input =
        "com.afollestad.material-dialogs:input:" + Versions.materialDialog
    const val multidex = "androidx.multidex:multidex:" + Versions.multidex
    const val flexbox = "com.google.android:flexbox:" + Versions.flexbox

    // room
    const val room = "androidx.room:room-runtime:" + Versions.room
    // optional - Kotlin Extensions and Coroutines support for Room
    const val room_ktx = "androidx.room:room-ktx:" + Versions.room
    const val room_rxjava = "androidx.room:room-rxjava2:" + Versions.room


    const val material = "com.google.android.material:material:" + Versions.google_material
    const val legacy_support = "androidx.legacy:legacy-support-v4:" + Versions.legacy_support



    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:" + Versions.lifecycle
    // annotationProcessor "androidx.lifecycle:lifecycle-compiler:${arch.lifecycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:" + Versions.livedata
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.lifecycle

    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.lifecycle

    const val fragment_ktx = "androidx.fragment:fragment-ktx:" + Versions.fragment_ktx

    const val work_runtime_ktx = "androidx.work:work-runtime-ktx:" + Versions.work_version
    // Check for v11.4.2 or higher
    const val firebase_core = "com.google.firebase:firebase-core:" + Versions.firebase_core

    // Add dependency
    const val crashlytics = "com.google.firebase:firebase-crashlytics:" + Versions.crashlytics

    // STETHO
    const val stetho = "com.facebook.stetho:stetho-okhttp3:" + Versions.stetho

    const val android_networking =
        "com.amitshekhar.android:android-networking:" + Versions.android_networking

    // RETROFIT
    const val retrofit = "com.squareup.retrofit2:retrofit:" + Versions.retrofit
    const val retrofit_converter_moshi = "com.squareup.retrofit2:converter-moshi:" + Versions.retrofit
    const val retrofit_rxjava = "com.squareup.retrofit2:adapter-rxjava:" + Versions.retrofit
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:" + Versions.logging_interceptor

    // moshi
    const val moshi = "com.squareup.moshi:moshi-kotlin:" + Versions.moshi

    // date library
    const val klock = "com.soywiz.korlibs.klock:klock-jvm:" + Versions.klockVersion
    // joda time
    const val joda_time = "net.danlew:android.joda:" + Versions.joda_time

    const val kapt_room: String = "androidx.room:room-compiler:" + Versions.room
    const val kapt_glide: String =  "com.github.bumptech.glide:compiler:" + Versions.glide
    const val kapt_moshi_codegen: String = "com.squareup.moshi:moshi-kotlin-codegen:" + Versions.moshi
    const val kapt_lifecycle: String = "androidx.lifecycle:lifecycle-compiler:" + Versions.lifecycle

    const val lottie: String = "com.airbnb.android:lottie:" + Versions.lottie_version

    const val youtube_player = "com.pierfrancescosoffritti.androidyoutubeplayer:core:" + Versions.youtube_player

    const val paging =  "androidx.paging:paging-runtime-ktx:" + Versions.paging

    const val carousel_view = "com.synnapps:carouselview:" + Versions.carousel_view

    const val preference = "androidx.preference:preference:" + Versions.preference

    const val material_progressbar = "me.zhanghai.android.materialprogressbar:library:" + Versions.material_progressbar

    const val arc_layout = "com.github.florent37:arclayout:" + Versions.arc_layout

    const val loading_button_android = "br.com.simplepass:loading-button-android:" + Versions.loading_button_android

    const val vector_drawable = "androidx.vectordrawable:vectordrawable:" + Versions.appcompat

    const val cardview= "androidx.cardview:cardview:" + Versions.cardview

    const val stepper = "com.github.TayfunCesur:Stepper:" + Versions.stepper

    const val firebase_messaging = "com.google.firebase:firebase-messaging:" + Versions.firebase_messaging

    const val firebase_config = "com.google.firebase:firebase-config:" + Versions.firebase_core

    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:" + Versions.nav_version
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:" + Versions.nav_version

    const val gms_play_service_location = "com.google.android.gms:play-services-location:" + Versions.gms_play_service
    const val gms_play_service_base = "com.google.android.gms:play-services-base:" + Versions.gms_play_service
    const val gms_play_service_map = "com.google.android.gms:play-services-maps:" + Versions.gms_play_service
    const val gms_play_service_gcm = "com.google.android.gms:play-services-gcm:" + Versions.gms_play_service


    const val timeline_view = "com.github.vipulasri:timelineview:" + Versions.timeline_view

    const val android_chart = "com.github.PhilJay:MPAndroidChart:v" + Versions.android_chart

    const val truetime= "com.github.instacart.truetime-android:library:" + Versions.truetime

    const val apache_commons = "org.apache.commons:commons-text:" + Versions.apache_commons

    const val zxing_android_embedded = "com.journeyapps:zxing-android-embedded:" + Versions.zxing_android_embedded
    const val zxing_core = "com.google.zxing:core:" + Versions.zxing_core

    const val androix_annotation = "androidx.annotation:annotation:" + Versions.appcompat

    const val signature_pad = "com.github.gcacace:signature-pad:" + Versions.signature_pad

    const val tempo = "com.github.AllanHasegawa.Tempo:tempo:" + Versions.tempo

    const val gson = "com.google.code.gson:gson:" + Versions.gson

    const val mockk = "io.mockk:mockk:" + Versions.mockk

    const val viewpager2 = "androidx.viewpager2:viewpager2:" + Versions.viewpager2

    const val swipe_refresh_layout = "androidx.swiperefreshlayout:swiperefreshlayout:" + Versions.swipe_refresh_layout

    const val koin_android = "org.koin:koin-androidx-scope:" + Versions.koin_android
    
    const val koin_android_viewmodel = "org.koin:koin-androidx-viewmodel:" + Versions.koin_android

    const val kotlin_logging = "io.github.microutils:kotlin-logging:" + Versions.kotlin_logging
    const val slf4j = "org.slf4j:slf4j-android:" + Versions.slf4j
}
