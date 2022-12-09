package com.idogo.api.v1.auth

import com.idogo.api.Api
import com.idogo.api.common.generateHttpResponse
import com.idogo.api.controller.auth.AuthController
import com.idogo.api.model.request.SignInRequest
import com.idogo.api.model.request.SignUpRequest
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class AuthApi(
    private val authController: AuthController,
): Api({
    route("/login") {
        post {
            val request = call.receive<SignInRequest>()
            val response = generateHttpResponse(authController.signIn(request))
            call.respond(response.code, response.body)
        }
    }
    route("/register") {
        post {
            val request = call.receive<SignUpRequest>()
            val response = generateHttpResponse(authController.signUp(request))
            call.respond(response.code, response.body)
        }
    }
    route("/token") {
        post("/refresh") {

        }
        post("/revoke") {  }
    }
})

