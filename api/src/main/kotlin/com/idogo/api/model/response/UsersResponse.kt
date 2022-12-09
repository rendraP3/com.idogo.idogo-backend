package com.idogo.api.model.response

import com.idogo.api.common.Response
import com.idogo.api.common.State
import com.idogo.usecase.user.dto.User

data class UsersResponse(
    override val status: State,
    override val message: String,
    val users: List<User>? = null
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

        fun success(message: String, user: List<User>?) = UsersResponse(
            State.SUCCESS,
            message,
            user
        )
    }
}