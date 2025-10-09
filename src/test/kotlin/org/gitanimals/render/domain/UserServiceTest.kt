package org.gitanimals.render.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import org.gitanimals.core.DomainEventPublisher
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.PersonaType
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

    afterEach {
        userRepository.deleteAll()
    }

    describe("deletePersona 메소드는") {
        context("userId와 personaId를 받으면,") {
            userRepository.save(user)
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

    describe("evolutionPersona 메소드는") {
        context("name과 진화 타입이 nothing이 아닌 펫의 personaId를 받으면,") {
            val user = userRepository.save(user)
            val personaId = IdGenerator.generate()
            userService.addPersona(
                name = user.getName(),
                id = personaId,
                idempotencyKey = IdGenerator.generate().toString(),
                personaType = PersonaType.LITTLE_CHICK.name,
                level = 100,
            )

            it("진화를 성공한다.") {
                shouldNotThrowAny {
                    userService.evolutionPersona(
                        name = user.getName(),
                        personaId = personaId,
                    )
                }
            }
        }

        context("name과 진화 타입이 nothing인 펫의 personaId를 받으면,") {
            val user = userRepository.save(user)
            val personaId = IdGenerator.generate()
            userService.addPersona(
                name = user.getName(),
                id = personaId,
                idempotencyKey = IdGenerator.generate().toString(),
                personaType = PersonaType.TEN_MM.name,
                level = 100,
            )

            it("진화를 실패한다.") {
                val result = shouldThrowExactly<IllegalArgumentException> {
                    userService.evolutionPersona(
                        name = user.getName(),
                        personaId = personaId,
                    )
                }

                result.message!!.contains("Evolution fail cause, not support evolution type") shouldBe true
            }
        }

        context("name과, 진화타입이 nothing이 아니지만, 레벨이 부족한 펫의 personaId를 받으면,") {
            val user = userRepository.save(user)
            val personaId = IdGenerator.generate()
            userService.addPersona(
                name = user.getName(),
                id = personaId,
                idempotencyKey = IdGenerator.generate().toString(),
                personaType = PersonaType.LITTLE_CHICK.name,
                level = 99,
            )

            it("진화를 실패한다.") {
                val result = shouldThrowExactly<IllegalArgumentException> {
                    userService.evolutionPersona(
                        name = user.getName(),
                        personaId = personaId,
                    )
                }

                result.message!!.contains("Cannot evolution persona cause") shouldBe true
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
