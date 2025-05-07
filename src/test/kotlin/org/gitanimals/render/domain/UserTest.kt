package org.gitanimals.render.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.nulls.shouldNotBeNull
import org.gitanimals.core.DomainEventPublisher
import org.gitanimals.core.PersonaType
import org.gitanimals.core.instant
import org.gitanimals.core.toZonedDateTime
import org.gitanimals.render.domain.event.PersonaDeleted
import org.gitanimals.render.domain.value.Contribution
import org.gitanimals.render.supports.DomainEventHolder
import org.springframework.test.context.ContextConfiguration
import java.time.Instant
import java.time.temporal.ChronoUnit

@ContextConfiguration(
    classes = [
        DomainEventHolder::class,
        DomainEventPublisher.EventPublisherInjector::class,
    ]
)
@DisplayName("User 클래스의")
internal class UserTest(
    /**
     * 빈 주입 순서로 인해서 주입을 받아야한다.
     * 그러지 않으면 lazy initialize 에러가 발생한다.
     */
    eventPublisherInjector: DomainEventPublisher.EventPublisherInjector,
    private val domainEventHolder: DomainEventHolder,
) : DescribeSpec({

    beforeEach {
        domainEventHolder.deleteAll()
    }

    describe("newUser 메소드는") {
        context("이름에 [대문자, -, 소문자, 숫자]로 이루어진 문장이 들어올 경우") {
            it("새로운 유저를 생성한다.") {
                shouldNotThrowAny {
                    User.newUser(
                        "$ALPHABET-${ALPHABET.lowercase()}01234567890",
                        mutableMapOf(),
                    )
                }
            }
        }

        context("이름에 [대문에, -, 소문자, 숫자]를 제외한 다른 문자가 들어올 경우") {
            it("IllegalArgumentException 을 던진다.") {
                shouldThrowWithMessage<IllegalArgumentException>("Not supported word contained in \"d안b\"") {
                    User.newUser("d안b", mutableMapOf())
                }
            }
        }
    }

    describe("isContributionUpdatedBeforeOneHour 메소드는") {
        context("user의 contribution이 1시간 전에 마지막으로 업데이트 되었을 경우,") {
            val user = user(
                contributions = mutableListOf(
                    Contribution(
                        2024,
                        0,
                        Instant.now().minus(2, ChronoUnit.HOURS),
                    )
                )
            )

            it("true를 반환한다.") {
                user.isContributionUpdatedBeforeOneHour() shouldBeEqual true
            }
        }

        context("user의 현재년도에 해당하는 contribution을 찾을 수 없는 경우,") {
            val user = user()
            it("true를 반환한다.") {
                user.isContributionUpdatedBeforeOneHour() shouldBeEqual true
            }
        }

        context("user의 contribution이 업데이트 된지 1시간이 지나지 않았을 경우,") {
            val user = user(
                contributions = mutableListOf(
                    Contribution(
                        instant().toZonedDateTime().year,
                        0,
                        instant(),
                    )
                )
            )
            it("false를 반환한다.") {
                user.isContributionUpdatedBeforeOneHour() shouldBeEqual false
            }
        }
    }

    describe("giveNewPersona 메소드는") {
        context("펫이 30마리가 넘을경우,") {
            val user = User.newUser("new-user", mutableMapOf())

            it("visible false의 pet을 생성한다.") {
                repeat(99) {
                    user.updateContribution(30 * (it + 1))
                    user.giveNewPersona()
                }

                user.personas.count { !it.visible } shouldBeEqual 70
            }
        }
    }

    describe("giveBonusPersona 메소드는") {
        context("Bonus pet 목록에 등록된 pet의 이름이 주어질 경우,") {
            val user = User.newUser("new-user", mutableMapOf())
            val persona = PersonaType.PENGUIN

            it("새로운 펫을 지급한다.") {
                user.giveNewPersonaByType(persona)

                user.personas.find { it.type == PersonaType.PENGUIN }.shouldNotBeNull()
            }
        }
    }

    describe("mergePersona 메소드는") {
        context("increasePersonaId와 deletePersonaId를 받아서,") {
            val user = User.newUser("devxb", mapOf())
            user.updateContribution(30)
            user.giveNewPersona()

            val increasePersonaId = user.personas.minByOrNull { it.level.value }!!.id
            val deletePersonaId = user.personas.maxByOrNull { it.level.value }!!.id
            it("increasePersonaId에 deletePersonasId의 level을 추가하고, deletePersona를 삭제한다") {
                user.mergePersona(increasePersonaId, deletePersonaId)

                user.personas.size shouldBeEqual 1
                domainEventHolder.eventsShouldBe(PersonaDeleted::class, 1)
            }
        }
    }

    describe("deletePersona 메소드는") {
        context("personaId를 받으면,") {
            val user = User.newUser("devxb", mapOf(2025 to 1000))
            val personaId = user.personas[0].id

            it("persona를 삭제하고 PersonaDeleted 이벤트를 발행한다.") {
                user.deletePersona(personaId)

                domainEventHolder.eventsShouldBe(PersonaDeleted::class, 1)
            }
        }

        context("persona 수가 하나라면") {
            val user = User.newUser("devxb", mapOf())
            val personaId = user.personas[0].id

            it("IllegalStateException을 던진다") {
                shouldThrowExactly<IllegalStateException> {
                    user.deletePersona(personaId)
                }
            }
        }
    }
}) {
    private companion object {
        private const val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }
}
