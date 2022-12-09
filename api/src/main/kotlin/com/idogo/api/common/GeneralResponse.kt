package com.idogo.api.common

data class GeneralResponse(
    override val status: State,
    override val message: String
) : Response {
    companion object {

        fun unauthorized(message: String) = GeneralResponse(
            State.UNAUTHORIZED,
            message
        )

        fun failed(message: String) = GeneralResponse(
            State.FAILED,
            message
        )

        fun conflict(message: String) = GeneralResponse(
            State.CONFLICT,
            message
        )

        fun notFound(message: String) = GeneralResponse(
            State.NOT_FOUND,
            message
        )

        fun success(message: String) = GeneralResponse(
            State.SUCCESS,
            message
        )
    }
}