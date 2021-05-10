import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

// Create a variable called keystorePropertiesFile, and initialize it to your
// keystore.properties file, in the rootProject folder.
val keystorePropertiesFile = rootProject.file("keystore.properties")

// Initialize a new Properties() object called keystoreProperties.
val keystoreProperties = Properties().apply {
    load(File("keystore.properties").reader())
}

// Load your keystore.properties file into the keystoreProperties object.
//keystoreProperties.load(java.io.FileInputStream(keystorePropertiesFile))

android {
    compileSdkVersion(Apps.compileSdk)

    defaultConfig {
        applicationId = "com.bowoon.android.dormitory_management_aos"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        setProperty("archivesBaseName", "${rootProject.name}_v${versionName}_${Date().format('yyyyMMdd_HH')}")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    signingConfigs {
        create("releaseWithSignedKey") {
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
            storeFile = file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
        }
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//            signingConfig = signingConfigs.getByName("releaseWithSignedKey")
        }
    }
    flavorDimensions("version")
    productFlavors {
        create("demo") {
            dimension = "version"
            applicationIdSuffix = ".demo"
            versionNameSuffix = "-demo"
        }
        create("full") {
            dimension = "version"
            applicationIdSuffix = ".full"
            versionNameSuffix = "-full"
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
        dataBinding = true
    }

//    applicationVariants.all { variant ->
//        variant.outputs.each { output ->
//            def buildVariant = ""
//            if (variant.buildType.name == "release") {
//                buildVariant += "RELEASE"
//            } else {
//                buildVariant += "SNAPSHOT"
//            }
//            output.outputFileName = "${rootProject.name}_v${variant.versionName}_${new Date().format('yyyyMMdd_HH')}-${buildVariant}.apk"
//        }
//    }
}

dependencies {
    implementation(Dependencies.kotlin)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintlayout)
    implementation(project(path, ":network"))
    implementation(project(path, ":common"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

//    implementation deps.ktx.lifecycle
//    kapt deps.ktx.lifecycle_compiler
//    implementation deps.ktx.lifecycle_extension
//    implementation deps.ktx.viewmodel
//    implementation deps.ktx.fragment
//
//    implementation deps.glide.glide
//    kapt deps.glide.compiler
//
//    implementation deps.okhttp.okhttp
//    implementation deps.okhttp.logging_interceptor
//
//    implementation deps.retrofit.retrofit
//    implementation deps.retrofit.retrofit_converter_gson
//    implementation deps.retrofit.retrofit_adapter_rxjava
//
//    implementation deps.gson
//    implementation deps.rx.java
//    implementation deps.rx.android
//    implementation deps.rx.kotlin
//    implementation deps.rx.binding
}