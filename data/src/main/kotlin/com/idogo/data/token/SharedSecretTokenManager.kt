package com.idogo.data.token

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTCreator
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.auth0.jwt.interfaces.JWTVerifier
import com.idogo.data.config.JwtProperties
import com.idogo.usecase.token.Context
import com.idogo.usecase.token.IssueResponse
import com.idogo.usecase.token.TokenProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.time.Instant
import java.util.*

class SharedSecretTokenManager(
    private val config: JwtProperties,
    private val dispatcher: CoroutineDispatcher
): TokenProvider, JWTVerifier {

    private val verifier = JWT
        .require(Algorithm.HMAC256(config.secret))
        .withAudience(config.audience)
        .withIssuer(config.issuer)
        .build()

    override suspend fun issue(context: Context) = withContext(dispatcher) {
        val now = Instant.now()
        JWT.create()
            .withAudience(config.audience)
            .withIssuer(config.issuer)
            .withClaim(CLAIM_PHONE_NUMBER, context.phoneNumber)
            .withExpiresAt(now + config.expireDuration)
            .sign(Algorithm.HMAC256(config.secret))
            .let { IssueResponse(it) }
    }

    override fun verify(token: String?): DecodedJWT {
        return verifier.verify(token)
    }

    override fun verify(jwt: DecodedJWT?): DecodedJWT {
        return verifier.verify(jwt)
    }

    companion object {
        private const val CLAIM_PHONE_NUMBER = "phone-number"
    }

}

fun JWTCreator.Builder.withExpiresAt(expiresAt: Instant): JWTCreator.Builder =
    withExpiresAt(Date.from(expiresAt))