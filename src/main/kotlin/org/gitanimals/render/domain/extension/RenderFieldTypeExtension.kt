package org.gitanimals.render.domain.extension

import org.gitanimals.core.FieldType

object RenderFieldTypeExtension {

    fun FieldType.isRenderField(): Boolean {
        return this in renderFields
    }

    private val renderFields = FieldType.entries.filter { it != FieldType.LOGO_SHOWING }
}
