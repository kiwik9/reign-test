// Top-level build file where you can all dd configuration options common to all sub-projects/modules.

buildscript {
    val kotlin_version by extra("1.3.72")
    val navVersion = "2.1.0"

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.2")
        classpath(kotlin("gradle-plugin", kotlin_version))
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