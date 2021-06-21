import org.jetbrains.kotlin.konan.properties.Properties
import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import java.util.Date
import java.text.SimpleDateFormat

plugins {
    id(Versions.Plugins.androidApplication)
    id(Versions.Plugins.hilt)
    id(Versions.Plugins.libraryVersionChecker)
    kotlin(Versions.Plugins.kotlinAndroid)
    kotlin(Versions.Plugins.kotlinKapt)
}

val keystoreProperties = Properties().apply {
    load(File("keystore.properties").reader())
}

val formatter = SimpleDateFormat("yyyyMMdd_HH")

android {
    compileSdkVersion(Versions.Android.compileSdk)

    defaultConfig {
        applicationId = Versions.Android.applicationID
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
        versionCode = Versions.Android.versionCode
        versionName = Versions.Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        setProperty("archivesBaseName", "${rootProject.name}_v${versionName}_${formatter.format(Date())}")
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
            buildConfigField("String", "INIT_API", "\"http://10.0.2.2/\"")
        }
        create("full") {
            dimension = "version"
            applicationIdSuffix = ".full"
            versionNameSuffix = "-full"
            buildConfigField("String", "INIT_API", "\"http://10.0.2.2/\"")
        }
    }
    sourceSets {
        getByName("demo") {
            assets.setSrcDirs(listOf("src/main/assets", "src/main/sampledata", "sampledata"))
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

    applicationVariants.all {
        outputs.forEach { output ->
            val buildVariant = if (buildType.name == "release") {
                "RELEASE"
            } else {
                "SNAPSHOT"
            }
            (output as? BaseVariantOutputImpl)?.outputFileName = "${rootProject.name}_v${versionName}_${formatter.format(Date())}-${buildVariant}.apk"
        }
    }
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
    androidTestImplementation(Dependencies.Test.junitExt)
    androidTestImplementation(Dependencies.Test.espresso)

    kapt(Dependencies.Ktx.lifecycleCompiler)
    implementation(Dependencies.Ktx.viewmodel)
    implementation(Dependencies.Ktx.fragment)

    implementation(Dependencies.Ktx.navigation)
    implementation(Dependencies.Ktx.navigationUi)

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

    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.hiltCompiler)
}