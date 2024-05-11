package org.gitanimals.render.domain

import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration

@DataJpaTest
@DisplayName("UserService 클래스의")
@ContextConfiguration(
    classes = [
        UserService::class,
    ]
)
@EntityScan(basePackages = ["org.gitanimals.render.domain"])
@EnableJpaRepositories(basePackages = ["org.gitanimals.render.domain"])
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
        val user = User.newUser("devxb", mapOf())
    }
}
