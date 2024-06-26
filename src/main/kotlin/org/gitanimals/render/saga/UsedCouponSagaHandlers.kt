package org.gitanimals.render.saga

import org.gitanimals.render.domain.UserService
import org.gitanimals.render.saga.event.CouponUsed
import org.rooftop.netx.api.SagaCommitEvent
import org.rooftop.netx.api.SagaCommitListener
import org.rooftop.netx.meta.SagaHandler

@SagaHandler
class UsedCouponSagaHandlers(
    private val userService: UserService,
) {

    @SagaCommitListener(event = CouponUsed::class)
    fun handleCouponUsedCommitEvent(sagaCommitEvent: SagaCommitEvent) {
        val couponUsed = sagaCommitEvent.decodeEvent(CouponUsed::class)
        if (couponUsed.code != "NEW_USER_BONUS_PET") {
            return
        }
        sagaCommitEvent.setNextEvent(couponUsed)

        userService.giveBonusPersona(couponUsed.username, couponUsed.dynamic)
    }
}
