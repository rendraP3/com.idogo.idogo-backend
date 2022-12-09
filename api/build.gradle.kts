dependencies {
    implementation(project(Modules.usecase))
    implementation(project(Modules.data))

    DependencyHandlers.Api.implementation.forEach(::implementation)
    DependencyHandlers.koin.forEach(::implementation)
}