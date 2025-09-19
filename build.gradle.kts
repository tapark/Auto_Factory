// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        // Make sure that you have the following two repositories
        google()  // Google's Maven repository
        mavenCentral()  // Maven Central repository
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {

    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false


    id("com.google.dagger.hilt.android") version "2.57.1" apply false
//    id("com.google.gms.google-services") version "4.4.2" apply false
//    id("com.google.firebase.crashlytics") version "3.0.2" apply false
}