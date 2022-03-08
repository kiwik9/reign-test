// Top-level build file where you can all dd configuration options common to all sub-projects/modules.

buildscript {
    val kotlin_version by extra("1.3.72")
    // val kotlinVersion = "1.3.50"
    val navVersion = "2.1.0"

    repositories {
        google()
        jcenter()
        maven { url = uri("https://maven.google.com/") }
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.fabric.io/public") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath(kotlin("gradle-plugin", kotlin_version))
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.2.0")
        classpath("com.google.gms:google-services:4.3.5")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}

plugins {
    id("de.fayard.buildSrcVersions") version "0.4.2"
}


allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

buildSrcVersions {
    indent = "  "
    renameLibs = "Libs"
    renameVersions = "Versions"
    rejectedVersionKeywords("alpha", "beta", "rc", "cr", "m", "preview", "eap")
    useFdqnFor() // nothing
}