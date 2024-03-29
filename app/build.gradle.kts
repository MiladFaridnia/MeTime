plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")

}

android {
    namespace = "com.faridnia.metime"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.faridnia.metime"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = false
            resValue("string", "app_name", "Me Time")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false
            resValue("string", "app_name", "Me Time (debug)")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }

    /*  packaging {
          resources {
              excludes += "/META-INF/{AL2.0,LGPL2.1}"
          }
      }*/
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.coreUi))

    implementation(project(Modules.bookingDomain))
    implementation(project(Modules.bookingData))
    implementation(project(Modules.bookingPresentation))

    implementation(project(Modules.onboardingData))
    implementation(project(Modules.onboardingDomain))
    implementation(project(Modules.onboardingPresentation))

    implementation(AndroidX.coreKtx)//"androidx.core:core-ktx:1.12.0"
    implementation(AndroidX.lifecycleRuntime)//"androidx.lifecycle:lifecycle-runtime-ktx:2.7.0"

    implementation(AndroidX.navigationRuntime)
//    implementation("androidx.compose.material3:material3-android:1.2.0")

    implementation(platform(Compose.bomeCompose))
    implementation(Compose.uiToolingPreview)
    implementation(Compose.uiToolingManifest)
    implementation(Compose.composeMaterial3)

    // Retrofit
    implementation(Retrofit.retrofit)
    implementation(Retrofit.gsonConverter)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.okHttpLoggingInterceptor)

    // Dagger - Hilt
    kapt(DaggerHilt.hiltCompiler)
    kapt(DaggerHilt.androidXHiltCompiler)
    implementation(DaggerHilt.hiltAndroid)
    implementation(DaggerHilt.androidXNavigationHiltCompiler)

    testImplementation(Testing.junit4)//"junit:junit:4.13.2"
    androidTestImplementation(Testing.espresso)//"androidx.test.espresso:espresso-core:3.5.1"
    androidTestImplementation(Testing.junitAndroidExt)//"androidx.test.ext:junit:1.1.5"
   // androidTestImplementation(Testing.composeUiTest)

    implementation(platform(Google.fireBaseBom))

    // Add the dependency for the Analytics library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation(Google.firebaseAnalytics)

}