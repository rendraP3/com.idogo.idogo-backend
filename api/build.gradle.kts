dependencies {
    implementation(project(Modules.usecase))

    DependencyHandlers.Api.implementation.forEach(::implementation)
    DependencyHandlers.koin.forEach(::implementation)
}