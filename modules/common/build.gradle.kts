plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)
    buildToolsVersion(Versions.Android.buildToolVersion)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
        versionCode = Versions.Android.commonVersionCode
        versionName = Versions.Android.commonVersionName

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
    buildFeatures {
        dataBinding = true
    }
}

//기존library.jar파일 삭제.
task("deleteObjectJar", Delete::class) {
    delete = setOf("release/libraryName.jar")
}

//release폴더에library이름으로jar생성.
task("exportJar", Copy::class) {
    //aar_main_jar/release 에서 classes.jar 파일을 가져온다.
    from("build/intermediates/aar_main_jar/release/")
    into("release/")
    include("classes.jar")
    rename("classes.jar", "libraryName.jar")
    rename("classes.jar", "android_common_library.jar")
}

//exportJar실행시 deleteObjectJar가 실행
//exportJar.dependsOn(deleteObjectJar, build)
tasks {
    "build" {
        dependsOn("deleteObjectJar")
    }
}

dependencies {
    implementation(Dependencies.Google.material)
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.junitExt)

    implementation(Dependencies.Google.gson)

    implementation(Dependencies.Glide.glide)
    kapt(Dependencies.Glide.compiler)

    implementation(Dependencies.Rx.java)
    implementation(Dependencies.Rx.android)
    implementation(Dependencies.Rx.kotlin)
    implementation(Dependencies.Rx.binding)
}