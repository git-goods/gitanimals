package org.gitanimals.render.app

import io.kotest.assertions.nondeterministic.eventually
import io.kotest.core.spec.style.DescribeSpec
import org.gitanimals.Application
import org.gitanimals.render.supports.RedisContainer
import org.gitanimals.render.supports.SagaCapture
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import kotlin.time.Duration.Companion.seconds

@SpringBootTest(
    classes = [
        Application::class,
        RedisContainer::class,
        SagaCapture::class,
    ]
)
@TestPropertySource("classpath:application.properties")
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
