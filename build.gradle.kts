// Top-level build file where you can add configuration options common to all sub-projects/modules.
/*
plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("com.android.library") version "8.1.3" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.20" apply false
}*/

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)//"com.android.tools.build:gradle:7.0.4"
        classpath(Build.kotlinGradlePlugin)//"org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20"
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.kotlinGradlePlugin/*"org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10"*/)//"com.google.dagger:hilt-android-gradle-plugin:2.48.1"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}