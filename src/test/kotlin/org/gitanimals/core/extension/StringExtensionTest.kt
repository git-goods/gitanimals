package org.gitanimals.core.extension

import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.gitanimals.core.extension.StringExtension.deleteBrackets
import org.gitanimals.core.extension.StringExtension.trimNotDigitCharacters

@DisplayName("StringExtension class의")
internal class StringExtensionTest : DescribeSpec({

    describe("trimNotDigitCharacters 메소드는") {
        context("입력받은 문자의 앞 뒤로 숫자가 아닌 문자가 있다면") {
            val text = "\"12345\""

            it("앞 뒤 문자를 삭제한다.") {
                val result = text.trimNotDigitCharacters()

                result shouldBe "12345"
            }
        }
    }

    describe("deleteBrackets 메소드는") {
        val text = "{devxb}"
        context("입력받은 문자의 앞 뒤로 bracket이 있다면, 삭제한다") {
            val result = text.deleteBrackets()

            result shouldBe "devxb"
        }
    }
})
