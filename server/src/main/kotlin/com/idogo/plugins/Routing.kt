package com.idogo.plugins

import com.idogo.api.Api
import com.idogo.config.koin.ext.koin
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val apis = koin.getAll<Api>().toSet()
    log.info("registered api. {}", apis.map { it.javaClass.simpleName })
    routing {
        apis.forEach { api -> api(this@configureRouting) }
    }
}
