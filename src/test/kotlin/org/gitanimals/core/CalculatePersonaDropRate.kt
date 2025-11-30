package org.gitanimals.core

import io.kotest.core.spec.style.StringSpec

internal class CalculatePersonaDropRate : StringSpec({

    "특정 진화 펫 등장확률 테스트" {
        val dropCount = 10000
        val expectedPersona = PersonaType.PIG_ROBOT

        val results = mutableMapOf<PersonaType, Int>()
        repeat(dropCount) {
            val evolutionResult = expectedPersona.randomEvolution()

            results[evolutionResult] = (results[evolutionResult]?.plus(1)) ?: 1
        }

        println("--- 모수: $dropCount ---")
        results.forEach { (key, value) ->
            val dropPercentage = (value.toDouble() / dropCount.toDouble()) * 100
            println("$key -> $dropPercentage% ($value)")
        }
    }

    "특정 펫 등장 테스트" {
        val dropCount = 10000
        val expectedPersona = PersonaType.HAMSTER_SNOW

        val results = mutableMapOf<PersonaType, Int>()
        repeat(dropCount) {
            val dropResult: PersonaType = PersonaType.random()

            results[dropResult] = (results[dropResult]?.plus(1)) ?: 1
        }

        println("--- 모수: $dropCount ---")
        results.forEach { (key, value) ->
            val dropPercentage = (value.toDouble() / dropCount.toDouble()) * 100
            println("$key -> $dropPercentage% ($value)")
        }
    }
})
