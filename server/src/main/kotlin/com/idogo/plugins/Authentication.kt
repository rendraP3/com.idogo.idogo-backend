package com.idogo.plugins

import com.auth0.jwt.exceptions.JWTDecodeException
import com.auth0.jwt.exceptions.SignatureVerificationException
import com.auth0.jwt.exceptions.TokenExpiredException
import com.auth0.jwt.interfaces.JWTVerifier
import com.idogo.api.common.GeneralResponse
import com.idogo.api.common.generateHttpResponse
import com.idogo.config.koin.ext.get
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*

fun Application.configureAuthentication() {

    install(Authentication) {
        jwt {
            val verifier = get<JWTVerifier>()
            verifier(verifier)
            validate { credential -> JWTPrincipal(credential.payload) }
        }
    }
}