
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.faridnia.metime.oboarding_presentation"
}

apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {

    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.onboardingDomain))

    "implementation"(AndroidX.coreKtx)
    "implementation"(AndroidX.appCompat)
    "testImplementation"(Testing.junit4)

    "androidTestImplementation"(Testing.junitAndroidExt)
    "androidTestImplementation"(Testing.espresso)

    }