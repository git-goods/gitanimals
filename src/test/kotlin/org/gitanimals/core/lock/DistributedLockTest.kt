package org.gitanimals.core.lock

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.redisson.api.RLock
import org.redisson.api.RedissonClient
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(
    classes = [
        RedisDistributedLockService::class
    ]
)
@DisplayName("DistributedLock 클래스의")
class DistributedLockTest(
    private val redisDistributedLockService: RedisDistributedLockService,
    @MockkBean(relaxed = true) private val redissonClient: RedissonClient,
) : StringSpec({

    "Redis 구현채는 Lock획득에 실패했을때, whenAcquireFail 구문을 실행한다"() {
        // given
        val rLock = mockk<RLock>()
        every { redissonClient.getLock(any<String>()) } returns rLock
        every { rLock.tryLock(any(), any(), any()) } returns false

        // when
        val result = redisDistributedLockService.withLock(
            key = "test",
            whenAcquireFail = { "whenAcquireFail" },
        ) { "success" }

        // then
        result shouldBe "whenAcquireFail"
    }
})
