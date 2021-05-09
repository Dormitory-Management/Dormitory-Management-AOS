plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildToolVersion)

    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.commonVersionCode
        versionName = Apps.commonVersionName

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

////기존library.jar파일 삭제.
//task deleteObjectJar(type:Delete){
//    delete'release/libraryName.jar'
//}
//
////release폴더에library이름으로jar생성.
//task exportJar(type:Copy){
//    //aar_main_jar/release 에서 classes.jar 파일을 가져온다.
//    from('build/intermediates/aar_main_jar/release/')
//    into('release/')
//    include('classes.jar')
//    rename('classes.jar','libraryName.jar')
//    rename('classes.jar','android_common_library.jar')
//}
//
////exportJar실행시 deleteObjectJar가 실행
//exportJar.dependsOn(deleteObjectJar,build)

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.0")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

//    implementation deps.gson
//
//    implementation deps.glide.glide
//    kapt deps.glide.compiler
//
//    implementation deps.rx.java
//    implementation deps.rx.android
//    implementation deps.rx.kotlin
//    implementation deps.rx.binding
}