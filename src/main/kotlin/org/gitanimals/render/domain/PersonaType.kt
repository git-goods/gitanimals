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

    FIG(0.2) {
        override fun load(persona: Persona): String {
            check(persona.id != null) { "Save persona first before call load()" }

            return figSvg.replace("*{act}", act(persona.id))
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
    }
    ;

    init {
        require(weight in 0.01..1.0) { "PersonaType's weight should be between 0.01 to 1.0" }
    }

    abstract fun load(persona: Persona): String

    protected abstract fun act(id: Long): String

    companion object {

        private val maxWeight = lazy {
            var maxWeight = 0
            entries.forEach { personaType ->
                maxWeight += (personaType.weight * 100).toInt()
            }
            maxWeight
        }.value

        private val personas = lazy {
            val weightedPersonas = mutableListOf<PersonaType>()
            entries.forEach { personaType ->
                repeat((personaType.weight * 100).toInt()) {
                    weightedPersonas.add(personaType)
                }
            }
            weightedPersonas
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
                val nextY = random.nextInt(max(10, currentY - speed), min(80, currentY + speed))
                val nextX = random.nextInt(max(10, currentX - speed), min(80, currentX + speed))
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
