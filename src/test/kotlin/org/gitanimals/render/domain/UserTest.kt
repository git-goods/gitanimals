package org.gitanimals.render.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual
import org.gitanimals.render.domain.value.Contribution
import java.time.Instant
import java.time.temporal.ChronoUnit

@DisplayName("User 클래스의")
internal class UserTest : DescribeSpec({

    describe("newUser 메소드는") {
        context("이름에 [대문자, -, 소문자, 숫자]로 이루어진 문장이 들어올 경우") {
            it("새로운 유저를 생성한다.") {
                shouldNotThrowAny {
                    User.newUser("$ALPHABET-${ALPHABET.lowercase()}01234567890", mutableMapOf())
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
                contributions = mutableListOf(Contribution(2024, 0, Instant.now()))
            )
            it("false를 반환한다.") {
                user.isContributionUpdatedBeforeOneHour() shouldBeEqual false
            }
        }
    }

    describe("giveNewPersona 메소드는") {
        val user = User.newUser("new-user", mutableMapOf())
        context("펫이 30마리가 넘을경우, visible false의 pet을 생성한다.") {
            repeat(99) {
                user.updateContribution(30 * (it + 1))
                user.giveNewPersona()
            }

            user.personas.count { !it.visible } shouldBeEqual 70
        }
    }
}) {
    private companion object {
        private const val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }
}
