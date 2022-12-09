package com.idogo.data.token.manager

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTCreator
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.auth0.jwt.interfaces.JWTVerifier
import com.idogo.data.config.JwtProperties
import com.idogo.usecase.token.dto.Context
import com.idogo.usecase.token.dto.IssueResponse
import com.idogo.usecase.token.repository.TokenProvider
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
        val accessToken =  createAccessToken(context, now + config.expireDuration)
        val refreshToken = createRefreshToken(context, now + config.refreshValidityDuration)
        return@withContext IssueResponse(accessToken, refreshToken)
    }

    override fun verify(token: String?): DecodedJWT = verifier.verify(token)

    override fun verify(jwt: DecodedJWT?): DecodedJWT = verifier.verify(jwt)

    override suspend fun verifyTokenType(token: String): String =
        verifier.verify(token).claims[CLAIM_TOKEN_TYPE]!!.asString()

    private fun createAccessToken(context: Context, expiresAt: Instant) = JWT.create()
        .withSubject(SUBJECT_AUTH)
        .withAudience(config.audience)
        .withIssuer(config.issuer)
        .withClaim(CLAIM_USER_ID, context.id)
        .withClaim(CLAIM_TOKEN_TYPE, ACCESS_TOKEN)
        .withExpiresAt(expiresAt)
        .sign(Algorithm.HMAC256(config.secret))

    private fun createRefreshToken(context: Context, expiresAt: Instant) = JWT.create()
        .withSubject(SUBJECT_AUTH)
        .withAudience(config.audience)
        .withIssuer(config.issuer)
        .withClaim(CLAIM_USER_ID, context.id)
        .withClaim(CLAIM_TOKEN_TYPE, REFRESH_TOKEN)
        .withExpiresAt(expiresAt)
        .sign(Algorithm.HMAC256(config.secret))

    companion object {
        private const val CLAIM_USER_ID = "user-id"
        private const val CLAIM_PHONE_NUMBER = "phone-number"
        private const val CLAIM_TOKEN_TYPE = "token-type"
        private const val SUBJECT_AUTH = "authentication"
        private const val ACCESS_TOKEN = "access-token"
        private const val REFRESH_TOKEN = "refresh-token"
    }

}

fun JWTCreator.Builder.withExpiresAt(expiresAt: Instant): JWTCreator.Builder =
    withExpiresAt(Date.from(expiresAt))