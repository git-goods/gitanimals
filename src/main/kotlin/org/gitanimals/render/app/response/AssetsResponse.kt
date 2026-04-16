package org.gitanimals.render.app.response

import org.gitanimals.render.app.PersonaEmotionAssets

data class AssetsResponse(
    val animationAssets: PersonaEmotionAssets,
    val mimeType: String,
) {


    companion object {
        private const val MIME_TYPE_SVG_IMAGE = "image/svg+xml"

        fun createSvg(
            animationAssets: PersonaEmotionAssets,
        ): AssetsResponse {
            return AssetsResponse(
                animationAssets = animationAssets,
                mimeType = MIME_TYPE_SVG_IMAGE,
            )
        }
    }
}
