package org.gitanimals.render.domain

import kotlin.math.atan2
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

enum class PersonaType(private val weight: Double) {
    GOOSE(1.0) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    GOOSE_SUNGLASSES(0.05) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    GOOSE_KOTLIN(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    GOOSE_JAVA(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    GOOSE_JS(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    GOOSE_NODE(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    GOOSE_SWIFT(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    GOOSE_LINUX(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    GOOSE_SPRING(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("goose", id, 20, "180s", 7)
            .toString()
    },

    LITTLE_CHICK(0.9) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    LITTLE_CHICK_SUNGLASSES(0.4) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    LITTLE_CHICK_KOTLIN(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    LITTLE_CHICK_JAVA(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    LITTLE_CHICK_JS(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    LITTLE_CHICK_NODE(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    LITTLE_CHICK_SWIFT(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    LITTLE_CHICK_LINUX(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    LITTLE_CHICK_SPRING(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            .moveRandomly("little-chick", id, 40, "180s", 2)
            .toString()
    },

    PENGUIN(0.5) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 6)
                .toString()
    },

    PENGUIN_SUNGLASSES(0.2) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 6)
                .toString()
    },

    PENGUIN_KOTLIN(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10)
                .toString()
    },

    PENGUIN_JAVA(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10)
                .toString()
    },

    PENGUIN_JS(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10)
                .toString()
    },

    PENGUIN_NODE(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10)
                .toString()
    },

    PENGUIN_SWIFT(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10)
                .toString()
    },

    PENGUIN_LINUX(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10)
                .toString()
    },

    PENGUIN_SPRING(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10)
                .toString()
    },

    PIG(0.2) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    PIG_SUNGLASSES(0.08) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigSunglassesSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    PIG_KOTLIN(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigKotlinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    PIG_JAVA(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigJavaSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    PIG_JS(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigJsSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    PIG_NODE(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigNodeSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    PIG_SWIFT(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigSwiftSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    PIG_LINUX(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigLinuxSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    PIG_SPRING(0.01) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return pigSpringSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 10)
            .toString()
    },

    SLIME_RED(0.1) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeRedSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    SLIME_RED_KOTLIN(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeRedKotlinSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    SLIME_RED_JAVA(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeRedJavaSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    SLIME_RED_JS(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeRedJsSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    SLIME_RED_NODE(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeRedNodeSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    SLIME_RED_SWIFT(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeRedSwiftSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    SLIME_RED_LINUX(0.001) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeRedLinuxSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    SLIME_BLUE(0.1) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeBlueSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    SLIME_GREEN(0.1) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return slimeGreenSvg.replace("*{act}", act(persona.id))
                .replace("*{id}", persona.id.toString())
                .replace("*{level}", persona.level.value.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (persona.level.value.toString().length))).toString()
                )
        }

        override fun act(id: Long): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5)
                .toString()
    },

    FLAMINGO(0.05) {
        override fun loadSvg(user: User, persona: Persona, mode: Mode): String {
            check(persona.id != null) { "Save persona first before call load()" }

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
            val scale = when (Random.nextBoolean()) {
                true -> 1
                false -> -1
            }
            return "translate(${x}%, ${y}%) scaleX($scale)"
        }
    }
    ;

    init {
        require(weight in 0.001..1.0) { "PersonaType's weight should be between 0.01 to 1.0" }
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
        return if (mode == Mode.LINE) {
            this.replace(
                "*{contributionx}",
                (12 + (-1 * (user.contributionCount().toString().length))).toString()
            )
                .replace(
                    "*{contribution}",
                    user.contributionCount().toSvg(0.0, 2.0)
                ).replace("*{contribution-display}", "default")
        } else {
            this.replace("*{contribution-display}", "none")
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
        ): StringBuilder {
            var currentY = Random.nextInt(10, 90)
            var currentX = Random.nextInt(10, 90)
            var currentAngle = (Random.nextDouble() * 10).toInt()
            var currentScale = Random.nextInt(0, 2) - 1
            if (currentScale == 0) {
                currentScale++
            }
            this.append("@keyframes move-$id {")
                .append("0% {")
                .append("-webkit-transform:translate($currentY%, $currentX%) rotate(${currentAngle}deg) scaleX($currentScale);")
                .append("-ms-transform:translate($currentY%, $currentX%) rotate(${currentAngle}deg) scaleX($currentScale);")
                .append("-o-transform:translate($currentY%, $currentX%) rotate(${currentAngle}deg) scaleX($currentScale);")
                .append("-moz-transform:translate($currentY%, $currentX%) rotate(${currentAngle}deg) scaleX($currentScale);")
                .append("transform:translate($currentY%, $currentX%) rotate(${currentAngle}deg) scaleX($currentScale);")
                .append("}")
            var animationPercentage = 0.0
            while (animationPercentage < 100) {
                val beforeAnimationPercentage = animationPercentage
                animationPercentage += Random.nextInt(2, 6)
                val nextY =
                    Random.nextInt(max(10, min(79, currentY - speed)), min(80, currentY + speed))
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
                if (nextScale != currentScale) {
                    this.append("${min(100.0, beforeAnimationPercentage + 0.01)}% {")
                        .append("-webkit-transform: translate(${currentX - (personaWidth * nextScale)}%, ${currentY}%) rotate(${currentAngle}deg) scaleX($nextScale);")
                        .append("-ms-transform: translate(${currentX - (personaWidth * nextScale)}%, $currentY%) rotate(${currentAngle}deg) scaleX($nextScale);")
                        .append("-o-transform: translate(${currentX - (personaWidth * nextScale)}%, $currentY%) rotate(${currentAngle}deg) scaleX($nextScale);")
                        .append("-moz-transform: translate(${currentX - (personaWidth * nextScale)}%, $currentY%) rotate(${currentAngle}deg) scaleX($nextScale);")
                        .append("transform: translate(${{ currentX - (personaWidth * nextScale) }}%, $currentY%) rotate(${currentAngle}deg) scaleX($nextScale);")
                        .append("}")
                }
                this.append("${min(100.0, animationPercentage)}% {")
                    .append("-webkit-transform:translate($nextX%, $nextY%) rotate(${nextAngle}deg) scaleX($nextScale);")
                    .append("-ms-transform:translate($nextX%, $nextY%) rotate(${nextAngle}deg) scaleX($nextScale);")
                    .append("-o-transform:translate($nextX%, $nextY%) rotate(${nextAngle}deg) scaleX($nextScale);")
                    .append("-moz-transform:translate($nextX%, $nextY%) rotate(${nextAngle}deg) scaleX($nextScale);")
                    .append("transform:translate($nextX%, $nextY%) rotate(${nextAngle}deg) scaleX($nextScale);")
                    .append("}")
                currentY = nextY
                currentX = nextX
                currentAngle = nextAngle
                currentScale = nextScale
            }
            this.append("}")
                .append("#$type-$id {")
                .append("animation-name: move-$id;")
                .append("animation-duration: $duration;")
                .append("animation-iteration-count: 1;")
                .append("animation-fill-mode: forwards;")
                .append("}")
            return this
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
}
