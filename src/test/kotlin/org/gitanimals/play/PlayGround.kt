package org.gitanimals.play

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PlayGround : StringSpec({
    "runCatching의 also구문은 runCatching에서 예외가 던져져도 동작한다"() {
        var isRunAlso = false
        shouldThrow<IllegalArgumentException> {
            runCatching {
                throw IllegalArgumentException("hello?")
            }.also {
                isRunAlso = true
            }.getOrElse {
                throw it
            }
        }

        isRunAlso shouldBe true
    }
})
