package org.gitanimals.render.app

import org.gitanimals.core.*

sealed interface PersonaEmotionAssets {
    val personaType: PersonaType
    val error: String
    val happy: String
    val idleFollow: String
    val notification: String
    val thinking: String
    val typing: String

    data object DessertFox : PersonaEmotionAssets {
        override val personaType: PersonaType = PersonaType.DESSERT_FOX
        override val error: String = dessertFoxErrorEmotionSvg
        override val happy: String = dessertFoxHappyEmotionSvg
        override val idleFollow: String = dessertFoxIdleFollowEmotionSvg
        override val notification: String = dessertFoxNotificationEmotionSvg
        override val typing: String = dessertFoxTypingEmotionSvg
        override val thinking: String = dessertFoxThinkingEmotionSvg
    }

    companion object {
        fun from(personaType: PersonaType): PersonaEmotionAssets {
            return PersonaEmotionAssets::class.sealedSubclasses
                .mapNotNull { it.objectInstance }
                .find { it.personaType == personaType }
                ?: throw IllegalArgumentException("Cannot find PersonaEmotionAssets for personaType: $personaType")
        }
    }
}
