package org.gitanimals.render.domain

import kotlin.math.atan2
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

enum class PersonaType {
    GOOSE {
        override fun load(persona: Persona): String {
            check(persona.id != null) {
                throw IllegalStateException("Save persona first before call load()")
            }

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
            .moveRandomly("goose", id, "180s", 15)
            .toString()
    },

    LITTLE_CHICK {
        override fun load(persona: Persona): String {
            check(persona.id != null) {
                throw IllegalStateException("Save persona first before call load()")
            }

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
            .moveRandomly("little-chick", id, "180s", 10)
            .toString()
    }
    ;

    abstract fun load(persona: Persona): String

    protected abstract fun act(id: Long): String

    private companion object {

        private fun StringBuilder.moveRandomly(
            type: String,
            id: Long,
            duration: String,
            width: Long,
        ): StringBuilder {
            val random = Random(id)
            var currentY = random.nextInt(10, 90)
            var currentX = random.nextInt(10, 90)
            val startAngle = (random.nextDouble() * 10).toInt()
            var scale = random.nextInt(0, 2) -1
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
                val nextY = random.nextInt(max(10, currentY - 23), min(80, currentY + 23))
                val nextX = random.nextInt(max(10, currentX - 23), min(80, currentX + 23))
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
                .append("animation-delay: 1s;")
                .append("animation-iteration-count: 1;")
                .append("animation-fill-mode: forwards;")
                .append("}")
            return this
        }

        private fun Long.toSvg(levelStartX: Double, xIncrese: Double): String {
            val level = this.toString()
            var currentX = levelStartX
            val builder = StringBuilder()
            level.withIndex().forEach {
                val index = it.index
                val number = it.value.digitToInt()
                val numberSvgs = numberSvgs[number]

                builder.append("<g id=\"level$index\" transform=\"translate($currentX)\">")
                    .append(numberSvgs)
                    .append("</g>")

                currentX += when (number) {
                    1 -> xIncrese - 0.4
                    3 -> xIncrese - 0.1
                    4 -> xIncrese + 0.1
                    5 -> xIncrese - 0.1
                    8 -> xIncrese + 0.4
                    else -> xIncrese
                }
            }
            return builder.toString()
        }
    }
}
