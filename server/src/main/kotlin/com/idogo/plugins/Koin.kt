package com.idogo.plugins

import com.idogo.api.apiModules
import com.idogo.api.controller.controllerModule
import com.idogo.config.koin.ext.Koin
import com.idogo.config.koin.ext.KoinApplicationStarted
import com.idogo.config.koin.ext.KoinApplicationStopPreparing
import com.idogo.config.koin.ext.KoinApplicationStopped
import com.idogo.config.serverModules
import com.idogo.data.dataModules
import io.ktor.server.application.*
import org.koin.logger.SLF4JLogger

fun Application.installKoinModule() {
    environment.monitor.subscribe(KoinApplicationStarted) {
        log.info("Koin container started.")
    }
    install(Koin) {
        SLF4JLogger()
        registerPropertyConfig()
        modules(modules)
    }
    environment.monitor.subscribe(KoinApplicationStopPreparing) {
        log.info("Koin stopping...")
    }
    environment.monitor.subscribe(KoinApplicationStopped) {
        log.info("Koin stopped.")
    }
}

val modules = listOf(
    apiModules,
    dataModules,
    serverModules
).flatten()