plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.safeargsAndroid)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.galassinitecnology.movieapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.galassinitecnology.movieapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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

    buildFeatures {
        viewBinding = true
    }

    dataBinding {
        enable = true
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    // Test dependencies
    testImplementation(libs.junit)
    testImplementation(libs.truth)
    testImplementation(libs.mockk.mockk)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")


    // Android Test dependencies
    androidTestImplementation(libs.kotlinxCoroutinesTest)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Other dependencies
    implementation(libs.coil)
    implementation(libs.navigationFragment)
    implementation(libs.navigationUi)
    implementation(libs.lifecycleViewmodel)
    implementation(libs.lifecycleLivedata)
    implementation(libs.lifecycleRuntime)
    implementation(libs.kotlinxCoroutines)
    implementation(libs.koinGraph)
    implementation(libs.roomRuntime)
    implementation(libs.roomKtx)
    ksp(libs.roomCompilerKsp)
    implementation(libs.koinAndroid)
    implementation(libs.gson)
    implementation(libs.retrofit)
    implementation(libs.retrofitConverterMoshi)
    implementation(libs.rxjava2Adapter)
    implementation(libs.moshiKotlin)
    ksp(libs.moshiKotlinKsp)
    implementation(libs.pagingRuntimeKtx)
    implementation(libs.pagingCommonKtx)
}
