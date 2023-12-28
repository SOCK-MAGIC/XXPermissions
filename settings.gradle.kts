pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/")
        maven("https://jitpack.io")
        google()
    }
}
rootProject.name = "XXPermissions"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":library")