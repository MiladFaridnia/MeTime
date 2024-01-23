plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
 //   id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
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
        kotlinCompilerExtensionVersion = "1.4.5"

    }

  /*  packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }*/
}

dependencies {

    implementation(AndroidX.coreKtx)//"androidx.core:core-ktx:1.12.0"
    implementation(AndroidX.lifecycleRuntime)//"androidx.lifecycle:lifecycle-runtime-ktx:2.7.0"
    implementation(Compose.activityCompose)//"androidx.activity:activity-compose:1.8.2"
    implementation(platform(Compose.bomeCompose))//"androidx.compose:compose-bom:2023.03.00"
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.6")
    testImplementation(Testing.junit4)//"junit:junit:4.13.2"
    androidTestImplementation(Testing.junitAndroidExt)//"androidx.test.ext:junit:1.1.5"
    androidTestImplementation(Testing.espresso)//"androidx.test.espresso:espresso-core:3.5.1"
    androidTestImplementation(platform(Compose.bomeCompose))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Dagger - Hilt
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)
    kapt(DaggerHilt.androidXHiltCompiler)
    implementation(DaggerHilt.androidXNavigationHiltCompiler)

}