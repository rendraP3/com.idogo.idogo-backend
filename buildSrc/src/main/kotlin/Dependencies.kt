object Dependencies {
    object Ktor {
        const val core = "io.ktor:ktor-server-core-jvm:${Versions.ktorVersion}"
        const val websocket = "io.ktor:ktor-server-websockets-jvm:${Versions.ktorVersion}"
        const val contentNegotiation = "io.ktor:ktor-server-content-negotiation-jvm:${Versions.ktorVersion}"
        const val jackson = "io.ktor:ktor-serialization-jackson-jvm:${Versions.ktorVersion}"
        const val metrics = "io.ktor:ktor-server-metrics-jvm:${Versions.ktorVersion}"
        const val microMetrics = "io.ktor:ktor-server-metrics-micrometer-jvm:${Versions.ktorVersion}"
        const val hostCommon = "io.ktor:ktor-server-host-common-jvm:${Versions.ktorVersion}"
        const val statusPages = "io.ktor:ktor-server-status-pages-jvm:${Versions.ktorVersion}"
        const val auth = "io.ktor:ktor-server-auth-jvm:${Versions.ktorVersion}"
        const val authJWT = "io.ktor:ktor-server-auth-jwt-jvm:${Versions.ktorVersion}"
        const val netty = "io.ktor:ktor-server-netty-jvm:${Versions.ktorVersion}"
        const val test = "io.ktor:ktor-server-tests-jvm:${Versions.ktorVersion}"
        const val cors = "io.ktor:ktor-server-cors:${Versions.ktorVersion}"
    }

    object Kotlin {
        const val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinVersion}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    }

    object Exposed {
        const val core = "org.jetbrains.exposed:exposed-core:${Versions.exposedVersion}"
        const val jdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposedVersion}"
        const val dao = "org.jetbrains.exposed:exposed-dao:${Versions.exposedVersion}"
        const val javaTime = "org.jetbrains.exposed:exposed-java-time:${Versions.exposedVersion}"
    }

    object Koin {
        const val core = "io.insert-koin:koin-ktor:${Versions.koinVersion}"
        const val slf4j = "io.insert-koin:koin-logger-slf4j:${Versions.koinVersion}"
    }

    object Libraries {
        const val prometheusMicrometer = "io.micrometer:micrometer-registry-prometheus:${Versions.prometheusVersion}"
        const val logback = "ch.qos.logback:logback-classic:${Versions.logbackVersion}"
        const val jacksonDatabind = "com.fasterxml.jackson.core:jackson-databind:${Versions.jacksonVersion}"
        const val hikariCp = "com.zaxxer:HikariCP:${Versions.hikariVersion}"
        const val mariadb = "org.mariadb.jdbc:mariadb-java-client:${Versions.mariadbVersion}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val jacksonJsr310 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.jacksonVersion}"
        const val flyway = "org.flywaydb:flyway-core:${Versions.flywayVersion}"
    }
}