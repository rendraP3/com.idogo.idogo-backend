package com.idogo

import io.ktor.server.application.*
import com.idogo.plugins.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    installKoinModule()
    configureAuthentication()
    configureExceptionHandler()
    configureHTTP()
    configureMonitoring()
    configureSockets()
    configureRouting()
    configureSerialization()
}
