package org.gitanimals.render.app

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.shouldBe
import org.gitanimals.core.PersonaType

class PersonaEmotionTypeTest : DescribeSpec({
    describe("DessertFox.findAllAssets") {
        it("should return all string fields as AssetsResponse") {
            val assets = PersonaEmotionAssets.DessertFox.findAllAssets()
            
            // error, happy, idleFollow, notification, thinking, typing = 6 fields
            assets.shouldHaveAtLeastSize(6)
            assets.forEach {
                it.animationType shouldBe PersonaEmotionAssets.DessertFox
            }
        }
    }

    describe("PersonaEmotionAssets.from") {
        it("should return the correct instance for a given PersonaType") {
            val instance = PersonaEmotionAssets.from(PersonaType.DESSERT_FOX)
            instance shouldBe PersonaEmotionAssets.DessertFox
        }
    }
})
