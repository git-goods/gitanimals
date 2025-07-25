package org.gitanimals.core

import java.text.DecimalFormat
import kotlin.math.atan2
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

enum class PersonaType(val weight: Double, private var dropRate: String? = null) {
    GOOSE(1.0) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_SUNGLASSES(0.05) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseSunglassesSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_KOTLIN(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseKotlinSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_JAVA(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseJavaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_JS(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseJsSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_NODE(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseNodeSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_SWIFT(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseSwiftSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_LINUX(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseLinuxSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    GOOSE_SPRING(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val goose = gooseSpringSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(goose)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("goose", id, 20, "180s", 7, 33.0)
            .toString()
    },

    LITTLE_CHICK(0.9) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_SUNGLASSES(0.4) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickSunglassesSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_KOTLIN(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickKotlinSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_JAVA(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickJavaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_JS(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickJsSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_NODE(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickNodeSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_SWIFT(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickSwiftSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_LINUX(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickLinuxSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    LITTLE_CHICK_SPRING(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickSpringSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },
    LITTLE_CHICK_SANTA(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickSantaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },
    LITTLE_CHICK_TUBE(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            val littleChick = littleChickTubeSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )

            return StringBuilder()
                .append(littleChick)
                .toString()
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("little-chick", id, 40, "180s", 2, 16.0)
            .toString()
    },

    PENGUIN(0.5) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 6, 22.5)
                .toString()
    },

    PENGUIN_SUNGLASSES(0.2) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinSunglassesSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 6, 22.5)
                .toString()
    },

    PENGUIN_KOTLIN(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinKotlinSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_JAVA(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinJavaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_JS(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinJsSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_NODE(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinNodeSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_SWIFT(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinSwiftSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_LINUX(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinLinuxSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PENGUIN_SPRING(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return penguinSpringSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-4 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("penguin", id, 10, "180s", 10, 22.5)
                .toString()
    },

    PIG(0.2) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_SUNGLASSES(0.08) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigSunglassesSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_KOTLIN(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigKotlinSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_JAVA(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigJavaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_JS(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigJsSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_NODE(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigNodeSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_SWIFT(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigSwiftSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_LINUX(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigLinuxSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_SPRING(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigSpringSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    PIG_COLLABORATOR(0.0) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return pigCollaboratorSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (56 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fig", id, 5, "180s", 10, 60.5)
                .toString()
    },

    SLIME_RED(0.1) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeRedSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_KOTLIN(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeRedKotlinSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_JAVA(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeRedJavaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_JS(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeRedJsSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_NODE(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeRedNodeSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_SWIFT(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeRedSwiftSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_RED_LINUX(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeRedLinuxSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_BLUE(0.1) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeBlueSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    SLIME_GREEN(0.1) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimeGreenSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },

    FLAMINGO(0.05) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return flamingoSvg.replace("*{position}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (32 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String {
            val x = Random.nextInt(25, 75)
            val y = Random.nextInt(0, 50)
            val scale = 1
            return "translate(${x}%, ${y}%) scaleX($scale)"
        }
    },

    TEN_MM(0.000) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return tenmmSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-2 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (26 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("tenmm", id, 15, "180s", 5, 28.5)
                .toString()
    },

    GOBLIN(0.06) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return goblinSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6.5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (13 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("goblin", id, 15, "180s", 5, 14.5)
                .toString()
    },

    GOBLIN_BAG(0.03) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return goblinBagSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6.5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (13 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("goblin-bag", id, 15, "180s", 5, 14.5)
                .toString()
    },

    BBIBBI(0.000) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return bbibbiSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1.5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (27 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("bbibbi", id, 15, "180s", 5, 31.5)
                .toString()
    },

    CAT(0.1) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return catSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    CHEESE_CAT(0.04) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return cheeseCatSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    CHEESE_CAT_COLLABORATOR(0.0) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return cheeseCatCollaboratorSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    GALCHI_CAT(0.06) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return galchiCatSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    WHITE_CAT(0.04) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return whiteCatSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    WHITE_CAT_COLLABORATOR(0.00) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return whiteCatCollaboratorSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("cat", id, 15, "180s", 5, 17.5)
                .toString()
    },

    FISH_MAN(0.002) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return fishManSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fishman", id, 15, "180s", 5, 16.5)
                .toString()
    },
    FISH_MAN_GLASSES(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return fishManGlassesSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("fishman", id, 15, "180s", 5, 16.5)
                .toString()
    },
    QUOKKA(0.3) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return quokkaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (6 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("quokka", id, 40, "180s", 5, 10.0)
                .toString()
    },
    QUOKKA_LEAF(0.1) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return quokkaLeafSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (6 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("quokka", id, 40, "180s", 5, 10.0)
                .toString()
    },
    QUOKKA_SUNGLASSES(0.05) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return quokkaSunglassesSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (6 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("quokka", id, 40, "180s", 5, 10.0)
                .toString()
    },
    MOLE(0.3) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return moleSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (8.5 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("mole", id, 40, "180s", 5, 14.0)
                .toString()
    },
    MOLE_GRASS(0.1) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return moleGrassSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (8.5 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("mole", id, 40, "180s", 5, 14.0)
                .toString()
    },
    RABBIT(0.9) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return rabbitSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (6 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("rabbit", id, 40, "180s", 5, 10.0)
                .toString()
    },
    RABBIT_BROWN_RUDOLPH(0.007) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return rabbitBrownRudolphSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (6 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("rabbit", id, 40, "180s", 5, 10.0)
                .toString()
    },
    RABBIT_COLLABORATOR(0.0) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return rabbitCollaboratorSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (6 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("rabbit", id, 40, "180s", 5, 10.0)
                .toString()
    },
    RABBIT_TUBE(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return rabbitTubeSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-9 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (6 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("rabbit", id, 40, "180s", 5, 10.0)
                .toString()
    },

    DESSERT_FOX(0.05) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return dessertFoxSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-3 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (23 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("dessert-fox", id, 40, "180s", 5, 26.0)
                .toString()
    },
    DESSERT_FOX_COLLABORATOR(0.0) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return dessertFoxCollaboratorSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-3 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (23 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("dessert-fox", id, 40, "180s", 5, 26.0)
                .toString()
    },
    DESSERT_FOX_RUDOLPH(0.005) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return dessertFoxRudolphSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-3 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (23 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("dessert-fox", id, 40, "180s", 5, 28.0)
                .toString()
    },
    SLOTH(0.7) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slothSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("sloth", id, 5, "180s", 5, 16.5)
                .toString()
    },
    SLOTH_KING(0.05) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slothKingSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("sloth", id, 5, "180s", 5, 16.5)
                .toString()
    },
    SLOTH_SUNGLASSES(0.06) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slothSunglassesSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("sloth", id, 5, "180s", 5, 16.5)
                .toString()
    },
    TURTLE(0.03) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return turtleSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (29 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("turtle", id, 5, "180s", 5, 33.5)
                .toString()
    },
    GHOST(0.05) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return ghostSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1.8 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (23 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("ghost", id, 20, "180s", 7, 26.0)
            .toString()
    },
    GHOST_KING(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return ghostKingSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1.8 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (23 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("ghost", id, 20, "180s", 7, 26.0)
            .toString()
    },
    GHOST_COLLABORATOR(0.0) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return ghostCollaboratorSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-1.8 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (23 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("ghost", id, 20, "180s", 7, 26.0)
            .toString()
    },
    SCREAM(0.005) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return screamSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("scream", id, 10, "180s", 5, 17.5)
                .toString()
    },
    SCREAM_GHOST(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return screamGhostSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("scream", id, 10, "180s", 5, 17.5)
                .toString()
    },
    SLIME_PUMPKIN_1(0.08) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimePumpkin1Svg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },
    SLIME_PUMPKIN_2(0.08) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return slimePumpkin2Svg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("slime", id, 15, "180s", 5, 21.0)
                .toString()
    },
    HAMSTER(0.8) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return hamsterSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("hamster", id, 5, "1000s", 5, 21.0)
                .toString()
    },
    HAMSTER_SPRING(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return hamsterSpringSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("hamster", id, 5, "1000s", 5, 21.0)
                .toString()
    },
    HAMSTER_JAVA(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return hamsterJavaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("hamster", id, 5, "1000s", 5, 21.0)
                .toString()
    },
    HAMSTER_KOTLIN(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return hamsterKotlinSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("hamster", id, 5, "1000s", 5, 21.0)
                .toString()
    },
    HAMSTER_JS(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return hamsterJsSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("hamster", id, 5, "1000s", 5, 21.0)
                .toString()
    },
    HAMSTER_SANTA(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return hamsterSantaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("hamster", id, 5, "1000s", 5, 21.0)
                .toString()
    },
    SNOWMAN(0.005) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return snowmanSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-6 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (15 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("snowman", id, 5, "1000s", 5, 17.0)
                .toString()
    },
    SNOWMAN_MELT(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return snowmanMeltSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("snowman", id, 5, "1000s", 5, 21.0)
                .toString()
    },
    MALTESE(0.02) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return malteseSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (8.5 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("maltese", id, 40, "180s", 5, 12.0)
                .toString()
    },
    MALTESE_KING(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return malteseKingSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (8.5 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("maltese", id, 40, "180s", 5, 12.0)
                .toString()
    },
    HAMSTER_COLLABORATOR(0.0) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return hamsterCollaboratorSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("hamster", id, 5, "1000s", 5, 21.0)
                .toString()
    },
    HAMSTER_TUBE(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return hamsterTubeSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (17 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("hamster", id, 5, "1000s", 5, 21.0)
                .toString()
    },

    MALTESE_COLLABORATOR(0.0) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return malteseCollaboratorSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (8.5 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("maltese", id, 40, "180s", 5, 12.0)
                .toString()
    },

    UNICORN(0.001) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return unicornSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-8 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (8.5 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("unicorn", id, 40, "180s", 5, 12.0)
                .toString()
    },

    SHIBA(0.3) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return shibaSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("shiba", id, 20, "180s", 5, 18.0)
                .toString()
    },

    SHIBA_KING(0.01) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return shibaKingSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + (-1 * (level.toString().length))).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String =
            StringBuilder().moveRandomly("shiba", id, 20, "180s", 5, 18.0)
                .toString()
    },

    CAPYBARA(0.8) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return capybaraSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + -1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("capybara", id, 20, "180s", 7, 21.0)
            .toString()
    },

    CAPYBARA_CARROT(0.6) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return capybaraCarrotSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + -1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("capybara", id, 20, "180s", 7, 21.0)
            .toString()
    },

    CAPYBARA_SWIM(0.4) {
        override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
            return capybaraSwimSvg.replace("*{act}", act(animationId))
                .replace("*{id}", animationId.toString())
                .replace("*{leg-iteration-count}", "360")
                .replace("*{level}", level.toSvg(14.0, 2.0))
                .replace(
                    "*{levelx}",
                    (-5 + -1 * (level.toString().length)).toString()
                )
                .replace("*{username}", name.toSvg(14.0, 25.0))
                .replace(
                    "*{usernamex}",
                    (20 + (-3 * name.length)).toString()
                )
        }

        override fun act(id: Long, flippedWidth: Double): String = StringBuilder()
            .moveRandomly("capybara", id, 20, "180s", 7, 21.0)
            .toString()
    },
    ;

    init {
        require(weight in 0.000..1.0) { "PersonaType's weight should be between 0.000 to 1.0" }
    }

    fun getDropRate(): String {
        return this.dropRate ?: loadDropRate()
    }

    private fun loadDropRate(): String {
        val allPersonaCount = personas.filter { it.weight > 0.0 }.size
        val personaCount = (weight * 1000).toInt()

        val dropRateTemp = (personaCount.toDouble() / allPersonaCount.toDouble()) * 100.0
        this.dropRate = if (dropRateTemp < 1.0) {
            "${dropRateFormat.format(dropRateTemp)}%"
        } else {
            "${dropRateTemp.toInt()}%"
        }
        return dropRate!!
    }

    fun load(
        name: String,
        contributionCount: Long,
        animationId: Long,
        level: Long,
        mode: Mode
    ): String =
        loadSvg(name, animationId, level, mode)
            .drawDisplayOptions(mode, contributionCount)

    protected abstract fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String

    protected abstract fun act(id: Long, flippedWidth: Double = 0.0): String

    protected fun String.drawDisplayOptions(
        mode: Mode,
        contributionCount: Long,
    ): String {
        return when (mode) {
            Mode.LINE -> {
                this.replace("*{username-tag-display}", "none")
                    .replace("*{username-display}", "none")
                    .replace(
                        "*{contributionx}",
                        (12.8 + (-1 * (contributionCount.toString().length))).toString()
                    )
                    .replace(
                        "*{contribution}",
                        contributionCount.toSvg(0.0, 2.0)
                    ).replace("*{contribution-display}", "default")
                    .replace("*{level-tag-display}", "default")
                    .replace("*{level-display}", "default")
            }

            Mode.LINE_NO_CONTRIBUTION -> {
                this.replace("*{username-tag-display}", "none")
                    .replace("*{username-display}", "none")
                    .replace("*{contribution-display}", "none")
                    .replace("*{level-tag-display}", "default")
                    .replace("*{level-display}", "default")
            }

            Mode.NAME_WITH_LEVEL -> {
                this.replace("*{username-tag-display}", "none")
                    .replace("*{username-display}", "default")
                    .replace("*{level-tag-display}", "none")
                    .replace("*{contribution-display}", "none")
                    .replace("*{level-display}", "default")
            }

            Mode.NONE -> {
                this.replace("*{username-tag-display}", "none")
                    .replace("*{username-display}", "none")
                    .replace("*{contribution-display}", "none")
                    .replace("*{level-tag-display}", "none")
                    .replace("*{level-display}", "none")
            }

            else -> {
                this.replace("*{username-tag-display}", "none")
                    .replace("*{username-display}", "none")
                    .replace("*{contribution-display}", "none")
                    .replace("*{level-tag-display}", "none")
                    .replace("*{level-display}", "default")
            }
        }
    }

    companion object {
        private val dropRateFormat = DecimalFormat("#.##")

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
                .append("#contributions-wrap-$id, #level-tag-wrap-$id, #level-wrap-$id, #username-tag-wrap-$id, #username-wrap-$id {")
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

        private fun String.toSvg(nameStartX: Double, xIncrease: Double): String {
            return this.toSvgWithY(-1.0, nameStartX, xIncrease)
        }

        private fun String.toSvgWithY(startY: Double, startX: Double, xIncrease: Double): String {
            var currentX = startX
            val builder = StringBuilder()

            this.withIndex().forEach {
                val index = it.index
                val textSvg = largeTextSvgs[it.value.toString()]

                builder.append("<g id=\"level$index\" transform=\"translate($currentX, $startY)\">")
                    .append(textSvg)
                    .append("</g>")

                currentX += xIncrease
            }
            return builder.toString()
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
