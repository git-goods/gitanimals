package org.gitanimals.render.app

import org.gitanimals.core.FieldType
import org.gitanimals.core.Mode
import org.gitanimals.render.domain.UserService
import org.springframework.stereotype.Service

@Service
class DrawGuildFacade(
    private val userService: UserService,
) {

    fun drawGuild(
        title: String,
        totalContributions: Long,
        fieldType: FieldType,
        userIds: List<Long>,
        personaIds: List<Long>,
    ): String {
        val users = userService.findAllUsersByIdWithContributions(userIds.toSet())

        val svgBuilder = StringBuilder().openGuild()
            .append(fieldType.fillBackground())

        val personaSvgs = users.flatMap { user ->
            user.personas.filter { persona ->
                persona.id in personaIds
            }.map { persona ->
                persona.toSvgForce(Mode.NAME_WITH_LEVEL)
            }
        }

        personaSvgs.forEach { svgBuilder.append(it) }

        return svgBuilder.append(fieldType.loadComponent(title, totalContributions))
            .append(fieldType.drawBorder())
            .closeGuild()
    }

    private fun StringBuilder.openGuild(): StringBuilder =
        this.append("<svg width=\"600\" height=\"300\" viewBox=\"0 0 600 300\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">")

    private fun StringBuilder.closeGuild(): String = this
        .append("</svg>")
        .toString()

}


