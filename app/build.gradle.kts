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
    compileSdkVersion(Versions.Apps.compileSdk)

    defaultConfig {
        applicationId = "com.bowoon.android.dormitory_management_aos"
        minSdkVersion(Versions.Apps.minSdk)
        targetSdkVersion(Versions.Apps.targetSdk)
        versionCode = Versions.Apps.versionCode
        versionName = Versions.Apps.versionName

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
            signingConfig = signingConfigs.getByName("releaseWithSignedKey")
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
    implementation(Dependencies.Kotlin.kotlin)
    implementation(Dependencies.Ktx.core)
    implementation(Dependencies.Appcompat.appcompat)
    implementation(Dependencies.Google.material)
    implementation(Dependencies.Layout.constraintlayout)
    implementation(project(mapOf("path" to ":common")))
    implementation(project(mapOf("path" to ":network")))
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    implementation(Dependencies.Ktx.lifecycle)
    kapt(Dependencies.Ktx.lifecycleCompiler)
    implementation(Dependencies.Ktx.lifecycleExtension)
    implementation(Dependencies.Ktx.viewmodel)
    implementation(Dependencies.Ktx.fragment)

    implementation(Dependencies.Glide.glide)
    kapt(Dependencies.Glide.compiler)

    implementation(Dependencies.Okhttp.okhttp)
    implementation(Dependencies.Okhttp.loggingInterceptor)

    implementation(Dependencies.Retrofit2.retrofit)
    implementation(Dependencies.Retrofit2.converterGson)
    implementation(Dependencies.Retrofit2.adapterRxjava)
    implementation(Dependencies.Google.gson)

    implementation(Dependencies.Rx.java)
    implementation(Dependencies.Rx.android)
    implementation(Dependencies.Rx.kotlin)
    implementation(Dependencies.Rx.binding)
}