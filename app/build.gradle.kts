plugins {
    alias(libs.plugins.android.application)
}
android {
    namespace = "com.hjq.permissions.demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hjq.permissions.demo"
        minSdk = 16
        targetSdk = 34
        versionCode = 1805
        versionName = "18.5"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_17
        sourceCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(projects.library)

    implementation(libs.androidx.appcompat)

    // 吐司框架：https://github.com/getActivity/Toaster
    implementation(libs.toaster)
    implementation(libs.androidx.exifinterface)

    // 内存泄漏检测：https://github.com/square/leakcanary
    debugImplementation(libs.leakcanary.android)
}