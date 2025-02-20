package org.gitanimals.render.domain

import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import org.gitanimals.render.domain.listeners.DomainEventPublisher
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
                val response = userService.deletePersona(user.name, personaId)
                val user = userService.getUserByName(user.name)

                user.personas
                    .find { it.id == response.id.toLong() }
                    .shouldBeNull()
            }
        }
    }
}) {

    private companion object {
        val user = User.newUser("devxb", mapOf(2025 to 1000))
    }
}
