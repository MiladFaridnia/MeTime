plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.faridnia.metime.core_ui"
}

apply {
    from("$rootDir/compose-module.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
/*
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(Compose.foundation)

    testImplementation(Testing.junit4)
    androidTestImplementation(Testing.junitAndroidExt)
    androidTestImplementation(Testing.espresso)

    implementation(Compose.activityCompose)//"androidx.activity:activity-compose:1.8.2"
    implementation(platform(Compose.bomeCompose))//"androidx.compose:compose-bom:2023.03.00"
//    implementation("androidx.compose.ui:ui")

    implementation(Compose.ui)
    implementation(Compose.uiGraphics)*/
  /*  implementation(Compose.uiToolingPreviewAndroid)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.composeMaterial3)*/


}