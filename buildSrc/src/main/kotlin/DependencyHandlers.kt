object DependencyHandlers {
    val koin = listOf(
        Dependencies.Koin.core,
        Dependencies.Koin.slf4j
    )
    object Server {
        val implementation = listOf(
            Dependencies.Ktor.core,
            Dependencies.Ktor.microMetrics,
            Dependencies.Ktor.metrics,
            Dependencies.Ktor.netty,
            Dependencies.Ktor.auth,
            Dependencies.Ktor.authJWT,
            Dependencies.Ktor.contentNegotiation,
            Dependencies.Ktor.statusPages,
            Dependencies.Ktor.jackson,
            Dependencies.Ktor.cors,
            Dependencies.Ktor.websocket,
            Dependencies.Libraries.prometheusMicrometer,
            Dependencies.Libraries.logback
        )
        val testImplementation = listOf(
            Dependencies.Ktor.test
        )
    }

    object Api {
        val implementation = listOf(
            Dependencies.Ktor.auth,
            Dependencies.Ktor.authJWT,
            Dependencies.Ktor.core,
            Dependencies.Ktor.statusPages,
            Dependencies.Libraries.jacksonDatabind,
        )
    }

    object Data {
        val implementation = listOf(
            Dependencies.Ktor.auth,
            Dependencies.Ktor.authJWT,
            Dependencies.Exposed.core,
            Dependencies.Exposed.jdbc,
            Dependencies.Exposed.dao,
            Dependencies.Exposed.javaTime,
            Dependencies.Libraries.hikariCp,
            Dependencies.Libraries.mariadb,
            Dependencies.Libraries.retrofit,
        )
    }
}