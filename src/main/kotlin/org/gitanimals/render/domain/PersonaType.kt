package org.gitanimals.render.domain

import kotlin.math.atan2
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

enum class PersonaType(private val weight: Double) {
    GOOSE(1.0) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_SUNGLASSES(0.05) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseSunglassesSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_KOTLIN(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseKotlinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_JAVA(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseJavaSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_JS(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseJsSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_NODE(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseNodeSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_SWIFT(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseSwiftSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_LINUX(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseLinuxSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_SPRING(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val goose = gooseSpringSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    LITTLE_CHICK(0.9) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_SUNGLASSES(0.4) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickSunglassesSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_KOTLIN(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickKotlinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_JAVA(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickJavaSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_JS(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickJsSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_NODE(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickNodeSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_SWIFT(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickSwiftSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_LINUX(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickLinuxSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_SPRING(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            val littleChick = littleChickSpringSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    PENGUIN(0.5) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 6, 22.5)
                .toString()
    },

    PENGUIN_SUNGLASSES(0.2) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinSunglassesSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 6, 22.5)
                .toString()
    },

    PENGUIN_KOTLIN(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinKotlinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_JAVA(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinJavaSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_JS(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinJsSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_NODE(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinNodeSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_SWIFT(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinSwiftSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_LINUX(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinLinuxSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_SPRING(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return penguinSpringSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PIG(0.2) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_SUNGLASSES(0.08) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigSunglassesSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_KOTLIN(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigKotlinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_JAVA(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigJavaSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_JS(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigJsSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_NODE(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigNodeSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_SWIFT(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigSwiftSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_LINUX(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigLinuxSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_SPRING(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return pigSpringSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    SLIME_RED(0.1) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeRedSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_KOTLIN(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeRedKotlinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_JAVA(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeRedJavaSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_JS(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeRedJsSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_NODE(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeRedNodeSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_SWIFT(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeRedSwiftSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_LINUX(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeRedLinuxSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_BLUE(0.1) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeBlueSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_GREEN(0.1) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return slimeGreenSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    FLAMINGO(0.05) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return flamingoSvg.replace("*{position}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (persona.level.value.toString().length)).toString()
                )
        }

        override fun act(id: Long): String {
            val x = Random.nextInt(25, 75)
            val y = Random.nextInt(0, 50)
            val scale = 1
            return "translate(${x}%, ${y}%) scaleX($scale)"
        }
    },

    TEN_MM(0.000) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return tenmmSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-2 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("tenmm", id, 15, "180s", 5, 28.5)
                .toString()
    },

    GOBLIN(0.06) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return goblinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6.5 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("goblin", id, 15, "180s", 5, 14.5)
                .toString()
    },

    GOBLIN_BAG(0.03) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return goblinBagSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6.5 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("goblin-bag", id, 15, "180s", 5, 14.5)
                .toString()
    },

    BBIBBI(0.000) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return bbibbiSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1.5 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("bbibbi", id, 15, "180s", 5, 31.5)
                .toString()
    },

    CAT(0.1) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return catSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    CHEESE_CAT(0.04) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return cheeseCatSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    GALCHI_CAT(0.06) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return galchiCatSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    WHITE_CAT(0.04) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return whiteCatSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    FISH_MAN(0.002) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return fishManSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fishman", id, 15, "180s", 5, 16.5)
                .toString()
    },
    FISH_MAN_GLASSES(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return fishManGlassesSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("fishman", id, 15, "180s", 5, 16.5)
                .toString()
    },
    QUOKKA(0.3) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return quokkaSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("quokka", id, 40, "180s", 5, 10.0)
                .toString()
    },
    QUOKKA_LEAF(0.1) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return quokkaLeafSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("quokka", id, 40, "180s", 5, 10.0)
                .toString()
    },
    QUOKKA_SUNGLASSES(0.05) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return quokkaSunglassesSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("quokka", id, 40, "180s", 5, 10.0)
                .toString()
    },
    MOLE(0.3) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return moleSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("mole", id, 40, "180s", 5, 14.0)
                .toString()
    },
    MOLE_GRASS(0.1){
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            return moleGrassSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("mole", id, 40, "180s", 5, 14.0)
                .toString()
    },
    ;

    init {
        require(weight in 0.000..1.0) { "PersonaType's weight should be between 0.000 to 1.0" }
    }

    fun load(user: User, persona: Persona, mode: Mode): String =
        loadSvg(user, persona, mode)
            .drawContribution(mode, user)

    abstract fun loadSvg(user: User, persona: Persona, mode: Mode): String

    protected abstract fun act(id: Long): String

    protected fun String.drawContribution(
        mode: Mode,
        user: User
    ): String {
        return when (mode) {
            Mode.LINE -> {
                this.replace(
                    "*{contributionx}",
                    (12 + (-1 * (user.contributionCount().toString().length))).toString()
                )
                    .replace(
                        "*{contribution}",
                        user.contributionCount().toSvg(0.0, 2.0)
                    ).replace("*{contribution-display}", "default")
                    .replace("*{level-tag-display}", "default")
            }

            Mode.LINE_NO_CONTRIBUTION -> {
                this.replace("*{contribution-display}", "none")
                    .replace("*{level-tag-display}", "default")
            }

            else -> {
                this.replace("*{contribution-display}", "none")
                    .replace("*{level-tag-display}", "none")
            }
        }
    }

    companion object {

        private val maxWeight = lazy {
            var maxWeight = 0
            entries.forEach { personaType ->
                maxWeight += (personaType.weight * 1000).toInt()
            }
            maxWeight
        }.value

        private val personas = lazy {
            val weightedPersonas = mutableListOf<PersonaType>()
            entries.forEach { personaType ->
                repeat((personaType.weight * 1000).toInt()) {
                    weightedPersonas.add(personaType)
                }
            }
            weightedPersonas.shuffled()
        }.value

        fun random(): PersonaType = personas[Random.nextInt(0, maxWeight)]

        private fun StringBuilder.moveRandomly(
            type: String,
            id: Long,
            speed: Int,
            duration: String,
            personaWidth: Long,
            flippedWidth: Double, // flippedWidth = persona width * 3 / 2
        ): StringBuilder {
            val movingPoints = getMovingPoints(speed)

            makeMove(movingPoints, personaWidth, id, type, duration)
            reverseFlipped(id, movingPoints, flippedWidth, duration)

            return this
        }

        private fun StringBuilder.makeMove(
            movingPoints: List<MovingPoint>,
            personaWidth: Long,
            id: Long,
            type: String,
            duration: String
        ) {
            this.append("@keyframes move-$id {")

            var beforeMovingPoint = movingPoints.first()
            movingPoints.forEach { movingPoint ->
                if (beforeMovingPoint.scale != movingPoint.scale) {
                    this.append("${min(100.0, beforeMovingPoint.percentage + 0.01)}% {")
                        .append("transform:translate(${beforeMovingPoint.x - (personaWidth * movingPoint.scale)}%, ${beforeMovingPoint.y}%) rotate(${beforeMovingPoint.angle}deg) scaleX(${movingPoint.scale});")
                        .append("}")
                }
                this.append("${movingPoint.percentage}% {")
                    .append("transform:translate(${movingPoint.x}%, ${movingPoint.y}%) rotate(${movingPoint.angle}deg) scaleX(${movingPoint.scale});")
                    .append("}")
                beforeMovingPoint = movingPoint
            }
            this.append("}")
                .append("#$type-$id {")
                .append("animation-name: move-$id;")
                .append("animation-duration: $duration;")
                .append("animation-iteration-count: 1;")
                .append("animation-fill-mode: forwards;")
                .append("}")
        }

        private fun StringBuilder.reverseFlipped(
            id: Long,
            movingPoints: List<MovingPoint>,
            flippedWith: Double,
            duration: String
        ) {
            this.append("@keyframes reverse-flip-$id {")
            var beforeMovingPoint = movingPoints.first()
            movingPoints.forEach { movingPoint ->
                if (beforeMovingPoint.scale != movingPoint.scale) {
                    this.append("${min(100.0, beforeMovingPoint.percentage + 0.01)}% {")
                        .append("transform-origin: ${flippedWith}px 0px;")
                        .append("transform: scaleX(${movingPoint.scale});")
                        .append("}")
                }
                this.append("${movingPoint.percentage}% {")
                    .append("transform-origin: ${flippedWith}px 0px;")
                    .append("transform: scaleX(${movingPoint.scale});")
                    .append("}")
                beforeMovingPoint = movingPoint
            }
            this.append("}")
                .append("#contributions-wrap-$id, #level-tag-wrap-$id, #level-wrap-$id {")
                .append("animation-name: reverse-flip-$id;")
                .append("animation-duration: $duration;")
                .append("animation-iteration-count: 1;")
                .append("animation-fill-mode: forwards;")
                .append("}")
        }

        private fun getMovingPoints(speed: Int): List<MovingPoint> {
            val movingPoints = mutableListOf<MovingPoint>()
            var currentY = Random.nextInt(30, 80)
            var currentX = Random.nextInt(10, 90)
            val startAngle = (Random.nextDouble() * 10).toInt()
            val startScale = when (Random.nextInt(0, 2) - 1) {
                0 -> 1
                else -> -1
            }
            var animationPercentage = 0.0

            movingPoints.add(
                MovingPoint(
                    animationPercentage,
                    currentY,
                    currentX,
                    startAngle,
                    startScale
                )
            )

            while (animationPercentage < 100.0) {
                animationPercentage += Random.nextInt(2, 6)
                animationPercentage = min(100.0, animationPercentage)
                val nextY =
                    Random.nextInt(max(20, min(79, currentY - speed)), min(80, currentY + speed))
                val nextX =
                    Random.nextInt(max(10, min(79, currentX - speed)), min(80, currentX + speed))
                val nextAngle = (atan2(
                    currentY.toDouble() - nextY.toDouble(),
                    currentX.toDouble() - nextX.toDouble()
                )).toInt()
                val nextScale = when (nextX > currentX) {
                    true -> 1
                    false -> -1
                }

                movingPoints.add(
                    MovingPoint(
                        animationPercentage,
                        nextY,
                        nextX,
                        nextAngle,
                        nextScale
                    )
                )

                currentY = nextY
                currentX = nextX
            }
            return movingPoints
        }

        private fun Long.toSvg(levelStartX: Double, xIncrease: Double): String {
            return this.toSvgWithY(-1.0, levelStartX, xIncrease)
        }

        private fun Long.toSvgWithY(startY: Double, startX: Double, xIncrease: Double): String {
            val level = this.toString()
            var currentX = startX
            val builder = StringBuilder()
            level.withIndex().forEach {
                val index = it.index
                val number = it.value.digitToInt()
                val numberSvg = numberSvgs[number]

                builder.append("<g id=\"level$index\" transform=\"translate($currentX, $startY)\">")
                    .append(numberSvg)
                    .append("</g>")

                currentX += xIncrease
            }
            return builder.toString()
        }
    }

    private data class MovingPoint(
        val percentage: Double,
        val y: Int,
        val x: Int,
        val angle: Int,
        val scale: Int,
    )
}
