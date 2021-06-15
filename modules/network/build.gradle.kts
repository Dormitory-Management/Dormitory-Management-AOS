plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)
    buildToolsVersion(Versions.Android.buildToolVersion)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
        versionCode = Versions.Android.networkVersionCode
        versionName = Versions.Android.networkVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    flavorDimensions("version")
    productFlavors {
        create("demo") {
            dimension = "version"
            versionNameSuffix = "-demo"
            buildConfigField("String", "INIT_API", "\"http://localhost:8000/\"")
        }
        create("full") {
            dimension = "version"
            versionNameSuffix = "-full"
            buildConfigField("String", "INIT_API", "\"http://localhost:8000/\"")
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
    implementation(Dependencies.Ktx.core)
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.junitExt)

    implementation(Dependencies.Okhttp.okhttp)
    implementation(Dependencies.Okhttp.loggingInterceptor)

    implementation(Dependencies.Retrofit2.retrofit)
    implementation(Dependencies.Retrofit2.converterGson)
    implementation(Dependencies.Retrofit2.adapterRxjava)
    implementation(Dependencies.Google.gson)

    implementation(Dependencies.Rx.java)
}