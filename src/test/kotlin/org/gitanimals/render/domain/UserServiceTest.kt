package org.gitanimals.render.domain

import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import org.gitanimals.core.DomainEventPublisher
import org.gitanimals.render.supports.IntegrationTest

@IntegrationTest(
    classes = [
        UserService::class,
        DomainEventPublisher.EventPublisherInjector::class,
    ]
)
@DisplayName("UserService 클래스의")
internal class UserServiceTest(
    private val userService: UserService,
    private val userRepository: UserRepository,
) : DescribeSpec({

    beforeEach {
        userRepository.save(user)
    }

    afterEach {
        userRepository.deleteAll()
    }

    describe("deletePersona 메소드는") {
        context("userId와 personaId를 받으면,") {
            val personaId = user.personas[0].id

            it("persona를 삭제한다.") {
                val response = userService.deletePersona(user.getName(), personaId)
                val user = userService.getUserByName(user.getName())

                user.personas
                    .find { it.id == response.id.toLong() }
                    .shouldBeNull()
            }
        }
    }

    describe("createNewUser 메소드는") {
        context("name은 다르지만 entryPoint와 authenticationId에 해당하는 User가 이미 존재한다면,") {
            val id = 12345
            val name = "hello"
            val user = user(
                id = 12345,
                name = name,
                authInfo = UserAuthInfo(EntryPoint.GITHUB, id.toString()),
            )

            userRepository.saveAndFlush(user)

            it("기존 user의 name을 새로운 유저의 name으로 변경한다.") {
                val response = userService.createNewUser(
                    name = "world",
                    contributions = emptyMap(),
                )

                response.getName() shouldBe "world"
                response.id shouldBe id
            }
        }
    }
}) {

    private companion object {
        val user = User.newUser(
            name = "devxb",
            contributions = mapOf(2025 to 1000),
        )
    }
}
