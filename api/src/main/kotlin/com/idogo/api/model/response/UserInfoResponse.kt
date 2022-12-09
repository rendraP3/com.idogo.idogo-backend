package com.idogo.api.model.response

import com.idogo.api.common.Response
import com.idogo.api.common.State
import com.idogo.usecase.user.dto.User

data class UserInfoResponse(
    override val status: State,
    override val message: String,
    val user: User? = null
) : Response {

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

        fun success(message: String, user: User?) = UserInfoResponse(
            State.SUCCESS,
            message,
            user
        )
    }
}