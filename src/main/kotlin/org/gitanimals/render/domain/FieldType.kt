package org.gitanimals.render.domain

enum class FieldType {

    WHITE_FIELD {
        override fun loadComponent(name: String, commit: Long): String {
            return whiteFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String =
            "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" fill=\"white\"/>"

        override fun drawBorder(): String =
            "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\" fill=\"none\"/>"
    },
    SNOWY_FIELD {
        override fun loadComponent(name: String, commit: Long): String {
            return snowyFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
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
    CARROT_AND_COIN {
        override fun loadComponent(name: String, commit: Long): String {
            return carrotAndCoinSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String {
            return """                    
                <rect x="0.5" y="0.5" width="599" height="299" rx="4.5" fill="url(#paint0_linear_2065_7051)"/>
                <defs>
                <linearGradient id="paint0_linear_2065_7051" x1="300" y1="0" x2="300" y2="300" gradientUnits="userSpaceOnUse">
                <stop stop-color="#1C3E6C"/>
                <stop offset="1" stop-color="#27589C"/>
                </linearGradient>
                </defs>
                
                                <style>
                      @keyframes carrot-move {
                      0% {
                      transform: translate(367px, -10px);
                      }
                      50% {
                      transform: translate(367px, 10px);
                      }
                      100% {
                      transform: translate(367px, -10px);
                      }
                      }

                      @keyframes coin-move {
                      0% {
                      transform: translate(58px, 146px);
                      }
                      50% {
                      transform: translate(58px, 156px);
                      }
                      100% {
                      transform: translate(58px, 146px);
                      }
                      }

                      #coin {
                      animation-name:coin-move;
                      animation-duration:5s;
                      animation-iteration-count:infinite;
                      animation-timing-function: ease-in-out;
                      }

                      #carrot {
                      animation-name:carrot-move;
                      animation-duration:5s;
                      animation-iteration-count:infinite;
                      animation-timing-function: ease-in-out;
                      }
                    </style>

                    <g id="carrot">
                    <rect width="51.7233" height="77.585" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 127.99 73.9789)" fill="#FF6F0F"/>
                    <rect width="64.6542" height="103.447" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 173.279 102.089)" fill="#FF6F0F"/>
                    <rect width="64.6542" height="77.585" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 173.006 120.387)" fill="#FF6F0F"/>
                    <rect width="51.7233" height="51.7233" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 100.709 64.4205)" fill="#FF6F0F"/>
                    <rect width="25.8617" height="25.8617" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 64.4102 45.5774)" fill="#FF6F0F"/>
                    <rect width="25.8617" height="51.7233" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 172.714 138.656)" fill="#6DB33F"/>
                    <rect width="25.8617" height="25.8617" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 172.419 156.93)" fill="#6DB33F"/>
                    <rect width="38.7925" height="12.9308" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 172.151 175.222)" fill="#6DB33F"/>
                    <rect width="12.9308" height="25.8617" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 145.969 92.514)" fill="black" fill-opacity="0.1"/>
                    <rect width="12.9308" height="38.7925" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 109.402 91.9628)" fill="black" fill-opacity="0.1"/>
                    <rect width="12.9308" height="25.8617" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 91.6957 55.1279)" fill="black" fill-opacity="0.1"/>
                    <rect width="12.9308" height="25.8617" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 55.1077 54.5543)" fill="black" fill-opacity="0.1"/>
                    <rect width="12.9308" height="38.7925" transform="matrix(-0.696251 -0.717798 -0.717798 0.696251 127.137 128.812)" fill="black" fill-opacity="0.1"/>
                    </g>

                    <g id="coin">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M23.8939 31.8907L54.3852 14.0306L58.1303 20.4243L67.4745 14.9509L71.5071 21.8355L79.1293 17.3708L85.7549 28.6823L91.9032 25.081L109.475 55.0805L103.327 58.6818L109.952 69.993L102.33 74.4577L106.364 81.3434L97.0193 86.8168L100.764 93.2098L70.2726 111.07L66.5277 104.677L56.9373 110.294L52.9045 103.409L45.2823 107.874L38.6564 96.562L32.5084 100.163L14.9363 70.1635L21.0843 66.5624L14.4591 55.2517L22.0814 50.787L18.0483 43.9016L27.6387 38.2841L23.8939 31.8907Z" fill="#FDDA1E"/>
                    <rect x="86.4931" y="28.2502" width="6.26948" height="35.0521" transform="rotate(-30.3594 86.4931 28.2502)" fill="#E5B000"/>
                    <rect x="38.3089" y="97.0968" width="14.2488" height="13.1089" transform="rotate(-30.3594 38.3089 97.0968)" fill="#E5B000"/>
                    <rect x="29.5266" y="95.6351" width="20.8033" height="5.69953" transform="rotate(-30.3594 29.5266 95.6351)" fill="#E5B000"/>
                    <rect x="38.0213" y="96.6052" width="17.0986" height="5.69953" transform="rotate(-30.3594 38.0213 96.6052)" fill="#FDDA1E"/>
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M68.8063 36.9598L52.577 46.466L56.7537 53.5966L56.7533 53.5968L60.7865 60.4822L58.0814 62.0667L61.2501 67.4763L59.5287 68.4846L64.4258 76.8451L72.2946 72.236L69.1259 66.8265L73.7981 64.0898L69.765 57.2043L72.47 55.6199L68.2933 48.4893L73.7034 45.3204L68.8063 36.9598Z" fill="#E5B000"/>
                    <rect x="50.3544" y="99.6182" width="11.1141" height="13.1089" transform="rotate(-30.3594 50.3544 99.6182)" fill="#E5B000"/>
                    <rect x="65.5195" y="102.955" width="12.254" height="9.11924" transform="rotate(-30.3594 65.5195 102.955)" fill="#E5B000"/>
                    <rect x="97.8757" y="61.2152" width="6.26948" height="13.6789" transform="rotate(-30.3594 97.8757 61.2152)" fill="#E5B000"/>
                    <rect x="96.9207" y="77.6271" width="6.26948" height="8.54929" transform="rotate(-30.3594 96.9207 77.6271)" fill="#E5B000"/>
                    <rect x="49.0399" y="52.8306" width="6.26948" height="28.4976" transform="rotate(-30.3594 49.0399 52.8306)" fill="#F0A029"/>
                    <rect x="70.9667" y="40.6472" width="6.26948" height="28.4976" transform="rotate(-30.3594 70.9667 40.6472)" fill="#F0A029"/>
                    <rect x="27.0247" y="50.2036" width="6.26948" height="13.9638" transform="rotate(-30.3594 27.0247 50.2036)" fill="#F0A029"/>
                    <rect x="51.4247" y="44.498" width="6.26948" height="6.55445" transform="rotate(-30.3594 51.4247 44.498)" fill="#F0A029"/>
                    <rect x="68.8528" y="74.2515" width="6.26948" height="6.55445" transform="rotate(-30.3594 68.8528 74.2515)" fill="#F0A029"/>
                    <rect x="53.5216" y="35.6742" width="6.26948" height="8.83426" transform="rotate(-30.3594 53.5216 35.6742)" fill="#F0A029"/>
                    <rect x="76.4229" y="74.7717" width="6.26948" height="8.54929" transform="rotate(-30.3594 76.4229 74.7717)" fill="#F0A029"/>
                    <rect x="62.2442" y="38.1603" width="6.26948" height="6.55445" transform="rotate(-30.3594 62.2442 38.1603)" fill="#F0A029"/>
                    <rect x="81.682" y="67.3981" width="6.26948" height="6.55445" transform="rotate(-30.3594 81.682 67.3981)" fill="#F0A029"/>
                    <rect x="79.96" y="68.4065" width="6.26948" height="6.55445" transform="rotate(-30.3594 79.96 68.4065)" fill="#F0A029"/>
                    <rect x="48.4853" y="86.8424" width="6.26948" height="13.9638" transform="rotate(-30.3594 48.4853 86.8424)" fill="#F0A029"/>
                    <rect x="28.9771" y="41.1328" width="6.26948" height="8.54929" transform="rotate(-30.3594 28.9771 41.1328)" fill="#F0A029"/>
                    <rect x="30.9302" y="32.0626" width="6.26948" height="8.54929" transform="rotate(-30.3594 30.9302 32.0626)" fill="#F0A029"/>
                    <rect x="69.2434" y="97.4724" width="6.26948" height="8.54929" transform="rotate(-30.3594 69.2434 97.4724)" fill="#F0A029"/>
                    <rect x="57.3087" y="19.5851" width="11.1141" height="5.9845" transform="rotate(-30.3594 57.3087 19.5851)" fill="#F0A029"/>
                    <rect x="69.2102" y="21.8611" width="11.1141" height="4.8446" transform="rotate(-30.3594 69.2102 21.8611)" fill="#F0A029"/>
                    <rect x="34.1795" y="25.2061" width="23.3681" height="6.83943" transform="rotate(-30.3594 34.1795 25.2061)" fill="#F0A029"/>
                    <rect x="78.9737" y="101.68" width="23.3681" height="6.83943" transform="rotate(-30.3594 78.9737 101.68)" fill="#F0A029"/>
                    <rect x="28.9185" y="65.277" width="6.26948" height="28.4976" transform="rotate(-30.3594 28.9185 65.277)" fill="#F0A029"/>
                    <rect x="52.659" y="103.554" width="17.0986" height="3.13474" transform="rotate(-30.3594 52.659 103.554)" fill="#FDDA1E"/>
                    <rect x="60.9532" y="95.7224" width="6.26948" height="8.54929" transform="rotate(-30.3594 60.9532 95.7224)" fill="#F0A029"/>
                    </g>
            """.trimIndent()
        }

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#3A79E5\"/>"
        }
    },
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
