package com.idogo.api.v1.status

import com.idogo.api.Api
import com.idogo.api.controller.status.StatusController
import io.ktor.server.auth.*
import io.ktor.server.routing.*

class StatusApi(private val statusController: StatusController): Api({
    route("/user"){
        authenticate {
            route("/status") {
                get {  }
                post {  }
                post("/update") {  }
                delete {  }
            }
        }
    }
    route("/status") {
        get {  }
    }
})