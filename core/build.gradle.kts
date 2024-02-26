plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
apply {
    from("$rootDir/base-module.gradle")
}

android {
    namespace = "com.faridnia.core"
}

dependencies {
    /*"implementation"(Compose.runtime)

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")*/
}