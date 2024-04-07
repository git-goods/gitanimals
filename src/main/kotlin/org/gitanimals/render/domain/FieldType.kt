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
    SNOWY_FIELD {
        override fun loadComponent(name: String, commit: Long, visit: Long): String {
            return snowyFieldSvg.replace(NAME_FIX, name.uppercase().toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 111.0, 4.0))
                .replace(VISIT_FIX, visit.toSvg("visit", 75.0, 4.0))
        }

        override fun fillBackground(): String {
            return "  <rect width=\"600\" height=\"300\" rx=\"5\" fill=\"#A3D9FF\"/>\n" +
                    "  <rect x=\"182\" y=\"131.586\" width=\"69.5924\" height=\"168.414\" fill=\"white\"/>\n" +
                    "  <rect y=\"246\" width=\"72\" height=\"54\" fill=\"white\"/>\n" +
                    "  <rect x=\"321.185\" y=\"131.586\" width=\"69.5924\" height=\"168.414\" fill=\"white\"/>\n" +
                    "  <rect x=\"251.592\" y=\"167.079\" width=\"69.5924\" height=\"132.921\" fill=\"white\"/>\n" +
                    "  <rect x=\"390.777\" y=\"201.179\" width=\"109.956\" height=\"98.8212\" fill=\"white\"/>\n" +
                    "  <rect x=\"72\" y=\"201.179\" width=\"109.956\" height=\"98.8212\" fill=\"white\"/>\n" +
                    "  <rect width=\"34.7962\" height=\"103.693\" transform=\"matrix(-1 0 0 1 535.529 97.4862)\" fill=\"white\"/>\n" +
                    "  <rect width=\"34.7962\" height=\"34.7962\" transform=\"matrix(-1 0 0 1 500.733 62.69)\" fill=\"white\"/>\n" +
                    "  <rect x=\"535.529\" y=\"300\" width=\"34.7962\" height=\"63.3291\" transform=\"rotate(180 535.529 300)\"\n" +
                    "    fill=\"white\"/>\n" +
                    "  <rect width=\"64.025\" height=\"202.514\" transform=\"matrix(-1 0 0 1 599.554 97.4862)\" fill=\"white\"/>\n"
        }

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\"/>"
        }
    },
    ;

    abstract fun loadComponent(name: String, commit: Long, visit: Long): String

    abstract fun fillBackground(): String

    abstract fun drawBorder(): String

    private companion object {
        private const val NAME_FIX = "*{username}"
        private const val COMMIT_FIX = "*{commit-count}"
        private const val VISIT_FIX = "*{visit-count}"

        private val largeTextWidth = mapOf(
            "A" to 29.375,
            "B" to 25.5,
            "C" to 29.75,
            "D" to 25.5,
            "E" to 21.25,
            "F" to 21.25,
            "G" to 29.75,
            "H" to 29.75,
            "I" to 17.0,
            "J" to 17.0,
            "K" to 29.75,
            "L" to 21.25,
            "M" to 38.25,
            "N" to 29.75,
            "O" to 29.75,
            "P" to 25.5,
            "Q" to 38.25,
            "R" to 25.5,
            "S" to 21.25,
            "T" to 25.5,
            "U" to 25.5,
            "V" to 29.75,
            "W" to 51.0,
            "X" to 25.5,
            "Y" to 25.5,
            "Z" to 21.25,
            "-" to 7.5,
            "0" to 18.89,
            "1" to 11.33,
            "2" to 22.67,
            "3" to 18.89,
            "4" to 26.44,
            "5" to 18.89,
            "6" to 22.67,
            "7" to 18.89,
            "8" to 26.44,
            "9" to 22.67,
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
                val largeTextSvg = largeTextSvgs[char.toString()]
                val index = char - 'A'

                val charWidth = largeTextWidth[char.toString()]
                    ?: throw IllegalArgumentException("Cannot find matched charWidth by \"$char\"")

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
