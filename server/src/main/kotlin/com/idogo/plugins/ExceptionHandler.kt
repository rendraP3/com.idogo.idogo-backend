package com.idogo.plugins

import com.idogo.api.exception.exceptionHandler
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*

fun Application.configureExceptionHandler() {
    install(StatusPages) {
        exceptionHandler()
    }
}