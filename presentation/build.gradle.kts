plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")

    // Add the Google services Gradle plugin
//    id("com.google.gms.google-services")
//    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.project_100.auto_factory"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.project_100.auto_factory"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"

        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {

        create("release") {
            keyAlias = "key_store"
            keyPassword = "ycgw5736"
            storeFile = file("../../../APP KEY/key_store")
            storePassword = "ycgw5736"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }

        debug {

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dataBinding {
        enable = true
    }

    packaging {
        resources {
            excludes.add("META-INF/DEPENDENCIES")
        }
    }

    buildFeatures {
        buildConfig = true
    }

}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.1")
    implementation("android.arch.lifecycle:extensions:1.1.1")
    implementation("androidx.activity:activity:1.7.2")
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.fragment:fragment:1.6.0")
    implementation("androidx.fragment:fragment-ktx:1.6.0")
    //recyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
    // hilt
    implementation("com.google.dagger:hilt-android:2.57.1")
    kapt("com.google.dagger:hilt-android-compiler:2.57.1")
    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:4.10.0")

    implementation("com.github.skydoves:sandwich:1.3.5")

    //room
    implementation("androidx.room:room-runtime:2.8.0")
    kapt("androidx.room:room-compiler:2.8.0")
    implementation("androidx.room:room-ktx:2.8.0")
    //glide
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")
    //firebase
//    implementation(platform("com.google.firebase:firebase-bom:31.5.0"))
//    implementation("com.google.firebase:firebase-analytics")
//    implementation("com.google.firebase:firebase-crashlytics")
//    implementation("com.google.firebase:firebase-firestore-ktx")

    //CameraX
    implementation("androidx.camera:camera-core:1.3.0-alpha06")
    implementation("androidx.camera:camera-camera2:1.3.0-alpha06")
    implementation("androidx.camera:camera-lifecycle:1.3.0-alpha06")
    implementation("androidx.camera:camera-extensions:1.3.0-alpha06")
    implementation("androidx.camera:camera-view:1.3.0-alpha06")
    implementation("androidx.camera:camera-video:1.3.0-alpha06")
    implementation("androidx.concurrent:concurrent-futures-ktx:1.1.0")
    implementation("androidx.camera:camera-extensions:1.3.0-alpha06")


    //material
    implementation("com.google.android.material:material:1.9.0")



    // Import the Firebase BoM
//    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))
//    implementation("com.google.firebase:firebase-analytics")
//    implementation("com.google.firebase:firebase-crashlytics")

    //google adMob
//    implementation("com.google.android.gms:play-services-ads:23.5.0")

//    implementation("com.ldoublem.loadingview:loadingviewlib:1.0")
    implementation("androidx.multidex:multidex:2.0.1")

//    implementation("com.victor:lib:1.0.4")

    // 크롤링
    implementation("org.jsoup:jsoup:1.16.1") // 최신 버전 확인

    //work manager
    implementation("androidx.work:work-runtime-ktx:2.10.4")
    implementation("androidx.work:work-rxjava2:2.10.4")

    // google sheet
//    implementation ("com.google.api-client:google-api-client:2.0.0")
//    implementation ("com.google.oauth-client:google-oauth-client-jetty:1.34.1")
//    implementation ("com.google.apis:google-api-services-sheets:v4-rev20220927-2.0.0")

    //kakao
//    implementation("com.kakao.sdk:v2-all:2.20.6") // 전체 모듈 설치, 2.11.0 버전부터 지원
//    implementation("com.kakao.sdk:v2-user:2.20.6") // 카카오 로그인 API 모듈
//    implementation("com.kakao.sdk:v2-share:2.20.6") // 카카오톡 공유 API 모듈
//    implementation("com.kakao.sdk:v2-talk:2.20.6") // 카카오톡 채널, 카카오톡 소셜, 카카오톡 메시지 API 모듈
//    implementation("com.kakao.sdk:v2-friend:2.20.6") // 피커 API 모듈
//    implementation("com.kakao.sdk:v2-navi:2.20.6") // 카카오내비 API 모듈
//    implementation("com.kakao.sdk:v2-cert:2.20.6") // 카카오톡 인증 서비스 API 모듈

    implementation("com.github.skydoves:progressview:1.1.3")

    implementation("androidx.datastore:datastore-preferences:1.1.2")

}


kapt {
    correctErrorTypes = true
}