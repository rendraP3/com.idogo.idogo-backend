package com.idogo.api.model.response

import com.idogo.api.common.Response
import com.idogo.api.common.State

data class AuthResponse(
    override val status: State,
    override val message: String,
    val accessToken: String? = null,
    val refreshToken: String? = null
): Response {
    companion object {

        fun failed(message: String) = AuthResponse(
            State.FAILED,
            message
        )

        fun unauthorized(message: String) = AuthResponse(
            State.UNAUTHORIZED,
            message
        )

        fun success(message: String) = AuthResponse(
            State.SUCCESS,
            message
        )

        fun success(message: String, accessToken: String?, refreshToken: String?) = AuthResponse(
            State.SUCCESS,
            message,
            accessToken,
            refreshToken
        )
    }
}