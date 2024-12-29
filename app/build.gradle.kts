plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.rycyclerview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.rycyclerview"
        minSdk = 27
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // xử lý json <-> java
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.15.2")
    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
    //load ảnh
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}