package org.gitanimals.render.app

import org.gitanimals.core.*

sealed interface PersonaEmotionAssets {
    val personaType: PersonaType
    val schemaVersion: Int get() = 1
    val name: String
    val author: String
    val version: String get() = "1.0.0"
    val description: String
    val license: String get() = "MIT"
    val viewBox: ViewBox
    val layout: Layout
    val eyeTracking: EyeTracking
    val timings: Timings
    val hitBoxes: HitBoxes
    val sleepingHitboxFiles: List<String>
    val miniMode: MiniMode
    val objectScale: ObjectScale

    val error: String
        get() = "/assets/images?personaType=${personaType}&emotion=error"
    val happy: String
        get() = "/assets/images?personaType=${personaType}&emotion=happy"
    val idleFollow: String
        get() = "/assets/images?personaType=${personaType}&emotion=idleFollow"
    val notification: String
        get() = "/assets/images?personaType=${personaType}&emotion=notification"
    val thinking: String
        get() = "/assets/images?personaType=${personaType}&emotion=thinking"
    val typing: String
        get() = "/assets/images?personaType=${personaType}&emotion=typing"
    val sleeping: String?
        get() = null
    val waking: String?
        get() = null

    fun getAsset(emotion: String): String

    data object DessertFox : PersonaEmotionAssets {
        override val personaType: PersonaType = PersonaType.DESSERT_FOX
        override val name: String = "Tanning Fox"
        override val author: String = "sumi"
        override val description: String =
            "A coding fox with a pocket notebook — pixel-perfect fennec inspired by GitAnimals"
        override val viewBox = ViewBox(x = -15, y = -25, width = 45, height = 45)
        override val layout = Layout(
            contentBox = Box(x = -2, y = -2, width = 20, height = 18),
            centerX = 7.5,
            baselineY = 15.0,
            visibleHeightRatio = 0.58,
            baselineBottomRatio = 0.05
        )
        override val eyeTracking = EyeTracking(
            enabled = false,
            states = listOf("idle"),
            eyeRatioX = 0.52,
            eyeRatioY = 0.45,
            maxOffset = 1.5,
            bodyScale = 0.25,
            shadowStretch = 0.15,
            shadowShift = 0.3,
            ids = EyeTrackingIds(eyes = "eyes-js", body = "body-js", shadow = "shadow-js"),
            shadowOrigin = "7.5px 14px"
        )
        override val timings = Timings(
            minDisplay = mapOf(
                "attention" to 4000,
                "error" to 5000,
                "notification" to 2500,
                "working" to 1000,
                "thinking" to 1000
            ),
            autoReturn = mapOf(
                "attention" to 4000,
                "error" to 5000,
                "notification" to 2500
            ),
            mouseIdleTimeout = 20000,
            mouseSleepTimeout = 60000,
            wakeDuration = 5000
        )
        override val hitBoxes = HitBoxes(
            default = Box(x = -3, y = -8, width = 22, height = 20),
            sleeping = Box(x = -3, y = -5, width = 22, height = 18)
        )
        override val sleepingHitboxFiles = listOf("sleeping.svg")
        override val miniMode = MiniMode(supported = false)
        override val objectScale = ObjectScale(
            widthRatio = 1.9,
            heightRatio = 1.3,
            offsetX = -0.45,
            offsetY = -0.25
        )

        override fun getAsset(emotion: String): String {
            return when (emotion) {
                "error" -> dessertFoxErrorEmotionSvg
                "happy" -> dessertFoxHappyEmotionSvg
                "idleFollow" -> dessertFoxIdleFollowEmotionSvg
                "notification" -> dessertFoxNotificationEmotionSvg
                "thinking" -> dessertFoxThinkingEmotionSvg
                "typing" -> dessertFoxTypingEmotionSvg
                else -> throw IllegalArgumentException("Invalid emotion: $emotion")
            }
        }
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

data class ViewBox(val x: Int, val y: Int, val width: Int, val height: Int)
data class Layout(
    val contentBox: Box,
    val centerX: Double,
    val baselineY: Double,
    val visibleHeightRatio: Double,
    val baselineBottomRatio: Double
)

data class Box(val x: Int, val y: Int, val width: Int, val height: Int)
data class EyeTracking(
    val enabled: Boolean,
    val states: List<String>,
    val eyeRatioX: Double,
    val eyeRatioY: Double,
    val maxOffset: Double,
    val bodyScale: Double,
    val shadowStretch: Double,
    val shadowShift: Double,
    val ids: EyeTrackingIds,
    val shadowOrigin: String
)

data class EyeTrackingIds(val eyes: String, val body: String, val shadow: String)
data class Timings(
    val minDisplay: Map<String, Int>,
    val autoReturn: Map<String, Int>,
    val mouseIdleTimeout: Int,
    val mouseSleepTimeout: Int,
    val wakeDuration: Int
)

data class HitBoxes(val default: Box, val sleeping: Box)
data class MiniMode(val supported: Boolean)
data class ObjectScale(
    val widthRatio: Double,
    val heightRatio: Double,
    val offsetX: Double,
    val offsetY: Double
)
