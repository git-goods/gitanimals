package org.gitanimals.supports.orchestrate

import com.ninjasquad.springmockk.MockkBean
import io.kotest.assertions.nondeterministic.eventually
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.gitanimals.core.PersonaType
import org.gitanimals.core.filter.MDCFilter
import org.gitanimals.core.lock.DistributedLock
import org.gitanimals.core.lock.RedisDistributedLockService
import org.gitanimals.core.lock.RedissonConfig
import org.gitanimals.guild.domain.GuildRepository
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.guild
import org.gitanimals.guild.domain.leader
import org.gitanimals.guild.supports.RedisContainer
import org.gitanimals.rank.domain.Rank
import org.gitanimals.rank.domain.UserContributionRank
import org.gitanimals.rank.domain.UserContributionRankRepository
import org.gitanimals.rank.domain.UserContributionRankService
import org.gitanimals.render.app.AnimationFacade
import org.gitanimals.render.app.ContributionApi
import org.gitanimals.render.app.GithubRestApi
import org.gitanimals.render.domain.*
import org.gitanimals.render.supports.SagaCapture
import org.rooftop.netx.meta.EnableSaga
import org.slf4j.MDC
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.findByIdOrNull
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
        NetxUserOrchestrator::class,
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
@DisplayName("NetxUserOrchestrator 클래스의 ")
internal class NetxUserOrchestratorTest(
    private val sagaCapture: SagaCapture,
    private val animationFacade: AnimationFacade,
    private val userRepository: UserRepository,
    private val guildRepository: GuildRepository,
    private val userContributionRankRepository: UserContributionRankRepository,
    @MockkBean(relaxed = true) private val githubRestApi: GithubRestApi,
    @MockkBean(relaxed = true) private val contributionApi: ContributionApi,
    @MockkBean(relaxed = true) private val identityApi: IdentityApi,
) : DescribeSpec({

    beforeEach {
        MDC.put(MDCFilter.TRACE_ID, Random.nextLong().toString())
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
        guildRepository.deleteAll()
        userContributionRankRepository.deleteAll()
        sagaCapture.clear()
    }

    fun setUpTestDataWithUsername(name: String): Pair<User, Rank> {
        val changeUser = userRepository.save(
            user(
                name = name,
                authInfo = UserAuthInfo(EntryPoint.GITHUB, authenticationId),
            ).apply {
                this.addPersona(0, PersonaType.CAT, 1)
            }
        )

        guildRepository.save(
            guild(
                id = 1,
                title = "Guild-1",
                leader = leader(name = name)
            )
        )
        guildRepository.save(guild(id = 2, title = "Guild-2").apply {
            this.join(
                memberUserId = changeUser.id,
                memberName = changeUser.getName(),
                memberPersonaId = 1L,
                memberContributions = 12345L,
                memberPersonaType = PersonaType.CAT,
            )
        })

        val changeRank = userContributionRankRepository.save(
            UserContributionRank.create(
                image = "",
                userId = changeUser.id,
                username = changeUser.getName(),
                weeklyContributions = 12345L,
            )
        )

        return changeUser to changeRank
    }

    describe("updateUsername 메소드는") {

        context("새로운 유저인데, 기존에 다른 이름으로 authInfo가 등록되어 있다면") {
            val (user, rank) = setUpTestDataWithUsername("xb")
            val afterName = "after-xb"

            it("이름을 변경한다") {
                animationFacade.getFarmAnimation(afterName)

                eventually(5.seconds) {
                    userRepository.findByIdOrNull(user.id)?.getName() shouldBe afterName
                    userContributionRankRepository.findByIdOrNull(rank.id)?.username shouldBe afterName
                    guildRepository.findAllGuildByUsernameWithMembers(afterName).count() shouldBe 2
                }
            }
        }

        context("identityApi 서버의 유저 정보 업데이트 중에 IllegalArgumentException이 아닌 에러가 발생하면") {
            val beforeName = "xb"
            val (user, rank) = setUpTestDataWithUsername(beforeName)
            val afterName = "after-xb"

            it("모든 변경을 이전 이름으로 롤백한다") {
                every {
                    identityApi.updateUserByAuthInfo(any(), any(), any())
                } throws IllegalStateException("Some error")

                shouldThrowExactly<IllegalStateException> {
                    animationFacade.getFarmAnimation(afterName)
                }

                eventually(5.seconds) {
                    userRepository.findByIdOrNull(user.id)?.getName() shouldBe beforeName
                    userContributionRankRepository.findByIdOrNull(rank.id)?.username shouldBe beforeName
                    guildRepository.findAllGuildByUsernameWithMembers(beforeName).count() shouldBe 2
                }
            }
        }

        context("identityApi 서버의 유저 정보 업데이트 중에 IllegalArgumentException 에러가 발생하면") {
            val beforeName = "xb"
            val (user, rank) = setUpTestDataWithUsername(beforeName)
            val afterName = "after-xb"

            it("무시한다") {
                every {
                    identityApi.updateUserByAuthInfo(any(), any(), any())
                } throws IllegalArgumentException("Some error")

                animationFacade.getFarmAnimation(afterName)

                eventually(5.seconds) {
                    userRepository.findByIdOrNull(user.id)?.getName() shouldBe afterName
                    userContributionRankRepository.findByIdOrNull(rank.id)?.username shouldBe afterName
                    guildRepository.findAllGuildByUsernameWithMembers(afterName).count() shouldBe 2
                }
            }
        }
    }
}) {
    companion object {
        private val authenticationId = "12345"
    }
}
