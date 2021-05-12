plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(Versions.Apps.compileSdk)
    buildToolsVersion(Versions.Apps.buildToolVersion)

    defaultConfig {
        minSdkVersion(Versions.Apps.minSdk)
        targetSdkVersion(Versions.Apps.targetSdk)
        versionCode = Versions.Apps.networkVersionCode
        versionName = Versions.Apps.networkVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
//    implementation "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin_version}"
    implementation("androidx.core:core-ktx:1.3.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    implementation(Dependencies.Okhttp.okhttp)
    implementation(Dependencies.Okhttp.loggingInterceptor)

    implementation(Dependencies.Retrofit2.retrofit)

    implementation(Dependencies.Rx.java)
}