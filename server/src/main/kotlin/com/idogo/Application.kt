package com.idogo

import io.ktor.server.application.*
import com.idogo.plugins.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    installKoinModule()
    configureAuthentication()
    configureExceptionHandler()
    configureHTTP()
    configureMonitoring()
    configureRouting()
    configureSockets()
    configureSerialization()
}
