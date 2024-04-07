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

        private val largeTextWidth = listOf(
            29.375 to "A",
            25.5 to "B",
            29.75 to "C",
            25.5 to "D",
            21.25 to "E",
            21.25 to "F",
            29.75 to "G",
            29.75 to "H",
            17.0 to "I",
            17.0 to "J",
            29.75 to "K",
            21.25 to "L",
            38.25 to "M",
            29.75 to "N",
            29.75 to "O",
            25.5 to "P",
            38.25 to "Q",
            25.5 to "R",
            21.25 to "S",
            25.5 to "T",
            25.5 to "U",
            29.75 to "V",
            51.0 to "W",
            25.5 to "X",
            25.5 to "Y",
            21.25 to "Z"
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
                val charWidth = when (char == '-') {
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
