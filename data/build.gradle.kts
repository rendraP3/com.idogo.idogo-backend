dependencies {
    implementation(project(Modules.usecase))
    implementation(project(Modules.entity))

    DependencyHandlers.Data.implementation.forEach(::implementation)
    DependencyHandlers.koin.forEach(::implementation)
}