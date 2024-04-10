package org.gitanimals.render.domain

import kotlin.math.atan2
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

enum class PersonaType(private val weight: Double) {
    GOOSE(1.0) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("goose", id, 20, "180s", 15)
            .toString()
    },

    GOOSE_KOTLIN(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("goose", id, 20, "180s", 25)
            .toString()
    },

    GOOSE_JAVA(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("goose", id, 20, "180s", 25)
            .toString()
    },

    GOOSE_JS(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("goose", id, 20, "180s", 27)
            .toString()
    },

    GOOSE_NODE(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("goose", id, 20, "180s", 28)
            .toString()
    },

    GOOSE_SWIFT(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("goose", id, 20, "180s", 26)
            .toString()
    },

    GOOSE_LINUX(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("goose", id, 20, "180s", 25)
            .toString()
    },

    GOOSE_SPRING(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("goose", id, 20, "180s", 30)
            .toString()
    },

    LITTLE_CHICK(0.9) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("little-chick", id, 40, "180s", 10)
            .toString()
    },

    LITTLE_CHICK_KOTLIN(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("little-chick", id, 40, "180s", 13)
            .toString()
    },

    LITTLE_CHICK_JAVA(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("little-chick", id, 40, "180s", 13)
            .toString()
    },

    LITTLE_CHICK_JS(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("little-chick", id, 40, "180s", 13)
            .toString()
    },

    LITTLE_CHICK_NODE(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("little-chick", id, 40, "180s", 13)
            .toString()
    },

    LITTLE_CHICK_SWIFT(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("little-chick", id, 40, "180s", 13)
            .toString()
    },

    LITTLE_CHICK_LINUX(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("little-chick", id, 40, "180s", 13)
            .toString()
    },

    LITTLE_CHICK_SPRING(0.01) {
        override fun load(persona: Persona): String {
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
            .moveRandomly("little-chick", id, 40, "180s", 17)
            .toString()
    },

    PENGUIN(0.5) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 15)
                .toString()
    },

    PENGUIN_KOTLIN(0.01) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 25)
                .toString()
    },

    PENGUIN_JAVA(0.01) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 25)
                .toString()
    },

    PENGUIN_JS(0.01) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 25)
                .toString()
    },

    PENGUIN_NODE(0.01) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 25)
                .toString()
    },

    PENGUIN_SWIFT(0.01) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 25)
                .toString()
    },

    PENGUIN_LINUX(0.01) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 25)
                .toString()
    },

    PENGUIN_SPRING(0.01) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 25)
                .toString()
    },

    PIG(0.2) {
        override fun load(persona: Persona): String {
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

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 15)
            .toString()
    },

    PIG_KOTLIN(0.01) {
        override fun load(persona: Persona): String {
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

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 15)
            .toString()
    },

    PIG_JAVA(0.01) {
        override fun load(persona: Persona): String {
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

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 15)
            .toString()
    },

    PIG_JS(0.01) {
        override fun load(persona: Persona): String {
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

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 15)
            .toString()
    },

    PIG_NODE(0.01) {
        override fun load(persona: Persona): String {
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

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 15)
            .toString()
    },

    PIG_SWIFT(0.01) {
        override fun load(persona: Persona): String {
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

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 15)
            .toString()
    },

    PIG_LINUX(0.01) {
        override fun load(persona: Persona): String {
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

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 15)
            .toString()
    },

    PIG_SPRING(0.01) {
        override fun load(persona: Persona): String {
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

        override fun act(id: Long): String = StringBuilder().moveRandomly("fig", id, 5, "180s", 15)
            .toString()
    },

    SLIME_RED(0.1) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("slime", id, 15, "180s", 15)
                .toString()
    },

    SLIME_RED_KOTLIN(0.001) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("slime", id, 15, "180s", 15)
                .toString()
    },

    SLIME_RED_JAVA(0.001) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("slime", id, 15, "180s", 15)
                .toString()
    },

    SLIME_RED_JS(0.001) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("slime", id, 15, "180s", 15)
                .toString()
    },

    SLIME_RED_NODE(0.001) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("slime", id, 15, "180s", 15)
                .toString()
    },

    SLIME_BLUE(0.1) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("slime", id, 15, "180s", 15)
                .toString()
    },

    SLIME_GREEN(0.1) {
        override fun load(persona: Persona): String {
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
            StringBuilder().moveRandomly("slime", id, 15, "180s", 15)
                .toString()
    },
    ;

    init {
        require(weight in 0.001..1.0) { "PersonaType's weight should be between 0.01 to 1.0" }
    }

    abstract fun load(persona: Persona): String

    protected abstract fun act(id: Long): String

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
            width: Long,
        ): StringBuilder {
            val random = Random(id)
            var currentY = random.nextInt(10, 90)
            var currentX = random.nextInt(10, 90)
            val startAngle = (random.nextDouble() * 10).toInt()
            var scale = random.nextInt(0, 2) - 1
            if (scale == 0) {
                scale++
            }
            this.append("@keyframes move-$id {")
                .append("0% {")
                .append("-webkit-transform:translate($currentY%, $currentX%) rotate(${startAngle}deg) scaleX($scale);")
                .append("-ms-transform:translate($currentY%, $currentX%) rotate(${startAngle}deg) scaleX($scale);")
                .append("-o-transform:translate($currentY%, $currentX%) rotate(${startAngle}deg) scaleX($scale);")
                .append("-moz-transform:translate($currentY%, $currentX%) rotate(${startAngle}deg) scaleX($scale);")
                .append("transform:translate($currentY%, $currentX%) rotate(${startAngle}deg) scaleX($scale);")
                .append("}")
            var animationPercentage = 0.0
            while (animationPercentage < 100) {
                val beforeAnimationPercentage = animationPercentage
                animationPercentage += random.nextInt(2, 6)
                val nextY =
                    random.nextInt(max(10, min(79, currentY - speed)), min(80, currentY + speed))
                val nextX =
                    random.nextInt(max(10, min(79, currentX - speed)), min(80, currentX + speed))
                val angle = (atan2(
                    currentY.toDouble() - nextY.toDouble(),
                    currentX.toDouble() - nextX.toDouble()
                )).toInt()
                scale = when (nextX > currentX) {
                    true -> 1
                    false -> -1
                }
                this.append("${min(100.0, beforeAnimationPercentage + 0.0001)}% {")
                    .append("-webkit-transform: translate(${scale * (currentX + width)}, $currentY) scaleX($scale);")
                    .append("-ms-transform: translate(${scale * (currentX + width)}, $currentY) scaleX($scale);")
                    .append("-o-transform: translate(${scale * (currentX + width)}, $currentY) scaleX($scale);")
                    .append("-moz-transform: translate(${scale * (currentX + width)}, $currentY) scaleX($scale);")
                    .append("transform: translate(${scale * (currentX + width)}, $currentY) scaleX($scale);")
                    .append("}")
                    .append("${min(100.0, animationPercentage)}% {")
                    .append("-webkit-transform:translate($nextY%, $nextX%) rotate(${angle}deg) scaleX($scale);")
                    .append("-ms-transform:translate($nextY%, $nextX%) rotate(${angle}deg) scaleX($scale);")
                    .append("-o-transform:translate($nextY%, $nextX%) rotate(${angle}deg) scaleX($scale);")
                    .append("-moz-transform:translate($nextY%, $nextX%) rotate(${angle}deg) scaleX($scale);")
                    .append("transform:translate($nextY%, $nextX%) rotate(${angle}deg) scaleX($scale);")
                    .append("}")
                currentY = nextY
                currentX = nextX
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
            val level = this.toString()
            var currentX = levelStartX
            val builder = StringBuilder()
            level.withIndex().forEach {
                val index = it.index
                val number = it.value.digitToInt()
                val numberSvg = numberSvgs[number]

                builder.append("<g id=\"level$index\" transform=\"translate($currentX, -1)\">")
                    .append(numberSvg)
                    .append("</g>")

                currentX += xIncrease
            }
            return builder.toString()
        }
    }
}
