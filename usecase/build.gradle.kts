plugins {
    id(Plugins.allOpen) version Versions.allOpenVersion
}

allOpen {
    annotation("com.idogo.usecase.UseCase")
}

dependencies {
    implementation(project(Modules.entity))
}