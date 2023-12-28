import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin) apply false
}
allprojects {
    // 读取 local.properties 文件配置
    val properties = gradleLocalProperties(rootDir)
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use {
            properties.load(it)
        }

    }

    val buildDirPath = properties.getProperty("build.dir")
    buildDir = if (!buildDirPath.isNullOrBlank()) {
        // 将构建文件统一输出到指定的目录下
        File(buildDirPath, rootProject.name + "/build/${path.replace(":", "/")}")
    } else {
        // 将构建文件统一输出到项目根目录下的 build 文件夹
        File(rootDir, "build/${path.replace(":", "/")}")
    }
}

tasks.register<Delete>("clean") {
    delete = setOf(rootProject.layout.buildDirectory)
}