package org.gitanimals.render.saga.event

data class CouponUsed(
    val userId: Long,
    val code: String,
    val dynamic: String,
)
