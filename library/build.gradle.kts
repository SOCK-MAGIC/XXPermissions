plugins {
    alias(libs.plugins.android.library)
}
android {
    namespace = "com.hjq.permissions"
    compileSdk = 34

    defaultConfig {
        minSdk = 14
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_17
        sourceCompatibility = JavaVersion.VERSION_17
    }

    lint {
        abortOnError = false
    }

    // 剔除这个包下的所有文件（不会移除签名信息）
    packaging {
        // 剔除这个包下的所有文件（不会移除签名信息）
        resources {
            excludes += "META-INF/*******"
        }

    }
}

dependencies {
    implementation(libs.androidx.annotation)
}
tasks.withType<Javadoc>().configureEach {
    // prevent Javadoc from failing gradle build：https://stackoverflow.com/questions/35435173/prevent-javadoc-from-failing-gradle-build
    isFailOnError = false
    options {
        this as StandardJavadocDocletOptions // unsafe cast
        links("https://docs.gradle.org/4.9/javadoc/")
        addStringOption("Xdoclint:none", "-quiet")
        encoding = "UTF-8"
    }
}
