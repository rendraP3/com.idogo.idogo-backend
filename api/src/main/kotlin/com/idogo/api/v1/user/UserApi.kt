package com.idogo.api.v1.user

import com.idogo.api.Api
import com.idogo.api.common.PaginationResponse
import com.idogo.api.common.generateHttpResponse
import com.idogo.api.controller.user.UserController
import com.idogo.api.model.request.ChangePhoneNumberRequest
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val DEFAULT_PAGE: Long = 0
private const val DEFAULT_SIZE = 20

class UserApi(private val userController: UserController) : Api({
    route("/user") {
        get {
            val page = call.request.queryParameters["page"]?.toLong() ?: DEFAULT_PAGE
            val size = call.request.queryParameters["size"]?.toInt() ?: DEFAULT_SIZE
            val response = userController.getAllUser(page, size)
            call.respond(response)
        }
        authenticate {
            get("/me") {
                val response = generateHttpResponse(userController.getUser(this.context))
                call.respond(response.code, response.body)
            }
            post("/change-phone-number") {
                val request = call.receive<ChangePhoneNumberRequest>()
                val response = generateHttpResponse(userController.changePhoneNumber(this.context, request))
                call.respond(response.code, response.body)
            }
            post("/change-avatar") { }
            post("/change-name") { }
            post("/change-about") { }
        }
    }
})