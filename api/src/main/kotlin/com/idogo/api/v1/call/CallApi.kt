package com.idogo.api.v1.call

import com.idogo.api.Api
import com.idogo.api.controller.call.CallController
import io.ktor.server.auth.*
import io.ktor.server.routing.*

class CallApi(private val callController: CallController): Api({
    route("/call") {
        authenticate {

        }
    }
})