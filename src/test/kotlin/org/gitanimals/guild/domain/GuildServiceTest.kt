package org.gitanimals.guild.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.gitanimals.guild.domain.GuildService.Companion.loadMembers
import org.gitanimals.guild.domain.GuildService.Companion.loadWaitMembers
import org.gitanimals.guild.domain.request.CreateLeaderRequest
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration

@DataJpaTest
@DisplayName("GuildService 클래스의")
@ContextConfiguration(classes = [GuildService::class])
@EntityScan(basePackages = ["org.gitanimals.guild"])
@EnableJpaRepositories(basePackages = ["org.gitanimals.guild"])
internal class GuildServiceTest(
    private val guildService: GuildService,
    private val guildRepository: GuildRepository,
) : DescribeSpec({

    afterEach {
        guildRepository.deleteAll()
    }

    describe("createGuild 메소드는") {
        context("guild 정보와 leader 정보를 입력받으면") {
            val guildIcon = "guildIcon"
            val title = "guildTitle"
            val body = "guildBody"
            val farmType = GuildFarmType.DUMMY
            val leaderRequest = CreateLeaderRequest(
                userId = 1L,
                name = "devxb",
                personaId = 2L,
                contributions = 3L,
            )

            it("중복된 길드가 아니라면 길드를 생성한다.") {

                shouldNotThrowAny {
                    guildService.createGuild(
                        guildIcon = guildIcon,
                        title = title,
                        body = body,
                        farmType = farmType,
                        createLeaderRequest = leaderRequest,
                        autoJoin = true,
                    )
                }
            }

            it("중복된 길드라면 IllegalArgumentException을 던진다.") {
                guildService.createGuild(
                    guildIcon = guildIcon,
                    title = title,
                    body = body,
                    farmType = farmType,
                    createLeaderRequest = leaderRequest,
                    autoJoin = true,
                )

                shouldThrowExactly<IllegalArgumentException> {
                    guildService.createGuild(
                        guildIcon = guildIcon,
                        title = title,
                        body = body,
                        farmType = farmType,
                        createLeaderRequest = leaderRequest,
                        autoJoin = true,
                    )
                }
            }
        }
    }

    describe("joinGuild 메소드는") {
        context("guild가 autoJoin true라면,") {
            val guild = guildRepository.save(guild())
            val memberUserId = 2L
            val memberName = "devxb"
            val memberPersonaId = 2L
            val memberContributions = 3L


            it("유저를 바로 길드에 가입시킨다.") {
                guildService.joinGuild(
                    guildId = guild.id,
                    memberUserId = memberUserId,
                    memberName = memberName,
                    memberPersonaId = memberPersonaId,
                    memberContributions = memberContributions,
                )

                guildService.getGuildById(guild.id, loadMembers).getMembers().size shouldBe 1
            }
        }

        context("guild가 autoJoin false라면,") {
            val guild = guildRepository.save(guild(autoJoin = false))
            val memberUserId = 2L
            val memberName = "devxb"
            val memberPersonaId = 2L
            val memberContributions = 3L


            it("유저를 wait 대기열에 포함시킨다.") {
                guildService.joinGuild(
                    guildId = guild.id,
                    memberUserId = memberUserId,
                    memberName = memberName,
                    memberPersonaId = memberPersonaId,
                    memberContributions = memberContributions,
                )

                guildService.getGuildById(guild.id, loadWaitMembers)
                    .getWaitMembers().size shouldBe 1
            }
        }

        context("가입을 요청한 유저와 리더의 아이디가 같다면,") {
            val memberUserId = 1L
            val guild = guildRepository.save(guild(leader = leader(userId = memberUserId)))
            val memberName = "devxb"
            val memberPersonaId = 2L
            val memberContributions = 3L

            it("IllegalArgumentException을 던진다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    guildService.joinGuild(
                        guildId = guild.id,
                        memberUserId = memberUserId,
                        memberName = memberName,
                        memberPersonaId = memberPersonaId,
                        memberContributions = memberContributions,
                    )
                }
            }
        }
    }
})
