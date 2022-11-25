package com.idogo.plugins

import com.idogo.data.config.DataSourceProperties
import com.idogo.data.config.JwtProperties
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.ext.getKoin

fun Application.registerPropertyConfig() {
    val dataSourceConfig = dataSourceConfig()
    val jwtConfig = jwtConfig()

    getKoin().loadModules(listOf(module(createdAtStart = true) {
        single { dataSourceConfig }
        single { jwtConfig }
    }))
}

fun Application.dataSourceConfig(): DataSourceProperties {
    val config = environment.config
    return DataSourceProperties(
        config.property("exposed.data-source.url").getString(),
        config.property("exposed.data-source.driver").getString(),
        config.property("exposed.data-source.username").getString(),
        config.property("exposed.data-source.password").getString(),
        config.property("exposed.data-source.connection-pool-size").getString().toInt()
    )
}

fun Application.jwtConfig(): JwtProperties {
    val config = environment.config
    return JwtProperties(
        config.property("jwt.secret").getString(),
        config.property("jwt.issuer").getString(),
        config.property("jwt.audience").getString(),
        config.property("jwt.expire-milliseconds").getString().toLong(),
    )
}