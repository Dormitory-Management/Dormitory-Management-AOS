object Dependencies {
    /* Kotlin */
    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Library.kotlinVersion}"
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Library.kotlinVersion}"
        const val gradle = "com.android.tools.build:gradle:${Versions.Library.gradleVersion}"
    }

    object Check {
        const val libraryUpdate = "name.remal:gradle-plugins:${Versions.Library.libraryUpdateVersion}"
    }

    /* appcompat */
    object Appcompat {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.Library.appcompatVersion}"
    }

    /* ktx */
    object Ktx {
        const val core = "androidx.core:core-ktx:${Versions.Library.coreKtxVersion}"
        // life cycle
        // 안드로이드에서 생명주기를 컨트롤 하기 위한 라이브러리
        // https://developer.android.com/jetpack/androidx/releases/lifecycle
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.Library.lifecycleVersion}"

        // viewmodel
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Library.viewModelVersion}"

        // fragment
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.Library.fragmentVersion}"

        // navigation
        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.Library.navigationVersion}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.Library.navigationVersion}"

        // navigation safe argument
        const val safeArgument = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Library.navigationVersion}"
        // use kotlin add build.gradle.kts.kts apply plugin: "androidx.navigation.safeargs.kotlin"
    }

    object Layout {
        /* constraintlayout */
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.Library.constraintLayoutVersion}"

        // swipe-to-refresh
        // 스와이프 하여 새로고침
        // https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
        const val swipe = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.Library.swipeVersion}"
    }

    // easy permission
    object Permission {
        const val easyPermission = "pub.devrel:easypermissions:${Versions.Library.easyPermissionVersion}"
    }

    // google
    object Google {
        const val material = "com.google.android.material:material:${Versions.Library.materialVersion}"
        // gson
        const val gson = "com.google.code.gson:gson:${Versions.Library.gsonVersion}"
    }

    // tikxml
    // xml 데이터를 파싱하기 위한 라이브러리
    // https://github.com/Tickaroo/tikxml
    object Tikxml {
        const val annotation = "com.tickaroo.tikxml:annotation:${Versions.Library.tikxmlVersion}"
        const val core = "com.tickaroo.tikxml:core:${Versions.Library.tikxmlVersion}"
        const val retrofitConverter = "com.tickaroo.tikxml:retrofit-converter:${Versions.Library.tikxmlVersion}"
        const val processor = "com.tickaroo.tikxml:processor:${Versions.Library.tikxmlVersion}"
        const val autoValue = "com.tickaroo.tikxml:auto-value-tikxml:${Versions.Library.tikxmlVersion}"
    }

    // jsoup
    // og graph tag를 파싱하기위해 사용
    // https://github.com/jhy/jsoup
    object Jsoup {
        const val jsoup = "org.jsoup:jsoup:${Versions.Library.jsoupVersion}"
    }

    // glide
    // 이미지 로드와 다양한 옵션을 설정하기 위해 사용한 라이브러리
    // https://github.com/bumptech/glide
    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Library.glideVersion}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.Library.glideVersion}"
    }

    // okhttp3
    // retrofit과 같이 사용하여 로그와 인터넷 통신에 여러 옵션을 설정하기 위한 라이브러리
    // https://github.com/square/okhttp
    object Okhttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Library.okhttpVersion}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Library.okhttpLoggingVersion}"
    }

    // retrofit2
    // 인터넷 통신을 위해 사용한 라이브러리
    // https://github.com/square/retrofit
    object Retrofit2 {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Library.retrofitVersion}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.Library.converterGsonVersion}"
        const val adapterRxjava = "com.squareup.retrofit2:adapter-rxjava3:${Versions.Library.adapterRxjavaVersion}"
    }

    // threetenbp
    // java에 내장되어 있는 시간 관련 클래스들 보다 뛰어난 시간 관련 라이브러리
    // https://github.com/JakeWharton/ThreeTenABP
    object Threetenbp {
        const val threetenbp = "com.jakewharton.threetenabp:threetenabp:${Versions.Library.threetenbpVersion}"
    }

    // rxjava
    // 안드로이드에서 Rx 프로그래밍을 할 수 있도록 해주는 라이브러리
    // rx android : https://github.com/ReactiveX/RxAndroid
    // rx java : https://github.com/ReactiveX/RxJava
    // rx kotlin : https://github.com/ReactiveX/RxKotlin
    // rx binding : https://github.com/JakeWharton/RxBinding
    object Rx {
        const val java = "io.reactivex.rxjava3:rxjava:${Versions.Library.rxjavaVersion}"
        const val android = "io.reactivex.rxjava3:rxandroid:${Versions.Library.rxAndroidVersion}"
        const val kotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.Library.rxkotlinVersion}"
        const val binding = "com.jakewharton.rxbinding4:rxbinding:${Versions.Library.rxBindingVersion}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Library.junitVersion}"
        const val junitExt = "androidx.test.ext:junit:${Versions.Library.junitExtVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Library.espressoCoreVersion}"
    }

    object Hilt {
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Library.hiltVersion}"
        const val hilt = "com.google.dagger:hilt-android:${Versions.Library.hiltVersion}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Library.hiltVersion}"
    }
}