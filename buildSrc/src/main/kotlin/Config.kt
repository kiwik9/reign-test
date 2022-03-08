object Config {
    data class ProjectProperty(val apiUrl: String)

    object SdkVersions {
        const val appId = "io.kiwik.reign"
        const val versionCode = 1
        const val compileSdkVersion = 29
        const val targetSdkVersion = 29
        const val minSdkVersion = 21
        const val versionName = "1.1.0"
    }

    object Dein {
        const val versionName = "1.0"
        const val versionCode = 1
    }

    object Project {
        val config =
            mapOf(
                "dev" to ProjectProperty(
                    "\"\""
                ),
                "prod" to ProjectProperty(
                    "\"\""
                ),
                "cal" to ProjectProperty(
                    "\"\""
                )
            )
    }
}