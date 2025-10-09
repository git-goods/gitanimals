package org.gitanimals.render.app.request

data class MergePersonaV2Request(
    val increasePersonaId: String,
    val deletePersonaId: List<String>,
)
