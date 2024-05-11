package org.gitanimals.render.saga.event

data class CouponUsed(
    val userId: Long,
    val username: String,
    val code: String,
    val dynamic: String,
)
