package org.gitanimals.guild.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
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

    beforeEach {
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
})
