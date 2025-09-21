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

    "split('\n') 는 실제 개행만을 구분한다" {
        val text = """
             + val text = "Hello\nWorld"
             + println(text)
        """.trimIndent()

        val result = text.split("\n")

        result[0] shouldBe """+ val text = "Hello\nWorld""""
        result[1] shouldBe "+ println(text)"
    }
})
