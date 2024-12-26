package org.gitanimals.guild.domain

enum class GuildFarmType {

    LOGO_SHOWING {
        override fun loadComponent(name: String, commit: Long): String {
            return dummyGuildFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String =
            """
                <rect x="0.5" y="0.5" width="599" height="299" rx="4.5" fill="#1E1E1E"/>
                $logoShowingFieldSvg
            """

        override fun drawBorder(): String =
            "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\" fill=\"none\"/>"
    }
    ;

    abstract fun loadComponent(name: String, commit: Long): String

    abstract fun fillBackground(): String

    abstract fun drawBorder(): String

    private companion object {
        private const val NAME_FIX = "*{username}"
        private const val COMMIT_FIX = "*{commit-count}"
        private const val VISIT_FIX = "*{visit-count}"

        private val largeTextWidth = mapOf(
            "A" to 20.0,
            "B" to 20.0,
            "C" to 20.0,
            "D" to 20.0,
            "E" to 20.0,
            "F" to 20.0,
            "G" to 20.0,
            "H" to 20.0,
            "I" to 14.0,
            "J" to 20.0,
            "K" to 20.0,
            "L" to 20.0,
            "M" to 23.0,
            "N" to 23.0,
            "O" to 20.0,
            "P" to 20.0,
            "Q" to 20.0,
            "R" to 20.0,
            "S" to 20.0,
            "T" to 20.0,
            "U" to 20.0,
            "V" to 20.0,
            "W" to 23.0,
            "X" to 20.0,
            "Y" to 20.0,
            "Z" to 20.0,
            "-" to 20.0,
            "a" to 20.0,
            "b" to 20.0,
            "c" to 20.0,
            "d" to 20.0,
            "e" to 20.0,
            "f" to 20.0,
            "g" to 20.0,
            "h" to 20.0,
            "i" to 20.0,
            "j" to 17.0,
            "k" to 20.0,
            "l" to 20.0,
            "m" to 23.0,
            "n" to 20.0,
            "o" to 20.0,
            "p" to 20.0,
            "q" to 20.0,
            "r" to 20.0,
            "s" to 20.0,
            "t" to 20.0,
            "u" to 20.0,
            "v" to 20.0,
            "w" to 23.0,
            "x" to 20.0,
            "y" to 23.0,
            "z" to 20.0,
            "0" to 20.0,
            "1" to 17.0,
            "2" to 20.0,
            "3" to 20.0,
            "4" to 23.0,
            "5" to 20.0,
            "6" to 20.0,
            "7" to 20.0,
            "8" to 20.0,
            "9" to 20.0,
        )

        private val mediumNumberWidth = listOf(
            11.0,
            9.0,
            11.0,
            11.0,
            12.0,
            11.0,
            11.0,
            11.0,
            11.0,
            11.0,
        )

        private fun String.toSvg(startX: Double, xIncrease: Double): String {
            val builder = StringBuilder()
            var currentX = startX
            this.forEach { char ->
                val largeTextSvg = largeTextSvgs[char.toString()]
                val index = char - 'A'

                val charWidth = largeTextWidth[char.toString()]
                    ?: throw IllegalArgumentException("Cannot find matched charWidth by \"$char\"")

                builder.append("<g id=\"name$index\" transform=\"translate($currentX, 2)\">")
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
                builder.append("<g id=\"$id$index\" transform=\"translate($currentX, 0)\">")
                    .append(mediumNumberSvg)
                    .append("</g>")
                currentX += xIncrease + mediumNumberWidth[index]
            }
            return builder.toString()
        }
    }
}
