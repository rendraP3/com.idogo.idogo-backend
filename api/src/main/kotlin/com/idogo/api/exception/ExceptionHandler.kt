package com.idogo.api.exception

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.idogo.usecase.exception.BadRequestException
import com.idogo.usecase.exception.BaseException
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.exception.UserAlreadyExistException
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import java.time.Instant

fun StatusPagesConfig.exceptionHandler() {
    exception<NotFoundException> { call, cause ->
        call.respond(HttpStatusCode.NotFound, ErrorResponse(cause.message))
    }

    exception<BaseException> { call, cause ->
        call.respond(HttpStatusCode.BadRequest, ErrorResponse(cause.message))
    }

    exception<Exception> { call, cause ->
        val log = call.application.environment.log
        call.respond(HttpStatusCode.InternalServerError, ErrorResponse(cause.message))
        log.error("Exception was thrown.", cause)
    }
}

data class ErrorResponse @JsonCreator constructor(
    @JsonProperty("message")
    val message: String?,
    @JsonProperty("timestamp")
    val timestamp: Instant = Instant.now()
)