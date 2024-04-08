package org.gitanimals.render.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec

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
}) {
    private companion object {
        private const val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }
}
