package com.idogo.data.config

import java.time.Duration

data class JwtProperties(
    val secret: String,
    val issuer: String,
    val audience: String,
    val expireMilliseconds: Long,
    val refreshValidityMs: Long
) {
    val expireDuration: Duration = Duration.ofMillis(expireMilliseconds)
    val refreshValidityDuration: Duration = Duration.ofMillis(refreshValidityMs * 24L * 30L)
}