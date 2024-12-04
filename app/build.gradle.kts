
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.newspaper"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newspaper"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Architecture Components
    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    // Room
    /*implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    // Room KTX for Coroutine support
    //implementation(libs.androidx.room.ktx)
    implementation ("androidx.room:room-ktx:2.6.1")
    ksp(libs.androidx.room.compiler)
    //kapt ("androidx.room:room-compiler:2.2.1")*/

    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    // To use Kotlin annotation processing tool (kapt)
    ksp("androidx.room:room-compiler:2.6.1")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$2.6.1")

    // Coroutine
    implementation(libs.kotlinx.coroutines.android)

    // Coroutine Life cycle scope
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v240)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation(libs.logging.interceptor)

    // Navigation
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    // Glide
    implementation (libs.glide)

    // KSP
    ksp(libs.androidx.room.compiler)

    // Safe Args
    //classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.3")
}