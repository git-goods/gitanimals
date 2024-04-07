package org.gitanimals.render.domain

enum class FieldType {

    WHITE_FIELD {
        override fun loadComponent(name: String, commit: Long, visit: Long): String {
            return whiteFieldSvg.replace(NAME_FIX, name.uppercase().toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 111.0, 4.0))
                .replace(VISIT_FIX, visit.toSvg("visit", 75.0, 4.0))
        }

        override fun fillBackground(): String =
            "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" fill=\"white\"/>"

        override fun drawBorder(): String =
            "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\" fill=\"none\"/>"
    },
    ;

    abstract fun loadComponent(name: String, commit: Long, visit: Long): String

    abstract fun fillBackground(): String

    abstract fun drawBorder(): String

    private companion object {
        private const val NAME_FIX = "*{username}"
        private const val COMMIT_FIX = "*{commit-count}"
        private const val VISIT_FIX = "*{visit-count}"

        private val largeTextWidth = listOf(
            17.5 to "A",
            15.0 to "B",
            17.5 to "C",
            15.0 to "D",
            12.5 to "E",
            12.5 to "F",
            17.5 to "G",
            17.5 to "H",
            10.0 to "I",
            10.0 to "J",
            17.5 to "K",
            12.5 to "L",
            22.5 to "M",
            17.5 to "N",
            17.5 to "O",
            15.0 to "P",
            22.5 to "Q",
            15.0 to "R",
            12.5 to "S",
            15.0 to "T",
            15.0 to "U",
            17.5 to "V",
            30.0 to "W",
            15.0 to "X",
            15.0 to "Y",
            12.5 to "Z"
        )

        private val mediumNumberWidth = listOf(
            8.89,
            5.33,
            10.67,
            8.89,
            12.44,
            8.89,
            10.67,
            8.89,
            12.44,
            10.67
        )

        private fun String.toSvg(startX: Double, xIncrease: Double): String {
            val builder = StringBuilder()
            var currentX = startX
            this.forEach { char ->
                val index = char - 'A'
                val largeTextSvg = when (char == '-') {
                    true -> largeHypensSvg
                    false -> largeTextSvgs[index]
                }
                val charWidth = when(char == '-') {
                    true -> 7.5
                    false -> largeTextWidth[index].first
                }

                builder.append("<g id=\"name$index\" transform=\"translate($currentX)\">")
                    .append(largeTextSvg)
                    .append("</g>")

                currentX += xIncrease + charWidth
            }
            return builder.toString()
        }

        private fun Long.toSvg(id: String, startX: Double, xIncrease: Double): String {
            val builder = StringBuilder()
            var currentX = startX
            this.toString().forEach { char ->
                val index = char.digitToInt()
                val mediumNumberSvg = mediumNumberSvgs[index]
                builder.append("<g id=\"$id$index\" transform=\"translate($currentX)\">")
                    .append(mediumNumberSvg)
                    .append("</g>")
                currentX += xIncrease + mediumNumberWidth[index]
            }
            return builder.toString()
        }
    }
}
