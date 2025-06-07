package org.gitanimals.render.app

import com.ninjasquad.springmockk.MockkBean
import io.kotest.assertions.nondeterministic.eventually
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.gitanimals.core.UpdateUserOrchestrator
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.core.lock.DistributedLock
import org.gitanimals.core.lock.RedisDistributedLockService
import org.gitanimals.core.lock.RedissonConfig
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.supports.RedisContainer
import org.gitanimals.rank.domain.UserContributionRankService
import org.gitanimals.render.domain.*
import org.gitanimals.render.supports.SagaCapture
import org.rooftop.netx.meta.EnableSaga
import org.slf4j.MDC
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

@EnableSaga
@DataJpaTest
@ContextConfiguration(
    classes = [
        SagaCapture::class,
        RedisContainer::class,
        AnimationFacade::class,
        RedissonConfig::class,
        RedisDistributedLockService::class,
        DistributedLock.DistributedLockServiceInjector::class,
        UserService::class,
        GuildService::class,
        UserContributionRankService::class,
    ]
)
@EntityScan(basePackages = ["org.gitanimals"])
@TestPropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = ["org.gitanimals"])
@DisplayName("AnimationFacade 클래스의")
internal class AnimationFacadeTest(
    private val sagaCapture: SagaCapture,
    private val animationFacade: AnimationFacade,
    @MockkBean(relaxed = true) private val githubRestApi: GithubRestApi,
    @MockkBean(relaxed = true) private val contributionApi: ContributionApi,
    @MockkBean(relaxed = true) private val updateUserOrchestrator: UpdateUserOrchestrator,
    private val userRepository: UserRepository,
) : DescribeSpec({

    beforeEach {
        MDC.put(TRACE_ID, Random.nextLong().toString())
        every { githubRestApi.getGithubUser(any()) } returns GithubRestApi.GithubUserResponse(
            name = "xb",
            id = authenticationId,
        )
        every { githubRestApi.getGithubUser(any()) } returns GithubRestApi.GithubUserResponse(
            name = "after-xb",
            id = authenticationId,
        )
    }

    afterEach {
        userRepository.deleteAll()
        sagaCapture.clear()
    }

    describe("getFarmAnimation 메소드는") {
        context("새로운 유저가 들어오면") {
            val newUsername = "xb"

            it("유저를 가입시키고, NewUserCreated 이벤트를 발행한다") {
                animationFacade.getFarmAnimation(newUsername)

                eventually(5.seconds) {
                    sagaCapture.startCountShouldBe(1)
                }
            }
        }

        context("이미 가입한 유저가 들어오면") {
            val alreadyExistsUsername = "xb"
            userRepository.save(user(name = alreadyExistsUsername))

            it("NewUserCreated 이벤트를 발행하지 않는다.") {
                animationFacade.getFarmAnimation(alreadyExistsUsername)

                eventually(5.seconds) {
                    sagaCapture.startCountShouldBe(0)
                }
            }
        }

        context("기존유저의 userAuthInfo가 없다면") {
            val alreadyExistsUsername = "xb"
            userRepository.save(user(name = alreadyExistsUsername, authInfo = null))

            it("AuthUserInfo를 세팅한다") {
                animationFacade.getFarmAnimation(alreadyExistsUsername)

                val result = userRepository.findByName(alreadyExistsUsername)

                result?.isAuthInfoSet() shouldBe true
            }
        }
    }
}) {
    companion object {
        private val authenticationId = "12345"
    }
}
