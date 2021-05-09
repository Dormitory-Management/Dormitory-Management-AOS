object Dependencies {
    /* Kotlin */
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val gradle = "com.android.tools.build:gradle:4.2.0"

    /* appcompat */
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    /* ktx */
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    // life cycle
    // 안드로이드에서 생명주기를 컨트롤 하기 위한 라이브러리
    // https://developer.android.com/jetpack/androidx/releases/lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleVersion}"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    // viewmodel
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodelVersion}"
    // fragment
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    // navigation
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    // navigation safe argument
    const val safeArgument = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
    // use kotlin add build.gradle.kts.kts apply plugin: "androidx.navigation.safeargs.kotlin"

    /* constraintlayout */
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"

    // easy permission
    const val easyPermission = "pub.devrel:easypermissions:${Versions.easyPermissionVersion}"

    // swipe-to-refresh
    // 스와이프 하여 새로고침
    // https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
    const val swipe = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeVersion}"

    // google
    const val material = "com.google.android.material:material:${Versions.materialVersion}"

    // tikxml
    // xml 데이터를 파싱하기 위한 라이브러리
    // https://github.com/Tickaroo/tikxml
    const val tikxmlAnnotation = "com.tickaroo.tikxml:annotation:${Versions.tikxmlVersion}"
    const val tikxmlCore = "com.tickaroo.tikxml:core:${Versions.tikxmlVersion}"
    const val tikxmlRetrofitConverter = "com.tickaroo.tikxml:retrofit-converter:${Versions.tikxmlVersion}"
    const val tikxmlProcessor = "com.tickaroo.tikxml:processor:${Versions.tikxmlVersion}"
    const val tikxmlAutoValue = "com.tickaroo.tikxml:auto-value-tikxml:${Versions.tikxmlVersion}"

    // gson
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // jsoup
    // og graph tag를 파싱하기위해 사용
    // https://github.com/jhy/jsoup
    const val jsoup = "org.jsoup:jsoup:${Versions.jsoupVersion}"

    // glide
    // 이미지 로드와 다양한 옵션을 설정하기 위해 사용한 라이브러리
    // https://github.com/bumptech/glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    // okhttp3
    // retrofit과 같이 사용하여 로그와 인터넷 통신에 여러 옵션을 설정하기 위한 라이브러리
    // https://github.com/square/okhttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingVersion}"

    // retrofit2
    // 인터넷 통신을 위해 사용한 라이브러리
    // https://github.com/square/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGsonVersion}"
    const val retrofitAdapterRxjava = "com.squareup.retrofit2:adapter-rxjava3:${Versions.adapterRxjavaVersion}"

    // threetenbp
    // java에 내장되어 있는 시간 관련 클래스들 보다 뛰어난 시간 관련 라이브러리
    // https://github.com/JakeWharton/ThreeTenABP
    const val threetenbp = "com.jakewharton.threetenabp:threetenabp:${Versions.threetenbpVersion}"

    // rxjava
    // 안드로이드에서 Rx 프로그래밍을 할 수 있도록 해주는 라이브러리
    // rx android : https://github.com/ReactiveX/RxAndroid
    // rx java : https://github.com/ReactiveX/RxJava
    // rx kotlin : https://github.com/ReactiveX/RxKotlin
    // rx binding : https://github.com/JakeWharton/RxBinding
    const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxjavaVersion}"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxandroidVersion}"
    const val rxKotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxkotlinVersion}"
    const val rxBinding = "com.jakewharton.rxbinding4:rxbinding:${Versions.rxbindingBersion}"
}

object TestDependencies {
    const val junit = "junit:junit:${Versions.junit}"
}
