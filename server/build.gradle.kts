plugins {
    application
    kotlin("jvm")
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(project(Modules.api))
    implementation(project(Modules.data))

    DependencyHandlers.Server.implementation.forEach(::implementation)
    DependencyHandlers.Server.testImplementation.forEach(::testImplementation)

    DependencyHandlers.koin.forEach(::implementation)
}