object Retrofit {
/*
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
*/


    private const val version = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"

    private const val okHttpVersion = "5.0.0-alpha.2"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
}