package org.gitanimals.render.app.response

import com.fasterxml.jackson.annotation.JsonProperty
import org.gitanimals.render.app.*

data class AssetsResponse(
    val schemaVersion: Int,
    val name: String,
    val author: String,
    val version: String,
    val description: String,
    val license: String,
    val viewBox: ViewBox,
    val layout: Layout,
    val eyeTracking: EyeTracking,
    val states: Map<String, List<String?>>,
    val timings: Timings,
    val hitBoxes: HitBoxes,
    val sleepingHitboxFiles: List<String>,
    val miniMode: MiniMode,
    val objectScale: ObjectScale,
    val mimeType: String,
) {


    companion object {
        private const val MIME_TYPE_SVG_IMAGE = "image/svg+xml"

        fun createSvg(
            animationAssets: PersonaEmotionAssets,
        ): AssetsResponse {
            return AssetsResponse(
                schemaVersion = animationAssets.schemaVersion,
                name = animationAssets.name,
                author = animationAssets.author,
                version = animationAssets.version,
                description = animationAssets.description,
                license = animationAssets.license,
                viewBox = animationAssets.viewBox,
                layout = animationAssets.layout,
                eyeTracking = animationAssets.eyeTracking,
                states = mapOf(
                    "idle" to listOf(animationAssets.idleFollow),
                    "thinking" to listOf(animationAssets.thinking),
                    "working" to listOf(animationAssets.typing),
                    "error" to listOf(animationAssets.error),
                    "attention" to listOf(animationAssets.happy),
                    "notification" to listOf(animationAssets.notification),
                    "sleeping" to listOf(animationAssets.sleeping),
                    "waking" to listOf(animationAssets.waking),
                ),
                timings = animationAssets.timings,
                hitBoxes = animationAssets.hitBoxes,
                sleepingHitboxFiles = animationAssets.sleepingHitboxFiles,
                miniMode = animationAssets.miniMode,
                objectScale = animationAssets.objectScale,
                mimeType = MIME_TYPE_SVG_IMAGE,
            )
        }
    }
}

