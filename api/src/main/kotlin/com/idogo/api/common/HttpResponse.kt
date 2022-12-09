package com.idogo.api.common

import io.ktor.http.*

sealed class HttpResponse<T : Response> {
    abstract val body: T
    abstract val code: HttpStatusCode

    data class Ok<T : Response>(override val body: T) : HttpResponse<T>() {
        override val code: HttpStatusCode = HttpStatusCode.OK
    }

    data class NotFound<T : Response>(override val body: T) : HttpResponse<T>() {
        override val code: HttpStatusCode = HttpStatusCode.NotFound
    }

    data class BadRequest<T : Response>(override val body: T) : HttpResponse<T>() {
        override val code: HttpStatusCode = HttpStatusCode.BadRequest
    }

    data class Unauthorized<T : Response>(override val body: T) : HttpResponse<T>() {
        override val code: HttpStatusCode = HttpStatusCode.Unauthorized
    }

    data class Conflict<T : Response>(override val body: T) : HttpResponse<T>() {
        override val code: HttpStatusCode = HttpStatusCode.Conflict
    }

    companion object {
        fun <T : Response> ok(response: T) = Ok(body = response)

        fun <T : Response> notFound(response: T) = NotFound(body = response)

        fun <T : Response> badRequest(response: T) = BadRequest(body = response)

        fun <T : Response> unauth(response: T) = Unauthorized(body = response)

        fun <T : Response> conflict(response: T) = Conflict(body = response)
    }
}

fun generateHttpResponse(response: Response): HttpResponse<Response> {
    return when (response.status) {
        State.SUCCESS -> HttpResponse.ok(response)
        State.NOT_FOUND -> HttpResponse.notFound(response)
        State.FAILED -> HttpResponse.badRequest(response)
        State.UNAUTHORIZED -> HttpResponse.unauth(response)
        State.CONFLICT -> HttpResponse.conflict(response)
    }
}