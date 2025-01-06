package org.gitanimals.core

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
    HALLOWEEN_FIELD {
        override fun loadComponent(name: String, commit: Long): String {
            return halloweenFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String {
            return "  <rect width=\"600\" height=\"300\" rx=\"5\" fill=\"#FF6F0F\"/>\n" +
                    "  <rect x=\"182\" y=\"131.586\" width=\"69.5924\" height=\"168.414\" fill=\"#242427\"/>\n" +
                    "  <rect y=\"246\" width=\"72\" height=\"54\" fill=\"#242427\"/>\n" +
                    "  <rect x=\"321.185\" y=\"131.586\" width=\"69.5924\" height=\"168.414\" fill=\"#242427\"/>\n" +
                    "  <rect x=\"251.592\" y=\"167.079\" width=\"69.5924\" height=\"132.921\" fill=\"#242427\"/>\n" +
                    "  <rect x=\"390.777\" y=\"201.179\" width=\"109.956\" height=\"98.8212\" fill=\"#242427\"/>\n" +
                    "  <rect x=\"72\" y=\"201.179\" width=\"109.956\" height=\"98.8212\" fill=\"#242427\"/>\n" +
                    "  <rect width=\"34.7962\" height=\"103.693\" transform=\"matrix(-1 0 0 1 535.529 97.4862)\" fill=\"#242427\"/>\n" +
                    "  <rect width=\"34.7962\" height=\"34.7962\" transform=\"matrix(-1 0 0 1 500.733 62.69)\" fill=\"#242427\"/>\n" +
                    "  <rect x=\"535.529\" y=\"300\" width=\"34.7962\" height=\"63.3291\" transform=\"rotate(180 535.529 300)\"\n" +
                    "    fill=\"#242427\"/>\n" +
                    "  <rect width=\"64.025\" height=\"202.514\" transform=\"matrix(-1 0 0 1 599.554 97.4862)\" fill=\"#242427\"/>\n"
        }

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\"/>"
        }
    },
    GRASS_FIELD {
        override fun loadComponent(name: String, commit: Long): String {
            return grassFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String = """
            <g clip-path="url(#clip0_1803_26254)">
            <rect width="600" height="300" rx="5" fill="#00894D"/>
            <rect width="16.5" height="2.33333" transform="matrix(-1 0 0 1 419.25 236)" fill="#015530" fill-opacity="0.6"/>
            <rect width="16.5" height="2.33333" transform="matrix(-1 0 0 1 422 238.333)" fill="#015530" fill-opacity="0.6"/>
            <path d="M416.5 222H405.5V224.333H402.75V231.333H405.5V233.667H416.5V231.333H419.25V224.333H416.5V222Z" fill="#FF6B56"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 422 226.667)" fill="#611848"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 419.25 231.333)" fill="#611848"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 405.5 231.333)" fill="#611848"/>
            <rect width="2.75" height="7" transform="matrix(-1 0 0 1 402.75 226.667)" fill="#611848"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 408.25 226.667)" fill="#F4F3EC"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 416.5 224.333)" fill="#F4F3EC"/>
            <rect x="402.75" y="233.667" width="13.75" height="2.33333" fill="#611848"/>
            <rect x="408.25" y="236" width="5.5" height="2.33333" fill="#F4F3EC"/>
            <rect width="8.25" height="2.33333" transform="matrix(1 -7.41769e-08 -1.03034e-07 -1 391.75 245.333)" fill="#611848"/>
            <path d="M391.75 245.333H400V247.666H402.75V250H394.5V247.666H391.75V245.333Z" fill="#015530" fill-opacity="0.6"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 397.25 245.333)" fill="#F4F3EC"/>
            <path d="M402.75 243L389 243L389 240.667L391.75 240.667L391.75 238.333L400 238.333L400 240.667L402.75 240.667L402.75 243Z" fill="#FF6B56"/>
            <rect width="16.5" height="2.33333" transform="matrix(-1 0 0 1 93.25 264)" fill="#015530" fill-opacity="0.6"/>
            <rect width="16.5" height="2.33333" transform="matrix(-1 0 0 1 96 266.333)" fill="#015530" fill-opacity="0.6"/>
            <path d="M90.5 250H79.5V252.333H76.75V259.333H79.5V261.667H90.5V259.333H93.25V252.333H90.5V250Z" fill="#FF6B56"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 96 254.667)" fill="#611848"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 93.25 259.333)" fill="#611848"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 79.5 259.333)" fill="#611848"/>
            <rect width="2.75" height="7" transform="matrix(-1 0 0 1 76.75 254.667)" fill="#611848"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 82.25 254.667)" fill="#F4F3EC"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 90.5 252.333)" fill="#F4F3EC"/>
            <rect x="76.75" y="261.667" width="13.75" height="2.33333" fill="#611848"/>
            <rect x="82.25" y="264" width="5.5" height="2.33333" fill="#F4F3EC"/>
            <rect width="8.25" height="2.33333" transform="matrix(1 -7.41769e-08 -1.03034e-07 -1 65.75 273.333)" fill="#611848"/>
            <path d="M65.75 273.333H74V275.666H76.75V278H68.5V275.666H65.75V273.333Z" fill="#015530" fill-opacity="0.6"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 71.25 273.333)" fill="#F4F3EC"/>
            <path d="M76.75 271L63 271L63 268.667L65.75 268.667L65.75 266.333L74 266.333L74 268.667L76.75 268.667L76.75 271Z" fill="#FF6B56"/>
            <rect width="16.5" height="2.33333" transform="matrix(-1 0 0 1 259.25 86)" fill="#015530" fill-opacity="0.6"/>
            <rect width="16.5" height="2.33333" transform="matrix(-1 0 0 1 262 88.3335)" fill="#015530" fill-opacity="0.6"/>
            <path d="M256.5 72H245.5V74.3333H242.75V81.3333H245.5V83.6667H256.5V81.3333H259.25V74.3333H256.5V72Z" fill="#FF6B56"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 262 76.667)" fill="#611848"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 259.25 81.3335)" fill="#611848"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 245.5 81.3335)" fill="#611848"/>
            <rect width="2.75" height="7" transform="matrix(-1 0 0 1 242.75 76.667)" fill="#611848"/>
            <rect width="2.75" height="4.66667" transform="matrix(-1 0 0 1 248.25 76.667)" fill="#F4F3EC"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 256.5 74.3335)" fill="#F4F3EC"/>
            <rect x="242.75" y="83.667" width="13.75" height="2.33333" fill="#611848"/>
            <rect x="248.25" y="86" width="5.5" height="2.33333" fill="#F4F3EC"/>
            <rect width="8.25" height="2.33333" transform="matrix(1 -7.41769e-08 -1.03034e-07 -1 231.75 95.333)" fill="#611848"/>
            <path d="M231.75 95.333H240V97.6663H242.75V99.9997H234.5V97.6663H231.75V95.333Z" fill="#015530" fill-opacity="0.6"/>
            <rect width="2.75" height="2.33333" transform="matrix(-1 0 0 1 237.25 95.333)" fill="#F4F3EC"/>
            <path d="M242.75 93L229 93L229 90.6667L231.75 90.6667L231.75 88.3333L240 88.3333L240 90.6667L242.75 90.6667L242.75 93Z" fill="#FF6B56"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M65.5 147H63V157H60.5V168.25H58V165.75H55.5V168.25H53V165.75H50.5V170.75H53V173.25H55.5V170.75H58H60.5V173.25H63V170.75H65.5V173.25H68V175.75H70.5H73V178.25H75.5H78V180.75H80.5V178.25H83V175.75H85.5H88V170.75H90.5V173.25H93H95.5V165.75H93V163.25H90.5V158.25H88V160.75H85.5V153.25H83V155.75H80.5H78V153.25H75.5V158.25H73V155.75H70.5V163.25H68V168.25H65.5V147ZM70.5 163.25H73V165.75H70.5V163.25ZM93 165.75V168.25H90.5V165.75H93ZM80.5 163.25V158.25H83V163.25H80.5ZM58 154.5H55.5V159.5H53V163.25H55.5V162H58V154.5ZM39.25 162H41.75V164.5H44.25V167H46.75V173.25H44.25V170.75H41.75H39.25H36.75H34.25V164.5H36.75V167H39.25V162ZM63 175.75H65.5V178.25H63V175.75ZM65.5 178.25H68H70.5V180.75H68V183.25H65.5V178.25ZM98 168.25H100.5V165.75H103V163.25H105.5V168.25H108V165.75H110.5V170.75H108H105.5H103H100.5V173.25H98V168.25ZM20.5 199.5H18V204.5H20.5V207H23V204.5H25.5H28V207H30.5V204.5H33V207H35.5V209.5H38H40.5V212H43H45.5V214.5H48V212H50.5V209.5H53H55.5V204.5H58V207H60.5H63V199.5H60.5V197H58V192H55.5V194.5H53V187H50.5V189.5H48H45.5V187H43V192H40.5V189.5H38V197H35.5V202H33V188.25H30.5V190.75H28V202H25.5V199.5H23V202H20.5V199.5ZM38 199.5H40.5V197H38V199.5ZM60.5 199.5H58V202H60.5V199.5ZM23 188.25H25.5V195.75H23V197H20.5V193.25H23V188.25ZM33 209.5H30.5V212H33V217H35.5V214.5H38V212H35.5H33V209.5ZM50.5 197H48V192H50.5V197ZM68 202H65.5V207H68V204.5H70.5H73H75.5H78V199.5H75.5V202H73V197H70.5V199.5H68V202Z" fill="#015530" fill-opacity="0.6"/>
            <rect x="30.5" y="200.75" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="28" y="195.75" width="2.5" height="11.25" fill="#015530" fill-opacity="0.6"/>
            <rect x="78" y="164.5" width="2.5" height="7.5" fill="#015530" fill-opacity="0.6"/>
            <rect x="75.5" y="168.25" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="80.5" y="168.25" width="2.5" height="6.25" fill="#015530" fill-opacity="0.6"/>
            <rect x="39.25" y="167" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="56.75" y="173.25" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="56.75" y="180.75" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="56.75" y="177" width="3.75" height="3.75" fill="#E7BEAA"/>
            <rect x="53" y="177" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="60.5" y="177" width="3.75" height="3.75" fill="#F4F3EC"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M229.5 241H227V251H224.5V262.25H222V259.75H219.5V262.25H217V259.75H214.5V264.75H217V267.25H219.5V264.75H222H224.5V267.25H227V264.75H229.5V267.25H232V269.75H234.5H237V272.25H239.5H242V274.75H244.5V272.25H247V269.75H249.5H252V264.75H254.5V267.25H257H259.5V259.75H257V257.25H254.5V252.25H252V254.75H249.5V247.25H247V249.75H244.5H242V247.25H239.5V252.25H237V249.75H234.5V257.25H232V262.25H229.5V241ZM234.5 257.25H237V259.75H234.5V257.25ZM257 259.75V262.25H254.5V259.75H257ZM244.5 257.25V252.25H247V257.25H244.5ZM222 248.5H219.5V253.5H217V257.25H219.5V256H222V248.5ZM203.25 256H205.75V258.5H208.25V261H210.75V267.25H208.25V264.75H205.75H203.25H200.75H198.25V258.5H200.75V261H203.25V256ZM227 269.75H229.5V272.25H227V269.75ZM229.5 272.25H232H234.5V274.75H232V277.25H229.5V272.25ZM262 262.25H264.5V259.75H267V257.25H269.5V262.25H272V259.75H274.5V264.75H272H269.5H267H264.5V267.25H262V262.25ZM184.5 293.5H182V298.5H184.5V301H187V298.5H189.5H192V301H194.5V298.5H197V301H199.5V303.5H202H204.5V306H207H209.5V308.5H212V306H214.5V303.5H217H219.5V298.5H222V301H224.5H227V293.5H224.5V291H222V286H219.5V288.5H217V281H214.5V283.5H212H209.5V281H207V286H204.5V283.5H202V291H199.5V296H197V282.25H194.5V284.75H192V296H189.5V293.5H187V296H184.5V293.5ZM202 293.5H204.5V291H202V293.5ZM224.5 293.5H222V296H224.5V293.5ZM187 282.25H189.5V289.75H187V291H184.5V287.25H187V282.25ZM197 303.5H194.5V306H197V311H199.5V308.5H202V306H199.5H197V303.5ZM214.5 291H212V286H214.5V291ZM232 296H229.5V301H232V298.5H234.5H237H239.5H242V293.5H239.5V296H237V291H234.5V293.5H232V296Z" fill="#015530" fill-opacity="0.6"/>
            <rect x="194.5" y="294.75" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="192" y="289.75" width="2.5" height="11.25" fill="#015530" fill-opacity="0.6"/>
            <rect x="242" y="258.5" width="2.5" height="7.5" fill="#015530" fill-opacity="0.6"/>
            <rect x="239.5" y="262.25" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="244.5" y="262.25" width="2.5" height="6.25" fill="#015530" fill-opacity="0.6"/>
            <rect x="203.25" y="261" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="220.75" y="267.25" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="220.75" y="274.75" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="220.75" y="271" width="3.75" height="3.75" fill="#E7BEAA"/>
            <rect x="217" y="271" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="224.5" y="271" width="3.75" height="3.75" fill="#F4F3EC"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M439.5 69H437V79H434.5V90.25H432V87.75H429.5V90.25H427V87.75H424.5V92.75H427V95.25H429.5V92.75H432H434.5V95.25H437V92.75H439.5V95.25H442V97.75H444.5H447V100.25H449.5H452V102.75H454.5V100.25H457V97.75H459.5H462V92.75H464.5V95.25H467H469.5V87.75H467V85.25H464.5V80.25H462V82.75H459.5V75.25H457V77.75H454.5H452V75.25H449.5V80.25H447V77.75H444.5V85.25H442V90.25H439.5V69ZM444.5 85.25H447V87.75H444.5V85.25ZM467 87.75V90.25H464.5V87.75H467ZM454.5 85.25V80.25H457V85.25H454.5ZM432 76.5H429.5V81.5H427V85.25H429.5V84H432V76.5ZM413.25 84H415.75V86.5H418.25V89H420.75V95.25H418.25V92.75H415.75H413.25H410.75H408.25V86.5H410.75V89H413.25V84ZM437 97.75H439.5V100.25H437V97.75ZM439.5 100.25H442H444.5V102.75H442V105.25H439.5V100.25ZM472 90.25H474.5V87.75H477V85.25H479.5V90.25H482V87.75H484.5V92.75H482H479.5H477H474.5V95.25H472V90.25ZM394.5 121.5H392V126.5H394.5V129H397V126.5H399.5H402V129H404.5V126.5H407V129H409.5V131.5H412H414.5V134H417H419.5V136.5H422V134H424.5V131.5H427H429.5V126.5H432V129H434.5H437V121.5H434.5V119H432V114H429.5V116.5H427V109H424.5V111.5H422H419.5V109H417V114H414.5V111.5H412V119H409.5V124H407V110.25H404.5V112.75H402V124H399.5V121.5H397V124H394.5V121.5ZM412 121.5H414.5V119H412V121.5ZM434.5 121.5H432V124H434.5V121.5ZM397 110.25H399.5V117.75H397V119H394.5V115.25H397V110.25ZM407 131.5H404.5V134H407V139H409.5V136.5H412V134H409.5H407V131.5ZM424.5 119H422V114H424.5V119ZM442 124H439.5V129H442V126.5H444.5H447H449.5H452V121.5H449.5V124H447V119H444.5V121.5H442V124Z" fill="#015530" fill-opacity="0.6"/>
            <rect x="404.5" y="122.75" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="402" y="117.75" width="2.5" height="11.25" fill="#015530" fill-opacity="0.6"/>
            <rect x="452" y="86.5" width="2.5" height="7.5" fill="#015530" fill-opacity="0.6"/>
            <rect x="449.5" y="90.25" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="454.5" y="90.25" width="2.5" height="6.25" fill="#015530" fill-opacity="0.6"/>
            <rect x="413.25" y="89" width="2.5" height="3.75" fill="#015530" fill-opacity="0.6"/>
            <rect x="430.75" y="95.25" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="430.75" y="102.75" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="430.75" y="99" width="3.75" height="3.75" fill="#E7BEAA"/>
            <rect x="427" y="99" width="3.75" height="3.75" fill="#F4F3EC"/>
            <rect x="434.5" y="99" width="3.75" height="3.75" fill="#F4F3EC"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M162 12.5H164.5V20H167V17.5H169.5V22.5H172V25H169.5V27.5H172V25H174.5V32.5H169.5V30H167V35H162V37.5H159.5V40H157V37.5H152V35H147V32.5H144.5V30H142V32.5H139.5V30H134.5V32.5H132V30H129.5V25H132V27.5H134.5V25H137V27.5H139.5V22.5H142V17.5H144.5V27.5H147V22.5H149.5V25H152V22.5H149.5V15H152V17.5H154.5V12.5H157V15H162V12.5ZM159.5 17.5V22.5H162V17.5H159.5Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M144.5 35H142V37.5H144.5V42.5H147V40H149.5V37.5H144.5V35Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M179.5 27.5H177V32.5H179.5V30H189.5V25H187V27.5H184.5V22.5H182V25H179.5V27.5Z" fill="#015530" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M510 89.5L507.5 89.5L507.5 82L505 82L505 84.5L502.5 84.5L502.5 79.5L500 79.5L500 77L502.5 77L502.5 74.5L500 74.5L500 77L497.5 77L497.5 69.5L502.5 69.5L502.5 72L505 72L505 67L510 67L510 64.5L512.5 64.5L512.5 62L515 62L515 64.5L520 64.5L520 67L525 67L525 69.5L527.5 69.5L527.5 72L530 72L530 69.5L532.5 69.5L532.5 72L537.5 72L537.5 69.5L540 69.5L540 72L542.5 72L542.5 77L540 77L540 74.5L537.5 74.5L537.5 77L535 77L535 74.5L532.5 74.5L532.5 79.5L530 79.5L530 84.5L527.5 84.5L527.5 74.5L525 74.5L525 79.5L522.5 79.5L522.5 77L520 77L520 79.5L522.5 79.5L522.5 87L520 87L520 84.5L517.5 84.5L517.5 89.5L515 89.5L515 87L510 87L510 89.5ZM512.5 84.5L512.5 79.5L510 79.5L510 84.5L512.5 84.5Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M527.5 67L530 67L530 64.5L527.5 64.5L527.5 59.5L525 59.5L525 62L522.5 62L522.5 64.5L527.5 64.5L527.5 67Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M492.5 74.5L495 74.5L495 69.5L492.5 69.5L492.5 72L482.5 72L482.5 77L485 77L485 74.5L487.5 74.5L487.5 79.5L490 79.5L490 77L492.5 77L492.5 74.5Z" fill="#015530" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M472 75.5L469.5 75.5L469.5 68L467 68L467 70.5L464.5 70.5L464.5 65.5L462 65.5L462 63L464.5 63L464.5 60.5L462 60.5L462 63L459.5 63L459.5 55.5L464.5 55.5L464.5 58L467 58L467 53L472 53L472 50.5L474.5 50.5L474.5 48L477 48L477 50.5L482 50.5L482 53L487 53L487 55.5L489.5 55.5L489.5 58L492 58L492 55.5L494.5 55.5L494.5 58L499.5 58L499.5 55.5L502 55.5L502 58L504.5 58L504.5 63L502 63L502 60.5L499.5 60.5L499.5 63L497 63L497 60.5L494.5 60.5L494.5 65.5L492 65.5L492 70.5L489.5 70.5L489.5 60.5L487 60.5L487 65.5L484.5 65.5L484.5 63L482 63L482 65.5L484.5 65.5L484.5 73L482 73L482 70.5L479.5 70.5L479.5 75.5L477 75.5L477 73L472 73L472 75.5ZM474.5 70.5L474.5 65.5L472 65.5L472 70.5L474.5 70.5Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M489.5 53L492 53L492 50.5L489.5 50.5L489.5 45.5L487 45.5L487 48L484.5 48L484.5 50.5L489.5 50.5L489.5 53Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M454.5 60.5L457 60.5L457 55.5L454.5 55.5L454.5 58L444.5 58L444.5 63L447 63L447 60.5L449.5 60.5L449.5 65.5L452 65.5L452 63L454.5 63L454.5 60.5Z" fill="#015530" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M389 119.5L386.5 119.5L386.5 112L384 112L384 114.5L381.5 114.5L381.5 109.5L379 109.5L379 107L381.5 107L381.5 104.5L379 104.5L379 107L376.5 107L376.5 99.5L381.5 99.5L381.5 102L384 102L384 97L389 97L389 94.5L391.5 94.5L391.5 92L394 92L394 94.5L399 94.5L399 97L404 97L404 99.5L406.5 99.5L406.5 102L409 102L409 99.5L411.5 99.5L411.5 102L416.5 102L416.5 99.5L419 99.5L419 102L421.5 102L421.5 107L419 107L419 104.5L416.5 104.5L416.5 107L414 107L414 104.5L411.5 104.5L411.5 109.5L409 109.5L409 114.5L406.5 114.5L406.5 104.5L404 104.5L404 109.5L401.5 109.5L401.5 107L399 107L399 109.5L401.5 109.5L401.5 117L399 117L399 114.5L396.5 114.5L396.5 119.5L394 119.5L394 117L389 117L389 119.5ZM391.5 114.5L391.5 109.5L389 109.5L389 114.5L391.5 114.5Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M406.5 97L409 97L409 94.5L406.5 94.5L406.5 89.5L404 89.5L404 92L401.5 92L401.5 94.5L406.5 94.5L406.5 97Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M371.5 104.5L374 104.5L374 99.5L371.5 99.5L371.5 102L361.5 102L361.5 107L364 107L364 104.5L366.5 104.5L366.5 109.5L369 109.5L369 107L371.5 107L371.5 104.5Z" fill="#015530" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M510 215.667L507.5 215.667L507.5 222.667L505 222.667L505 220.334L502.5 220.334L502.5 225L500 225L500 227.334L502.5 227.334L502.5 229.667L500 229.667L500 227.334L497.5 227.334L497.5 234.334L502.5 234.334L502.5 232L505 232L505 236.667L510 236.667L510 239L512.5 239L512.5 241.334L515 241.334L515 239L520 239L520 236.667L525 236.667L525 234.334L527.5 234.334L527.5 232L530 232L530 234.334L532.5 234.334L532.5 232L537.5 232L537.5 234.334L540 234.334L540 232L542.5 232L542.5 227.334L540 227.334L540 229.667L537.5 229.667L537.5 227.334L535 227.334L535 229.667L532.5 229.667L532.5 225L530 225L530 220.334L527.5 220.334L527.5 229.667L525 229.667L525 225L522.5 225L522.5 227.334L520 227.334L520 225L522.5 225L522.5 218L520 218L520 220.334L517.5 220.334L517.5 215.667L515 215.667L515 218L510 218L510 215.667ZM512.5 220.334L512.5 225L510 225L510 220.334L512.5 220.334Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M527.5 236.667L530 236.667L530 239L527.5 239L527.5 243.667L525 243.667L525 241.334L522.5 241.334L522.5 239L527.5 239L527.5 236.667Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M492.5 229.667L495 229.667L495 234.334L492.5 234.334L492.5 232L482.5 232L482.5 227.334L485 227.334L485 229.667L487.5 229.667L487.5 225L490 225L490 227.334L492.5 227.334L492.5 229.667Z" fill="#015530" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M162 115.667L159.5 115.667L159.5 122.667L157 122.667L157 120.334L154.5 120.334L154.5 125L152 125L152 127.334L154.5 127.334L154.5 129.667L152 129.667L152 127.334L149.5 127.334L149.5 134.334L154.5 134.334L154.5 132L157 132L157 136.667L162 136.667L162 139L164.5 139L164.5 141.334L167 141.334L167 139L172 139L172 136.667L177 136.667L177 134.334L179.5 134.334L179.5 132L182 132L182 134.334L184.5 134.334L184.5 132L189.5 132L189.5 134.334L192 134.334L192 132L194.5 132L194.5 127.334L192 127.334L192 129.667L189.5 129.667L189.5 127.334L187 127.334L187 129.667L184.5 129.667L184.5 125L182 125L182 120.334L179.5 120.334L179.5 129.667L177 129.667L177 125L174.5 125L174.5 127.334L172 127.334L172 125L174.5 125L174.5 118L172 118L172 120.334L169.5 120.334L169.5 115.667L167 115.667L167 118L162 118L162 115.667ZM164.5 120.334L164.5 125L162 125L162 120.334L164.5 120.334Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M179.5 136.667L182 136.667L182 139L179.5 139L179.5 143.667L177 143.667L177 141.334L174.5 141.334L174.5 139L179.5 139L179.5 136.667Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M144.5 129.667L147 129.667L147 134.334L144.5 134.334L144.5 132L134.5 132L134.5 127.334L137 127.334L137 129.667L139.5 129.667L139.5 125L142 125L142 127.334L144.5 127.334L144.5 129.667Z" fill="#015530" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M585 134.667L582.5 134.667L582.5 141.667L580 141.667L580 139.334L577.5 139.334L577.5 144L575 144L575 146.334L577.5 146.334L577.5 148.667L575 148.667L575 146.334L572.5 146.334L572.5 153.334L577.5 153.334L577.5 151L580 151L580 155.667L585 155.667L585 158L587.5 158L587.5 160.334L590 160.334L590 158L595 158L595 155.667L600 155.667L600 153.334L602.5 153.334L602.5 151L605 151L605 153.334L607.5 153.334L607.5 151L612.5 151L612.5 153.334L615 153.334L615 151L617.5 151L617.5 146.334L615 146.334L615 148.667L612.5 148.667L612.5 146.334L610 146.334L610 148.667L607.5 148.667L607.5 144L605 144L605 139.334L602.5 139.334L602.5 148.667L600 148.667L600 144L597.5 144L597.5 146.334L595 146.334L595 144L597.5 144L597.5 137L595 137L595 139.334L592.5 139.334L592.5 134.667L590 134.667L590 137L585 137L585 134.667ZM587.5 139.334L587.5 144L585 144L585 139.334L587.5 139.334Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M602.5 155.667L605 155.667L605 158L602.5 158L602.5 162.667L600 162.667L600 160.334L597.5 160.334L597.5 158L602.5 158L602.5 155.667Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M567.5 148.667L570 148.667L570 153.334L567.5 153.334L567.5 151L557.5 151L557.5 146.334L560 146.334L560 148.667L562.5 148.667L562.5 144L565 144L565 146.334L567.5 146.334L567.5 148.667Z" fill="#015530" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M257 195.667L254.5 195.667L254.5 202.667L252 202.667L252 200.334L249.5 200.334L249.5 205L247 205L247 207.334L249.5 207.334L249.5 209.667L247 209.667L247 207.334L244.5 207.334L244.5 214.334L249.5 214.334L249.5 212L252 212L252 216.667L257 216.667L257 219L259.5 219L259.5 221.334L262 221.334L262 219L267 219L267 216.667L272 216.667L272 214.334L274.5 214.334L274.5 212L277 212L277 214.334L279.5 214.334L279.5 212L284.5 212L284.5 214.334L287 214.334L287 212L289.5 212L289.5 207.334L287 207.334L287 209.667L284.5 209.667L284.5 207.334L282 207.334L282 209.667L279.5 209.667L279.5 205L277 205L277 200.334L274.5 200.334L274.5 209.667L272 209.667L272 205L269.5 205L269.5 207.334L267 207.334L267 205L269.5 205L269.5 198L267 198L267 200.334L264.5 200.334L264.5 195.667L262 195.667L262 198L257 198L257 195.667ZM259.5 200.334L259.5 205L257 205L257 200.334L259.5 200.334Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M274.5 216.667L277 216.667L277 219L274.5 219L274.5 223.667L272 223.667L272 221.334L269.5 221.334L269.5 219L274.5 219L274.5 216.667Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M239.5 209.667L242 209.667L242 214.334L239.5 214.334L239.5 212L229.5 212L229.5 207.334L232 207.334L232 209.667L234.5 209.667L234.5 205L237 205L237 207.334L239.5 207.334L239.5 209.667Z" fill="#015530" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M277 187.667L274.5 187.667L274.5 194.667L272 194.667L272 192.334L269.5 192.334L269.5 197L267 197L267 199.334L269.5 199.334L269.5 201.667L267 201.667L267 199.334L264.5 199.334L264.5 206.334L269.5 206.334L269.5 204L272 204L272 208.667L277 208.667L277 211L279.5 211L279.5 213.334L282 213.334L282 211L287 211L287 208.667L292 208.667L292 206.334L294.5 206.334L294.5 204L297 204L297 206.334L299.5 206.334L299.5 204L304.5 204L304.5 206.334L307 206.334L307 204L309.5 204L309.5 199.334L307 199.334L307 201.667L304.5 201.667L304.5 199.334L302 199.334L302 201.667L299.5 201.667L299.5 197L297 197L297 192.334L294.5 192.334L294.5 201.667L292 201.667L292 197L289.5 197L289.5 199.334L287 199.334L287 197L289.5 197L289.5 190L287 190L287 192.334L284.5 192.334L284.5 187.667L282 187.667L282 190L277 190L277 187.667ZM279.5 192.334L279.5 197L277 197L277 192.334L279.5 192.334Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M294.5 208.667L297 208.667L297 211L294.5 211L294.5 215.667L292 215.667L292 213.334L289.5 213.334L289.5 211L294.5 211L294.5 208.667Z" fill="#015530" fill-opacity="0.6"/>
            <path d="M259.5 201.667L262 201.667L262 206.334L259.5 206.334L259.5 204L249.5 204L249.5 199.334L252 199.334L252 201.667L254.5 201.667L254.5 197L257 197L257 199.334L259.5 199.334L259.5 201.667Z" fill="#015530" fill-opacity="0.6"/>
            </g>
            <defs>
            <clipPath id="clip0_1803_26254">
            <rect width="600" height="300" rx="5" fill="white"/>
            </clipPath>
            </defs>
        """.trimIndent()

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#00894D\"/>"
        }
    },
    SNOW_HOUSE_FIELD {
        override fun loadComponent(name: String, commit: Long): String {
            return snowHouseFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String = snowHouseBackgroundSvg

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\"/>"
        }
    },
    SNOW_GRASS_FIELD {
        override fun loadComponent(name: String, commit: Long): String {
            return snowGrassFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String = snowGrassBackgroundSvg

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\"/>"
        }
    },
    GRASS_CHRISTMAS_TREE_FIELD {
        override fun loadComponent(name: String, commit: Long): String {
            return grassChristmasTreeFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String = grassChristmasTreeBackgroundSvg

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#00894D\"/>"
        }
    },
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
    },
    FOLDER {
        override fun loadComponent(name: String, commit: Long): String {
            return whiteFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String =
            """
                <rect x="0.5" y="0.5" width="599" height="299" rx="4.5" fill="#F5EDFD"/>
                $folderFieldSvg
            """

        override fun drawBorder(): String =
            "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#F5EDFD\" fill=\"none\"/>"
    },
    RED_COMPUTER {
        override fun loadComponent(name: String, commit: Long): String {
            return whiteFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String =
            """
                <rect x="0.5" y="0.5" width="599" height="299" rx="4.5" fill="#DAFDEC"/>
                $redComputerFieldSvg
            """

        override fun drawBorder(): String =
            "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#DAFDEC\" fill=\"none\"/>"
    },
    RED_SOFA {
        override fun loadComponent(name: String, commit: Long): String {
            return whiteFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String =
            """
                <rect x="0.5" y="0.5" width="599" height="299" rx="4.5" fill="#C4F2F7"/>
                $redSofaFieldSvg
            """

        override fun drawBorder(): String =
            "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#C4F2F7\" fill=\"none\"/>"
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
