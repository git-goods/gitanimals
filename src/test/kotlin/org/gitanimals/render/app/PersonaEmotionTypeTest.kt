package org.gitanimals.render.app

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.shouldBe
import org.gitanimals.core.PersonaType

class PersonaEmotionTypeTest : DescribeSpec({
    describe("DessertFox") {
        it("should return all download URLs") {
            PersonaEmotionAssets.DessertFox.error shouldBe "/assets/images?personaType=DESSERT_FOX&emotion=error"
            PersonaEmotionAssets.DessertFox.happy shouldBe "/assets/images?personaType=DESSERT_FOX&emotion=happy"
        }

        it("should return SVG content by emotion") {
            (PersonaEmotionAssets.DessertFox.getAsset("error").length > 10) shouldBe true
        }
    }

    describe("PersonaEmotionAssets.from") {
        it("should return the correct instance for a given PersonaType") {
            val instance = PersonaEmotionAssets.from(PersonaType.DESSERT_FOX)
            instance shouldBe PersonaEmotionAssets.DessertFox
        }
    }
})
