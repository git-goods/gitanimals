package org.gitanimals.render.app

import io.kotest.assertions.nondeterministic.eventually
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import org.gitanimals.render.domain.UserStatisticService
import org.gitanimals.render.supports.RedisContainer
import org.gitanimals.render.supports.SagaCapture
import org.rooftop.netx.meta.EnableSaga
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import kotlin.time.Duration.Companion.seconds

@EnableSaga
@DataJpaTest
@ContextConfiguration(
    classes = [
        RedisContainer::class,
        SagaCapture::class,
        UserStatisticSchedule::class,
        UserStatisticService::class,
    ]
)
@TestPropertySource("classpath:application.properties")
@DisplayName("UserStatisticSchedule 클래스의")
@EntityScan(basePackages = ["org.gitanimals.render.domain"])
@EnableJpaRepositories(basePackages = ["org.gitanimals.render.domain"])
internal class UserStatisticScheduleTest(
    private val userStatisticSchedule: UserStatisticSchedule,
    private val sagaCapture: SagaCapture,
) : DescribeSpec({

    describe("sendYesterdayNewUserReport 메소드는") {
        context("호출되면,") {
            it("UserYesterdayReport 를 담은 이벤트를 발행한다.") {
                userStatisticSchedule.sendYesterdayNewUserReport()

                eventually(5.seconds) {
                    sagaCapture.startCountShouldBe(1)
                }
            }
        }
    }
})
