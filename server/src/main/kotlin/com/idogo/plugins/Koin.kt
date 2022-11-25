package com.idogo.plugins

import com.idogo.config.serverModules
import com.idogo.data.dataModules
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.ktor.plugin.KoinApplicationStarted
import org.koin.ktor.plugin.KoinApplicationStopPreparing
import org.koin.ktor.plugin.KoinApplicationStopped
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
//    apiModules,
    dataModules,
    serverModules
).flatten()