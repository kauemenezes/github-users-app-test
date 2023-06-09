object Dependencies {

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val MATERIAL_DESIGN = "com.google.android.material:material:${Versions.materialDesign}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val OKHTTP3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val OKHTTP_URL_CONNECTION = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okhttpUrlConnection}"
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val LIFECYCLE_COMMOM_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val KOIN = "io.insert-koin:koin-android:${Versions.koin}"
    const val KOIN_NAVIGATION = "io.insert-koin:koin-androidx-navigation:${Versions.koin}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val JUNIT = "junit:junit:${Versions.junit}"
    const val ANDROIDX_JUNIT_KTX = "androidx.test.ext:junit-ktx:${Versions.androidxJunit}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val ESPRESSO_INTENTS = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    const val ROBOLECTRIC = "org.robolectric:robolectric:${Versions.robolectric}"
    const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val ANDROIDX_TEST_CORE = "androidx.test:core:${Versions.testCore}"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Versions.runner}"
    const val ARCH_COMPONENT = "androidx.arch.core:core-testing:${Versions.archComponentTest}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val MOCKK = "io.mockk:mockk:${Versions.mockk}"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    const val TURBINE = "app.cash.turbine:turbine:${Versions.turbine}"
}

object Modules {
    const val DATA = ":datalayer"
    const val DOMAIN = ":domain"
}