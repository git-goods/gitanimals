package org.gitanimals.render.saga

import io.kotest.assertions.nondeterministic.eventually
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.should
import org.gitanimals.core.PersonaType
import org.gitanimals.render.domain.UserRepository
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.user
import org.gitanimals.render.saga.event.CouponUsed
import org.gitanimals.render.supports.RedisContainer
import org.gitanimals.render.supports.SagaCapture
import org.rooftop.netx.api.SagaManager
import org.rooftop.netx.meta.EnableSaga
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import kotlin.time.Duration.Companion.seconds

@EnableSaga
@DataJpaTest
@ContextConfiguration(
    classes = [
        RedisContainer::class,
        SagaCapture::class,
        UserService::class,
        UsedCouponSagaHandlers::class,
    ]
)
@DisplayName("UsedCouponSagaHandler 클래스의")
@TestPropertySource("classpath:application.properties")
@EntityScan(basePackages = ["org.gitanimals.render.domain"])
@EnableJpaRepositories(basePackages = ["org.gitanimals.render.domain"])
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
