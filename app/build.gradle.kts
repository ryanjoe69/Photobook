import com.sun.tools.javac.resources.compiler

//import com.sun.tools.javac.resources.compiler
//import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
//    alias(libs.plugins.kotlin.kapt)
//    id("com.google.devtools.ksp")

    }

android {
    namespace = "com.example.myapplication2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication2"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments["room.schemaLocation"] =
//                    "$projectDir/schemas"
//            }
//        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


    }

    buildTypes {

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }

}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.androidx.ui.desktop)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    //implementation ("androidx.core:core-ktx:1.10.1")
    //implementation (libs.plugins.kotlin.kapt)


    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)

    // To use Kotlin annotation processing tool (kapt)
    annotationProcessor(libs.androidx.room.compiler)
    // To use Kotlin Symbol Processing (KSP)
    annotationProcessor(libs.androidx.room.compiler)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    // optional - RxJava2 support for Room
    implementation(libs.androidx.room.rxjava2)

    // optional - RxJava3 support for Room
    implementation(libs.androidx.room.rxjava3)

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation(libs.androidx.room.guava)

    // optional - Test helpers
    testImplementation(libs.androidx.room.testing)

    // optional - Paging 3 Integration
    implementation(libs.androidx.room.paging)
//    implementation (androidx.room:room-runtime:2.5.0)
//    kapt (androidx.room:room-compiler:2.5.0)
//    implementation (androidx.room:room-ktx:2.5.0)


//    ksp(libs.androidx.room.compiler.v230)
   // ksp(androidx.room:room-compiler:$roomVersion)

    //implementation(libs.artifact)

}


//kapt {
//        arguments {
//            arg("key", "value")
//        }
//    }



