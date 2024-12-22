package org.gitanimals.guild.app

import io.kotest.assertions.nondeterministic.eventually
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import org.gitanimals.guild.app.request.CreateGuildRequest
import org.gitanimals.guild.domain.GuildFarmType
import org.gitanimals.guild.domain.GuildRepository
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.supports.RedisContainer
import org.gitanimals.guild.supports.GuildSagaCapture
import org.rooftop.netx.meta.EnableSaga
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application
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
        Application::class,
        RedisContainer::class,
        GuildSagaCapture::class,
        CreateGuildFacade::class,
        MockApiConfiguration::class,
        GuildService::class,
    ]
)
@DisplayName("CreateGuildFacade 클래스의")
@EntityScan(basePackages = ["org.gitanimals.guild"])
@TestPropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = ["org.gitanimals.guild"])
internal class CreateGuildFacadeTest(
    private val createGuildFacade: CreateGuildFacade,
    private val guildSagaCapture: GuildSagaCapture,
    private val identityApi: IdentityApi,
    private val guildRepository: GuildRepository,
) : DescribeSpec({

    beforeEach {
        guildSagaCapture.clear()
        guildRepository.deleteAll()
    }

    describe("createGuild 메소드는") {
        context("token에 해당하는 유저가 길드를 생성할 수 있는 돈을 갖고 있다면,") {
            it("길드를 생성한다.") {
                shouldNotThrowAny {
                    createGuildFacade.createGuild(TOKEN, createGuildRequest)
                }

                guildSagaCapture.countShouldBe(
                    start = 1,
                    commit = 1,
                )
            }
        }

        context("token에 해당하는 유저가 길드를 생성할 수 있는 돈을 갖고 있지 않다면,") {
            val poolUserToken = "Bearer pool"

            it("IllegalArgumentException을 던진다,") {
                every { identityApi.getUserByToken(poolUserToken) } returns poolIdentityUserResponse

                shouldThrowExactly<IllegalArgumentException> {
                    createGuildFacade.createGuild(poolUserToken, createGuildRequest)
                }

                eventually(5.seconds) {
                    guildSagaCapture.countShouldBe(start = 1, rollback = 1)
                }
            }
        }

        context("포인트 차감 이후 에러가 발생하면,") {
            it("유저에게 돈을 돌려준다.") {
                // Create Duplicate data set for throw error
                createGuildFacade.createGuild(TOKEN, createGuildRequest)
                guildSagaCapture.clear()

                shouldThrowAny {
                    createGuildFacade.createGuild(TOKEN, createGuildRequest)
                }

                eventually(5.seconds) {
                    guildSagaCapture.countShouldBe(
                        start = 1,
                        commit = 1,
                        rollback = 1,
                    )
                }
            }
        }
    }
}) {
    private companion object {
        private const val TOKEN = "Bearer ..."

        private val createGuildRequest = CreateGuildRequest(
            title = "Gitanimals",
            body = "We are gitanimals",
            guildIcon = "gitanimals.org",
            autoJoin = true,
            farmType = GuildFarmType.DUMMY,
            personaId = "123456789",
        )

        private val poolIdentityUserResponse = IdentityApi.UserResponse(
            id = "1",
            username = "devxb",
            points = "29999",
            profileImage = "https://gitanimals.org"
        )

    }
}
