package org.gitanimals.guild.saga

import io.kotest.assertions.nondeterministic.eventually
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.gitanimals.guild.app.RenderApi
import org.gitanimals.guild.domain.*
import org.gitanimals.guild.saga.event.PersonaDeleted
import org.gitanimals.guild.supports.MockApiConfiguration
import org.gitanimals.render.supports.RedisContainer
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
        GuildService::class,
        MockApiConfiguration::class,
        PersonaDeletedSagaHandler::class,
    ]
)
@EntityScan(basePackages = ["org.gitanimals.guild"])
@EnableJpaRepositories(basePackages = ["org.gitanimals.guild"])
@DisplayName("PersonaDeletedSagaHandler 클래스의")
@TestPropertySource("classpath:application.properties")
internal class PersonaDeletedSagaHandlerTest(
    private val renderApi: RenderApi,
    private val sagaManager: SagaManager,
    private val guildRepository: GuildRepository,
) : DescribeSpec({
    describe("handlePersonaDeletedEvent 메소드는") {
        context("PersonaDeletedEvent를 받으면,") {
            val leaderId = 999L
            val leaderPersonaId = 100L
            val leaderName = "devxb"
            var guild = guild(
                leader = leader(
                    userId = leaderId,
                    name = "devxb",
                    personaId = leaderPersonaId
                )
            )

            val memberId = 200L
            val memberPersonaId = 200L
            val memberName = "member"
            guild.join(
                memberUserId = memberId,
                memberName = memberName,
                memberPersonaId = memberPersonaId,
                memberContributions = 100L,
                memberPersonaType = "GOOSE",
            )
            guild = guildRepository.save(guild)

            val changePersonaId = 101L
            val leaderPersonaDeleted = PersonaDeleted(
                userId = leaderId,
                username = leaderName,
                personaId = leaderPersonaId,
            )

            val memberPersonaDeleted = PersonaDeleted(
                userId = memberId,
                username = memberName,
                personaId = memberPersonaId,
            )

            every { renderApi.getUserByName(leaderName) } returns RenderApi.UserResponse(
                id = "1",
                name = "devxb",
                totalContributions = "1",
                personas = listOf(
                    RenderApi.UserResponse.PersonaResponse(
                        changePersonaId.toString(),
                        "10",
                        "GOOSE",
                    )
                )
            )

            every { renderApi.getUserByName(memberName) } returns RenderApi.UserResponse(
                id = "1",
                name = "member",
                totalContributions = "1",
                personas = listOf(
                    RenderApi.UserResponse.PersonaResponse(
                        changePersonaId.toString(),
                        "10",
                        "GOOSE",
                    )
                )
            )

            it("리더의 삭제된 펫을 모두 찾아 새로운 펫으로 변경한다.") {
                sagaManager.startSync(leaderPersonaDeleted)

                eventually(5.seconds) {
                    guildRepository.findByIdOrNull(guild.id)
                        ?.getLeaderPersonaId() shouldBe changePersonaId
                }
            }

            it("멤버의 삭제된 펫을 모두 찾아 새로운 펫으로 변경한다.") {
                sagaManager.startSync(memberPersonaDeleted)

                eventually(5.seconds) {
                    guildRepository.findAllGuildByUserIdWithMembers(memberId)[0]
                        .getMembers()
                        .first { it.userId == memberId }.personaId shouldBe changePersonaId
                }
            }
        }
    }
})
