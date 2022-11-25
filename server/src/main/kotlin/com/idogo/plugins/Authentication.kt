package com.idogo.plugins

import com.auth0.jwt.interfaces.JWTVerifier
import com.idogo.config.ktor.ext.get
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureAuthentication() {
    install(Authentication) {
        jwt {
            val verifier = get<JWTVerifier>()
            verifier(verifier)
            validate { credential -> JWTPrincipal(credential.payload) }
        }
    }
}