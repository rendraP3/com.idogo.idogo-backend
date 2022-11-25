plugins {
    kotlin("jvm") version Versions.kotlinVersion
}

allprojects {
    group = BuildConfig.groupName
    version = BuildConfig.version
}

subprojects {
    apply {
        plugin(Plugins.kotlinJvm)
    }

    repositories {
        mavenCentral()
    }

    val implementation by configurations
    val testImplementation by configurations

    tasks {
        compileKotlin {
            kotlinOptions {
                jvmTarget = BuildConfig.jvmTarget
            }
        }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation(Dependencies.Kotlin.junit)
        implementation(Dependencies.Kotlin.coroutinesCore)
        testImplementation(Dependencies.Kotlin.coroutinesTest)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(Dependencies.Kotlin.junit)
}