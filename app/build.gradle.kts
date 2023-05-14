plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "br.com.githubusers"
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        applicationId = "br.com.githubusers"
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"https://api.github.com\"")
        }
        debug {
            applicationIdSuffix = ".dev"
            buildConfigField("String", "BASE_URL", "\"https://api.github.com\"")
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(Modules.DATA))

    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.ACTIVITY_KTX)

    // -- Material
    implementation(Dependencies.MATERIAL_DESIGN)

    // -- Lifecycle Components (ViewModel, LiveData and ReactiveStreams)
    implementation(Dependencies.LIFECYCLE_RUNTIME)
    implementation(Dependencies.VIEWMODEL_KTX)
    implementation(Dependencies.LIVEDATA_KTX)
    implementation(Dependencies.LIFECYCLE_COMMOM_JAVA8)

    // -- Retrofit2
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER_GSON)
    implementation(Dependencies.LOGGING_INTERCEPTOR)
    implementation(Dependencies.OKHTTP_URL_CONNECTION)

    // Navigation
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)

    // -- Coroutines
    implementation(Dependencies.COROUTINES_CORE)
    implementation(Dependencies.COROUTINES_ANDROID)

    // -- Koin
    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_NAVIGATION)

    //Glide
    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)

    // Test
    testImplementation(Dependencies.JUNIT)

    androidTestImplementation(Dependencies.ANDROIDX_JUNIT_KTX)
    androidTestImplementation(Dependencies.ESPRESSO)
    androidTestImplementation(Dependencies.ESPRESSO_INTENTS)
}