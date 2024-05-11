package org.gitanimals.render.saga

import io.kotest.assertions.nondeterministic.eventually
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.should
import org.gitanimals.render.domain.PersonaType
import org.gitanimals.render.domain.UserRepository
import org.gitanimals.render.domain.user
import org.gitanimals.render.saga.event.CouponUsed
import org.gitanimals.render.supports.RedisContainer
import org.rooftop.netx.api.SagaManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import kotlin.time.Duration.Companion.seconds

@SpringBootTest(
    classes = [
        RedisContainer::class,
    ]
)
@DisplayName("UsedCouponSagaHandler 클래스의")
internal class UsedCouponSagaHandlerTest(
    private val sagaManager: SagaManager,
    private val userRepository: UserRepository,
) : DescribeSpec({

    beforeTest {
        userRepository.deleteAll()
        userRepository.saveAndFlush(user)
    }

    describe("handleCouponUsedCommitEvent 메소드는") {
        context("CouponUsed commit event를 받으면") {
            val sagaId = sagaManager.startSync()

            val couponUsed = CouponUsed(
                userId = user.id,
                username = user.name,
                code = "NEW_USER_BONUS_PET",
                dynamic = "GOOSE",
            )

            it("coupon을 사용한다.") {
                sagaManager.commitSync(sagaId, couponUsed)

                Thread.sleep(1.seconds.inWholeMilliseconds)

                eventually(5.seconds) {
                    val user = userRepository.findByIdOrNull(user.id)!!

                    user.personas.shouldHaveSize(1)
                        .should {
                            it.first().type shouldBeEqual PersonaType.GOOSE
                        }
                }
            }
        }
    }
}) {
    companion object {
        private var user = user()
    }
}
