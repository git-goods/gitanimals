package org.gitanimals.core


data class PersonaEvolution(
    val weight: Double,
    val type: PersonaEvolutionType,
) {

    companion object {

        val nothing = PersonaEvolution(
            weight = 0.0,
            type = PersonaEvolutionType.NOTHING,
        )
    }
}

enum class PersonaEvolutionType {

    NOTHING,
    RABBIT,
    LITTLE_CHICK,
    ;
}
