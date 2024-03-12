object Build {
    private const val androidBuildToolsVersion = "8.0.2"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    
    private const val GOOGLE_SERVICES_VERSION = "4.4.1"
    const val GOOGLE_SERVICES_PLUGIN = "com.google.gms:google-services:${GOOGLE_SERVICES_VERSION}"

    private const val hiltAndroidGradlePluginVersion = "2.48.1"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"
}