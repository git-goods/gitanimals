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

        override fun fillBackground(): String {
            return """
                <g clip-path="url(#clip0_2292_32780)">
                <rect width="600" height="300" rx="5" fill="url(#paint0_linear_2292_32780)"/>
                <rect x="603.24" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 603.24 301.29)" fill="white"/>
                <rect x="589.174" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 589.174 301.29)" fill="white"/>
                <rect x="575.107" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 575.107 301.29)" fill="white"/>
                <rect x="561.039" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 561.039 301.29)" fill="white"/>
                <rect x="546.973" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 546.973 301.29)" fill="white"/>
                <rect x="532.906" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 532.906 301.29)" fill="white"/>
                <rect x="532.906" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 532.906 287.225)" fill="white"/>
                <rect x="518.842" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 518.842 301.29)" fill="white"/>
                <rect x="515" y="301" width="38" height="14" transform="rotate(-180 515 301)" fill="white"/>
                <rect x="484" y="301" width="25" height="14" transform="rotate(-180 484 301)" fill="white"/>
                <rect x="462.578" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 462.578 301.29)" fill="white"/>
                <rect x="448.51" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 448.51 301.29)" fill="white"/>
                <rect x="434.443" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 434.443 301.29)" fill="white"/>
                <rect x="420.377" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 420.377 301.29)" fill="white"/>
                <rect x="406.31" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 406.31 301.29)" fill="white"/>
                <rect x="392.246" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 392.246 301.29)" fill="white"/>
                <rect x="378.18" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 378.18 301.29)" fill="white"/>
                <rect x="364.111" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 364.111 301.29)" fill="white"/>
                <rect x="350.045" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 350.045 301.29)" fill="white"/>
                <rect x="335.978" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 335.978 301.29)" fill="white"/>
                <rect x="321.912" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 321.912 301.29)" fill="white"/>
                <rect x="307.848" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 307.848 301.29)" fill="white"/>
                <rect x="293.781" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 293.781 301.29)" fill="white"/>
                <rect x="279.713" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 279.713 301.29)" fill="white"/>
                <rect x="265.646" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 265.646 301.29)" fill="white"/>
                <rect x="251.58" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 251.58 301.29)" fill="white"/>
                <rect x="237.516" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 237.516 301.29)" fill="white"/>
                <rect x="223.449" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 223.449 301.29)" fill="white"/>
                <rect x="209.383" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 209.383 301.29)" fill="white"/>
                <rect x="195.316" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 195.316 301.29)" fill="white"/>
                <rect x="181.252" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 181.252 301.29)" fill="white"/>
                <rect x="167.182" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 167.182 301.29)" fill="white"/>
                <rect x="153.117" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 153.117 301.29)" fill="white"/>
                <rect x="139.051" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 139.051 301.29)" fill="white"/>
                <rect x="124.984" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 124.984 301.29)" fill="white"/>
                <rect x="110.918" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 110.918 301.29)" fill="white"/>
                <rect x="96.8534" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 96.8534 301.29)" fill="white"/>
                <rect x="82.785" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 82.785 301.29)" fill="white"/>
                <rect x="68.7186" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 68.7186 301.29)" fill="white"/>
                <rect x="54.6522" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 54.6522 301.29)" fill="white"/>
                <rect x="40.5858" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 40.5858 301.29)" fill="white"/>
                <rect x="26.5214" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 26.5214 301.29)" fill="white"/>
                <rect x="12.451" y="301.29" width="14.0663" height="14.0663" transform="rotate(-180 12.451 301.29)" fill="white"/>
                <rect x="617.305" y="273.263" width="44.5434" height="28.7187" transform="rotate(-180 617.305 273.263)" fill="white"/>
                <rect x="603.24" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 603.24 287.225)" fill="white"/>
                <rect x="589.174" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 589.174 287.225)" fill="white"/>
                <rect x="575.107" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 575.107 287.225)" fill="white"/>
                <rect x="561.039" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 561.039 287.225)" fill="white"/>
                <rect x="546.973" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 546.973 287.225)" fill="white"/>
                <rect x="518.842" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 518.842 287.225)" fill="white"/>
                <rect x="504.775" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 504.775 287.225)" fill="white"/>
                <rect x="490.709" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 490.709 287.225)" fill="white"/>
                <rect x="476.642" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 476.642 287.225)" fill="white"/>
                <rect x="462.578" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 462.578 287.225)" fill="white"/>
                <rect x="448.51" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 448.51 287.225)" fill="white"/>
                <rect x="434.443" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 434.443 287.225)" fill="white"/>
                <rect x="420.377" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 420.377 287.225)" fill="white"/>
                <rect x="406.31" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 406.31 287.225)" fill="white"/>
                <rect x="392.246" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 392.246 287.225)" fill="white"/>
                <rect x="378.18" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 378.18 287.225)" fill="white"/>
                <rect x="375" y="290" width="39" height="17" transform="rotate(-180 375 290)" fill="white"/>
                <rect x="335.978" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 335.978 287.225)" fill="white"/>
                <rect x="321.912" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 321.912 287.225)" fill="white"/>
                <rect x="307.848" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 307.848 287.225)" fill="white"/>
                <rect x="293.781" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 293.781 287.225)" fill="white"/>
                <rect x="279.713" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 279.713 287.225)" fill="white"/>
                <rect x="265.646" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 265.646 287.225)" fill="white"/>
                <rect x="251.58" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 251.58 287.225)" fill="white"/>
                <rect x="237.516" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 237.516 287.225)" fill="white"/>
                <rect x="223.449" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 223.449 287.225)" fill="white"/>
                <rect x="209.383" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 209.383 287.225)" fill="white"/>
                <rect x="195.316" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 195.316 287.225)" fill="white"/>
                <rect x="181.252" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 181.252 287.225)" fill="white"/>
                <rect x="167.182" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 167.182 287.225)" fill="white"/>
                <rect x="153.117" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 153.117 287.225)" fill="white"/>
                <rect x="139.051" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 139.051 287.225)" fill="white"/>
                <rect x="124.984" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 124.984 287.225)" fill="white"/>
                <rect x="110.918" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 110.918 287.225)" fill="white"/>
                <rect x="96.8534" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 96.8534 287.225)" fill="white"/>
                <rect x="82.785" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 82.785 287.225)" fill="white"/>
                <rect x="68.7186" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 68.7186 287.225)" fill="white"/>
                <rect x="54.6522" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 54.6522 287.225)" fill="white"/>
                <rect x="40.5858" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 40.5858 287.225)" fill="white"/>
                <rect x="26.5214" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 26.5214 287.225)" fill="white"/>
                <rect x="12.451" y="287.225" width="14.0663" height="14.0663" transform="rotate(-180 12.451 287.225)" fill="white"/>
                <rect x="589.174" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 589.174 273.157)" fill="white"/>
                <rect x="575.107" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 575.107 273.157)" fill="white"/>
                <rect x="561.041" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 561.041 273.157)" fill="white"/>
                <rect x="546.973" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 546.973 273.157)" fill="white"/>
                <rect x="532.906" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 532.906 273.157)" fill="white"/>
                <rect x="518.842" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 518.842 273.157)" fill="white"/>
                <rect x="504.775" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 504.775 273.157)" fill="white"/>
                <rect x="476.642" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 476.642 273.157)" fill="white"/>
                <rect x="462.578" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 462.578 273.157)" fill="white"/>
                <rect x="448.51" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 448.51 273.157)" fill="white"/>
                <rect x="434.443" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 434.443 273.157)" fill="white"/>
                <rect x="420.377" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 420.377 273.157)" fill="white"/>
                <rect x="406.31" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 406.31 273.157)" fill="white"/>
                <rect x="392.246" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 392.246 273.157)" fill="white"/>
                <rect x="378.18" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 378.18 273.157)" fill="white"/>
                <rect x="364.111" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 364.111 273.157)" fill="white"/>
                <rect x="350.045" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 350.045 273.157)" fill="white"/>
                <rect x="335.978" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 335.978 273.157)" fill="white"/>
                <rect x="321.912" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 321.912 273.157)" fill="white"/>
                <rect x="293.781" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 293.781 273.157)" fill="white"/>
                <rect x="265.646" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 265.646 273.157)" fill="white"/>
                <rect x="251.58" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 251.58 273.157)" fill="white"/>
                <rect x="237.516" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 237.516 273.157)" fill="white"/>
                <rect x="223.449" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 223.449 273.157)" fill="white"/>
                <rect x="209.383" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 209.383 273.157)" fill="white"/>
                <rect x="195.316" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 195.316 273.157)" fill="white"/>
                <rect x="181.252" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 181.252 273.157)" fill="white"/>
                <rect x="167.182" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 167.182 273.157)" fill="white"/>
                <rect x="153.117" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 153.117 273.157)" fill="white"/>
                <rect x="139.051" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 139.051 273.157)" fill="white"/>
                <rect x="124.984" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 124.984 273.157)" fill="white"/>
                <rect x="110.918" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 110.918 273.157)" fill="white"/>
                <rect x="96.8534" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 96.8534 273.157)" fill="white"/>
                <rect x="82.785" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 82.785 273.157)" fill="white"/>
                <rect x="68.7186" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 68.7186 273.157)" fill="white"/>
                <rect x="54.6522" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 54.6522 273.157)" fill="white"/>
                <rect x="40.5858" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 40.5858 273.157)" fill="white"/>
                <rect x="26.5214" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 26.5214 273.157)" fill="white"/>
                <rect x="12.451" y="273.157" width="14.0663" height="14.0663" transform="rotate(-180 12.451 273.157)" fill="white"/>
                <rect x="575.107" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 575.107 259.091)" fill="white"/>
                <rect x="589.174" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 589.174 259.091)" fill="white"/>
                <rect x="603.24" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 603.24 259.091)" fill="white"/>
                <rect x="571.004" y="275.607" width="38.0963" height="30.477" transform="rotate(-180 571.004 275.607)" fill="white"/>
                <rect x="532.906" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 532.906 259.091)" fill="white"/>
                <rect x="518.842" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 518.842 259.091)" fill="white"/>
                <rect x="476.642" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 476.642 259.091)" fill="white"/>
                <rect x="462.578" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 462.578 259.091)" fill="white"/>
                <rect x="448.51" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 448.51 259.091)" fill="white"/>
                <rect x="434.443" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 434.443 259.091)" fill="white"/>
                <rect x="406.31" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 406.31 259.091)" fill="white"/>
                <rect x="392.246" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 392.246 259.091)" fill="white"/>
                <rect x="364.111" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 364.111 259.091)" fill="white"/>
                <rect x="293.781" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 293.781 259.091)" fill="white"/>
                <rect x="279.713" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 279.713 259.091)" fill="white"/>
                <rect x="251.58" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 251.58 259.091)" fill="white"/>
                <rect x="237.516" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 237.516 259.091)" fill="white"/>
                <rect x="223.449" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 223.449 259.091)" fill="white"/>
                <rect x="209.383" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 209.383 259.091)" fill="white"/>
                <rect x="195.316" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 195.316 259.091)" fill="white"/>
                <rect x="181.252" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 181.252 259.091)" fill="white"/>
                <rect x="167.182" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 167.182 259.091)" fill="white"/>
                <rect x="153.117" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 153.117 259.091)" fill="white"/>
                <rect x="124.984" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 124.984 259.091)" fill="white"/>
                <rect x="82.785" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 82.785 259.091)" fill="white"/>
                <rect x="68.7186" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 68.7186 259.091)" fill="white"/>
                <rect x="26.5214" y="245.131" width="14.0663" height="14.0663" transform="rotate(-180 26.5214 245.131)" fill="white"/>
                <rect x="12.451" y="259.091" width="14.0663" height="14.0663" transform="rotate(-180 12.451 259.091)" fill="white"/>
                <rect x="575.107" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 575.107 245.025)" fill="white"/>
                <rect x="561.039" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 561.039 245.025)" fill="white"/>
                <rect x="546.973" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 546.973 245.025)" fill="white"/>
                <rect x="532.906" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 532.906 245.025)" fill="white"/>
                <rect x="462.578" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 462.578 245.025)" fill="white"/>
                <rect x="448.51" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 448.51 245.025)" fill="white"/>
                <rect x="237.516" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 237.516 245.025)" fill="white"/>
                <rect x="223.449" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 223.449 245.025)" fill="white"/>
                <rect x="209.383" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 209.383 245.025)" fill="white"/>
                <rect x="181.252" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 181.252 245.025)" fill="white"/>
                <rect x="182.217" y="228.897" width="14" height="14" transform="rotate(-180 182.217 228.897)" fill="white"/>
                <rect x="167.182" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 167.182 245.025)" fill="white"/>
                <rect x="153.117" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 153.117 245.025)" fill="white"/>
                <rect x="139.051" y="245.025" width="14.0663" height="14.0663" transform="rotate(-180 139.051 245.025)" fill="white"/>
                <rect x="561.041" y="230.958" width="14.0663" height="14.0663" transform="rotate(-180 561.041 230.958)" fill="white"/>
                <rect x="546.974" y="216.894" width="14.0663" height="14.0663" transform="rotate(-180 546.974 216.894)" fill="white"/>
                <rect x="71.5839" y="77.5859" width="14" height="14" transform="rotate(-180 71.5839 77.5859)" fill="white"/>
                <rect x="472.584" y="77.5859" width="14" height="14" transform="rotate(-180 472.584 77.5859)" fill="white"/>
                <rect x="275.793" y="151.793" width="14" height="14" transform="rotate(-180 275.793 151.793)" fill="white"/>
                <rect x="26.5839" y="157.586" width="14" height="14" transform="rotate(-180 26.5839 157.586)" fill="white"/>
                <rect x="350.045" y="224.03" width="14.0663" height="14.0663" transform="rotate(-180 350.045 224.03)" fill="white"/>
                <rect width="8.90528" height="17.8106" transform="matrix(-1 0 0 1 458.182 233.288)" fill="#FBE7CE"/>
                <rect width="8.90528" height="17.8106" transform="matrix(-1 0 0 1 484.34 233.288)" fill="#FBE7CE"/>
                <rect width="9.46187" height="17.8106" transform="matrix(-1 0 0 1 433.133 233.288)" fill="#FBE7CE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.506 233.754)" fill="#FC5261"/>
                <rect width="13.3579" height="8.3487" transform="matrix(-1 0 0 1 497.697 233.846)" fill="#FC5261"/>
                <rect width="17.254" height="8.3487" transform="matrix(-1 0 0 1 475.436 233.846)" fill="#FC5261"/>
                <rect width="7.79212" height="8.3487" transform="matrix(-1 0 0 1 449.273 233.846)" fill="#FC5261"/>
                <rect width="9.46187" height="8.3487" transform="matrix(-1 0 0 1 442.598 233.846)" fill="#FC5261"/>
                <rect width="22.2632" height="8.3487" transform="matrix(-1 0 0 1 423.674 233.846)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.506 242.316)" fill="#FC5261"/>
                <rect width="13.3579" height="8.90528" transform="matrix(-1 0 0 1 497.697 242.195)" fill="#FC5261"/>
                <rect width="17.254" height="8.90528" transform="matrix(-1 0 0 1 475.436 242.195)" fill="#FC5261"/>
                <rect width="7.79212" height="8.90528" transform="matrix(-1 0 0 1 449.273 242.195)" fill="#FC5261"/>
                <rect width="9.46187" height="8.90528" transform="matrix(-1 0 0 1 442.598 242.195)" fill="#FC5261"/>
                <rect width="22.2632" height="8.90528" transform="matrix(-1 0 0 1 423.674 242.195)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.506 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 495.941 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.379 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.254 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.693 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.129 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.566 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.441 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.875 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.316 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.506 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 495.941 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.379 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.254 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.693 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.129 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.566 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.441 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.875 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.316 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.506 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 495.941 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.379 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.254 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.693 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.129 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.566 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.441 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.875 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.316 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.936 190.94)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 190.94)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 199.503)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.811 199.503)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.061 208.067)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 208.067)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.811 208.067)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 208.067)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.625 216.628)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.061 216.628)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 216.628)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.936 216.628)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 216.628)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.811 216.628)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 216.628)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.684 216.628)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 225.19)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.625 225.19)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.75 233.754)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 233.754)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.625 233.754)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.75 242.316)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 242.316)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.625 242.316)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.75 250.88)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 250.88)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.625 250.88)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.936 250.88)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 250.88)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.811 250.88)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 316.123 250.88)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.75 259.443)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 259.443)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.625 259.443)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.936 259.443)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 259.443)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.811 259.443)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 316.123 259.443)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.75 268.005)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 268.005)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.625 268.005)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.936 268.005)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 268.005)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.811 268.005)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 316.123 268.005)" fill="#C21835"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 131)" fill="#BCDDEC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 131)" fill="#F1FDFF"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 131)" fill="#B1DAF0"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 131)" fill="#ADD8FB"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 139.562)" fill="#84234C"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 139.562)" fill="#52142D"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 148.127)" fill="#A20F2C"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 148.127)" fill="#6F0418"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 156.688)" fill="#D3E3F3"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 156.688)" fill="#D7E7F4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 156.688)" fill="#D8E4F4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 156.688)" fill="#9E0F2D"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 156.688)" fill="#6A0B23"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 156.688)" fill="#D8E9F3"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 156.688)" fill="#D9E9F6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 156.688)" fill="#D9E6F6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 156.688)" fill="#D6E6F3"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.623 156.688)" fill="#DDEAFA"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.062 156.688)" fill="#D8E8F5"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 156.688)" fill="#DCE5F6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 156.688)" fill="#EDFFFF"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 156.688)" fill="#B2D5E8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.256 165.25)" fill="#C8DAE8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 165.25)" fill="#F8FCFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 165.25)" fill="#F9FDFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 165.25)" fill="#F9FDFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 165.25)" fill="#FBFFFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 165.25)" fill="#FCFCFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 165.25)" fill="#FEFEFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 165.25)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 165.25)" fill="#FCFCFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 165.25)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.623 165.25)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.062 165.25)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 165.25)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 165.25)" fill="#B7D7EE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 165.25)" fill="#7EADD9"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 173.814)" fill="#C8DAE8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.256 173.814)" fill="#F7F7F7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 173.814)" fill="#FAFAFA"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 173.814)" fill="#FEFEFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 173.814)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 173.814)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 173.814)" fill="#FCFCFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 173.814)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 173.814)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 173.814)" fill="#FBFBFB"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 173.814)" fill="#F9F9F9"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.623 173.814)" fill="#FBFBFB"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.062 173.814)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 173.814)" fill="#BBD6E7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 173.814)" fill="#7AA6D3"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 173.814)" fill="#79A8D6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.812 173.814)" fill="#8CC1DE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.381 182.377)" fill="#C8DAE8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 182.377)" fill="#F7F7F7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.256 182.377)" fill="#F8F8F8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 182.377)" fill="#F5F5F5"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 182.377)" fill="#F9F9F9"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 182.377)" fill="#FCFCFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 182.377)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 182.377)" fill="#FEFEFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 182.377)" fill="#FCFCFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 182.377)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 182.377)" fill="#FCFCFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 182.377)" fill="#FAFAFA"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.623 182.377)" fill="#FCFCFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.062 182.377)" fill="#B6D4EE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 182.377)" fill="#73AAD1"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 182.377)" fill="#7D0825"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 182.377)" fill="#790F35"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.812 182.377)" fill="#6FA0C8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 182.377)" fill="#8CC1DE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 495.941 190.939)" fill="#C8DAE8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.381 190.939)" fill="#F0F0F2"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 190.939)" fill="#F9F9F9"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.256 190.939)" fill="#F9F9F9"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 190.939)" fill="#FEFEFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 190.939)" fill="#FEFEFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 190.939)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 190.939)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 190.939)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 190.939)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 190.939)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 190.939)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 190.939)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.623 190.939)" fill="#B5D7F0"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.062 190.939)" fill="#79ACD9"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 190.939)" fill="#5E0D20"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.812 190.939)" fill="#650624"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 190.939)" fill="#76ABCB"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 190.939)" fill="#8CC1DE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.504 199.501)" fill="#C8DAE8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 495.941 199.501)" fill="#EFEFEF"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.381 199.501)" fill="#EFEFEF"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 199.501)" fill="#FAFAFA"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.256 199.501)" fill="#F7F7F7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 199.501)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 199.501)" fill="#F7F7F7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 199.501)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 199.501)" fill="#FEFEFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 199.501)" fill="#FEFEFE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 199.501)" fill="#FCFCFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 199.501)" fill="white"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 199.501)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 199.501)" fill="#AED6F0"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.623 199.501)" fill="#75AAD6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.062 199.501)" fill="#670F1F"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 199.501)" fill="#61111E"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 199.501)" fill="#FFF2DD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 199.501)" fill="#6B0723"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 199.501)" fill="#7CABD7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 316.121 199.501)" fill="#8CC1DE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 513.064 208.064)" fill="#C8DAE8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.504 208.064)" fill="#E1E8EE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 495.941 208.064)" fill="#EFEFEF"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.381 208.064)" fill="#EFEFEF"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 208.064)" fill="#F5F5F5"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.256 208.064)" fill="#F5F5F5"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 208.064)" fill="#FCFCFC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 208.064)" fill="#F9F9F9"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 208.064)" fill="#FAFAFA"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 208.064)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 208.064)" fill="#FDFDFD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 208.064)" fill="#FAFAFA"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 208.064)" fill="#FAFAFA"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 208.064)" fill="#B0D2ED"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 208.064)" fill="#72A5D0"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 384.623 208.064)" fill="#700A22"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 208.064)" fill="#FADDCD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 208.064)" fill="#F8F3D5"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 208.064)" fill="#680C23"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 316.121 208.064)" fill="#7EAAD7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 307.562 208.064)" fill="#8CC1DE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 521.631 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 513.064 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.504 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 495.941 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.381 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.256 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 216.629)" fill="#A6CAE4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 216.629)" fill="#75A6CE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 393.188 216.629)" fill="#630418"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 521.631 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 513.064 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 504.504 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 495.941 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 487.381 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 478.816 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 470.256 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 461.689 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 453.127 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 444.564 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 436.002 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 427.439 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 418.877 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 410.314 225.19)" fill="#89B1CD"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 401.748 225.19)" fill="#67061A"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.062 225.19)" fill="#D1CEE1"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 225.19)" fill="#77A8D0"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 225.19)" fill="#79AEDA"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 225.19)" fill="#77ACD6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.812 225.19)" fill="#77B2DC"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 225.19)" fill="#70ACCE"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 225.19)" fill="#78AED4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 316.121 225.19)" fill="#7CA9D3"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.498 233.752)" fill="#CFD0E4"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 233.752)" fill="#74A8D7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 233.752)" fill="#70A8D7"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.812 233.752)" fill="#74AAD6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 233.752)" fill="#6EA8D6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 233.752)" fill="#77ACD8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 316.121 233.752)" fill="#77ACD6"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 307.562 233.752)" fill="#7AA7C8"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 358.938 242.316)" fill="#72040F"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 350.373 242.316)" fill="#780013"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 341.812 242.316)" fill="#6D0111"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 242.316)" fill="#740219"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 242.316)" fill="#75081B"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 316.121 242.316)" fill="#7E0018"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 250.88)" fill="#EFA393"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 250.88)" fill="#EA9B94"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 259.441)" fill="#61111E"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 259.441)" fill="#61111E"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.061 233.754)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.061 242.316)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.5 242.316)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.061 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.5 250.881)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.061 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.5 259.443)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 376.061 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 367.5 268.005)" fill="#FC5261"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 333.248 268.005)" fill="#61111E"/>
                <rect width="8.56278" height="8.56278" transform="matrix(-1 0 0 1 324.688 268.005)" fill="#61111E"/>
                </g>
                <defs>
                <linearGradient id="paint0_linear_2292_32780" x1="300" y1="0" x2="300" y2="300" gradientUnits="userSpaceOnUse">
                <stop stop-color="#D1EAF6"/>
                <stop offset="1" stop-color="#62B9E0"/>
                </linearGradient>
                <clipPath id="clip0_2292_32780">
                <rect width="600" height="300" rx="5" fill="white"/>
                </clipPath>
                </defs>
            """.trimIndent()
        }

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\"/>"
        }
    }, 
    SNOW_GRASS_FIELD {
        override fun loadComponent(name: String, commit: Long): String {
            return snowGrassFieldSvg.replace(NAME_FIX, name.toSvg(0.0, 3.0))
                .replace(COMMIT_FIX, commit.toSvg("commit", 260.0, 4.0))
        }

        override fun fillBackground(): String = """
            <g clip-path="url(#clip0_2292_24949)">
            <rect width="600" height="300" rx="5" fill="#FBFBFB"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M65.5 147H63V157H60.5V168.25H58V165.75H55.5V168.25H53V165.75H50.5V170.75H53V173.25H55.5V170.75H58H60.5V173.25H63V170.75H65.5V173.25H68V175.75H70.5H73V178.25H75.5H78V180.75H80.5V178.25H83V175.75H85.5H88V170.75H90.5V173.25H93H95.5V165.75H93V163.25H90.5V158.25H88V160.75H85.5V153.25H83V155.75H80.5H78V153.25H75.5V158.25H73V155.75H70.5V163.25H68V168.25H65.5V147ZM70.5 163.25H73V165.75H70.5V163.25ZM93 165.75V168.25H90.5V165.75H93ZM80.5 163.25V158.25H83V163.25H80.5ZM58 154.5H55.5V159.5H53V163.25H55.5V162H58V154.5ZM39.25 162H41.75V164.5H44.25V167H46.75V173.25H44.25V170.75H41.75H39.25H36.75H34.25V164.5H36.75V167H39.25V162ZM63 175.75H65.5V178.25H63V175.75ZM65.5 178.25H68H70.5V180.75H68V183.25H65.5V178.25ZM98 168.25H100.5V165.75H103V163.25H105.5V168.25H108V165.75H110.5V170.75H108H105.5H103H100.5V173.25H98V168.25ZM20.5 199.5H18V204.5H20.5V207H23V204.5H25.5H28V207H30.5V204.5H33V207H35.5V209.5H38H40.5V212H43H45.5V214.5H48V212H50.5V209.5H53H55.5V204.5H58V207H60.5H63V199.5H60.5V197H58V192H55.5V194.5H53V187H50.5V189.5H48H45.5V187H43V192H40.5V189.5H38V197H35.5V202H33V188.25H30.5V190.75H28V202H25.5V199.5H23V202H20.5V199.5ZM38 199.5H40.5V197H38V199.5ZM60.5 199.5H58V202H60.5V199.5ZM23 188.25H25.5V195.75H23V197H20.5V193.25H23V188.25ZM33 209.5H30.5V212H33V217H35.5V214.5H38V212H35.5H33V209.5ZM50.5 197H48V192H50.5V197ZM68 202H65.5V207H68V204.5H70.5H73H75.5H78V199.5H75.5V202H73V197H70.5V199.5H68V202Z" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="30.5" y="200.75" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="28" y="195.75" width="2.5" height="11.25" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="78" y="164.5" width="2.5" height="7.5" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="75.5" y="168.25" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="80.5" y="168.25" width="2.5" height="6.25" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="39.25" y="167" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M229.5 241H227V251H224.5V262.25H222V259.75H219.5V262.25H217V259.75H214.5V264.75H217V267.25H219.5V264.75H222H224.5V267.25H227V264.75H229.5V267.25H232V269.75H234.5H237V272.25H239.5H242V274.75H244.5V272.25H247V269.75H249.5H252V264.75H254.5V267.25H257H259.5V259.75H257V257.25H254.5V252.25H252V254.75H249.5V247.25H247V249.75H244.5H242V247.25H239.5V252.25H237V249.75H234.5V257.25H232V262.25H229.5V241ZM234.5 257.25H237V259.75H234.5V257.25ZM257 259.75V262.25H254.5V259.75H257ZM244.5 257.25V252.25H247V257.25H244.5ZM222 248.5H219.5V253.5H217V257.25H219.5V256H222V248.5ZM203.25 256H205.75V258.5H208.25V261H210.75V267.25H208.25V264.75H205.75H203.25H200.75H198.25V258.5H200.75V261H203.25V256ZM227 269.75H229.5V272.25H227V269.75ZM229.5 272.25H232H234.5V274.75H232V277.25H229.5V272.25ZM262 262.25H264.5V259.75H267V257.25H269.5V262.25H272V259.75H274.5V264.75H272H269.5H267H264.5V267.25H262V262.25ZM184.5 293.5H182V298.5H184.5V301H187V298.5H189.5H192V301H194.5V298.5H197V301H199.5V303.5H202H204.5V306H207H209.5V308.5H212V306H214.5V303.5H217H219.5V298.5H222V301H224.5H227V293.5H224.5V291H222V286H219.5V288.5H217V281H214.5V283.5H212H209.5V281H207V286H204.5V283.5H202V291H199.5V296H197V282.25H194.5V284.75H192V296H189.5V293.5H187V296H184.5V293.5ZM202 293.5H204.5V291H202V293.5ZM224.5 293.5H222V296H224.5V293.5ZM187 282.25H189.5V289.75H187V291H184.5V287.25H187V282.25ZM197 303.5H194.5V306H197V311H199.5V308.5H202V306H199.5H197V303.5ZM214.5 291H212V286H214.5V291ZM232 296H229.5V301H232V298.5H234.5H237H239.5H242V293.5H239.5V296H237V291H234.5V293.5H232V296Z" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="194.5" y="294.75" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="192" y="289.75" width="2.5" height="11.25" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="242" y="258.5" width="2.5" height="7.5" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="239.5" y="262.25" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="244.5" y="262.25" width="2.5" height="6.25" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="203.25" y="261" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M439.5 69H437V79H434.5V90.25H432V87.75H429.5V90.25H427V87.75H424.5V92.75H427V95.25H429.5V92.75H432H434.5V95.25H437V92.75H439.5V95.25H442V97.75H444.5H447V100.25H449.5H452V102.75H454.5V100.25H457V97.75H459.5H462V92.75H464.5V95.25H467H469.5V87.75H467V85.25H464.5V80.25H462V82.75H459.5V75.25H457V77.75H454.5H452V75.25H449.5V80.25H447V77.75H444.5V85.25H442V90.25H439.5V69ZM444.5 85.25H447V87.75H444.5V85.25ZM467 87.75V90.25H464.5V87.75H467ZM454.5 85.25V80.25H457V85.25H454.5ZM432 76.5H429.5V81.5H427V85.25H429.5V84H432V76.5ZM413.25 84H415.75V86.5H418.25V89H420.75V95.25H418.25V92.75H415.75H413.25H410.75H408.25V86.5H410.75V89H413.25V84ZM437 97.75H439.5V100.25H437V97.75ZM439.5 100.25H442H444.5V102.75H442V105.25H439.5V100.25ZM472 90.25H474.5V87.75H477V85.25H479.5V90.25H482V87.75H484.5V92.75H482H479.5H477H474.5V95.25H472V90.25ZM394.5 121.5H392V126.5H394.5V129H397V126.5H399.5H402V129H404.5V126.5H407V129H409.5V131.5H412H414.5V134H417H419.5V136.5H422V134H424.5V131.5H427H429.5V126.5H432V129H434.5H437V121.5H434.5V119H432V114H429.5V116.5H427V109H424.5V111.5H422H419.5V109H417V114H414.5V111.5H412V119H409.5V124H407V110.25H404.5V112.75H402V124H399.5V121.5H397V124H394.5V121.5ZM412 121.5H414.5V119H412V121.5ZM434.5 121.5H432V124H434.5V121.5ZM397 110.25H399.5V117.75H397V119H394.5V115.25H397V110.25ZM407 131.5H404.5V134H407V139H409.5V136.5H412V134H409.5H407V131.5ZM424.5 119H422V114H424.5V119ZM442 124H439.5V129H442V126.5H444.5H447H449.5H452V121.5H449.5V124H447V119H444.5V121.5H442V124Z" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="404.5" y="122.75" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="402" y="117.75" width="2.5" height="11.25" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="452" y="86.5" width="2.5" height="7.5" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="449.5" y="90.25" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="454.5" y="90.25" width="2.5" height="6.25" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="413.25" y="89" width="2.5" height="3.75" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M162 12.5H164.5V20H167V17.5H169.5V22.5H172V25H169.5V27.5H172V25H174.5V32.5H169.5V30H167V35H162V37.5H159.5V40H157V37.5H152V35H147V32.5H144.5V30H142V32.5H139.5V30H134.5V32.5H132V30H129.5V25H132V27.5H134.5V25H137V27.5H139.5V22.5H142V17.5H144.5V27.5H147V22.5H149.5V25H152V22.5H149.5V15H152V17.5H154.5V12.5H157V15H162V12.5ZM159.5 17.5V22.5H162V17.5H159.5Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M144.5 35H142V37.5H144.5V42.5H147V40H149.5V37.5H144.5V35Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M179.5 27.5H177V32.5H179.5V30H189.5V25H187V27.5H184.5V22.5H182V25H179.5V27.5Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M510 89.5L507.5 89.5L507.5 82L505 82L505 84.5L502.5 84.5L502.5 79.5L500 79.5L500 77L502.5 77L502.5 74.5L500 74.5L500 77L497.5 77L497.5 69.5L502.5 69.5L502.5 72L505 72L505 67L510 67L510 64.5L512.5 64.5L512.5 62L515 62L515 64.5L520 64.5L520 67L525 67L525 69.5L527.5 69.5L527.5 72L530 72L530 69.5L532.5 69.5L532.5 72L537.5 72L537.5 69.5L540 69.5L540 72L542.5 72L542.5 77L540 77L540 74.5L537.5 74.5L537.5 77L535 77L535 74.5L532.5 74.5L532.5 79.5L530 79.5L530 84.5L527.5 84.5L527.5 74.5L525 74.5L525 79.5L522.5 79.5L522.5 77L520 77L520 79.5L522.5 79.5L522.5 87L520 87L520 84.5L517.5 84.5L517.5 89.5L515 89.5L515 87L510 87L510 89.5ZM512.5 84.5L512.5 79.5L510 79.5L510 84.5L512.5 84.5Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M527.5 67L530 67L530 64.5L527.5 64.5L527.5 59.5L525 59.5L525 62L522.5 62L522.5 64.5L527.5 64.5L527.5 67Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M492.5 74.5L495 74.5L495 69.5L492.5 69.5L492.5 72L482.5 72L482.5 77L485 77L485 74.5L487.5 74.5L487.5 79.5L490 79.5L490 77L492.5 77L492.5 74.5Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M472 75.5L469.5 75.5L469.5 68L467 68L467 70.5L464.5 70.5L464.5 65.5L462 65.5L462 63L464.5 63L464.5 60.5L462 60.5L462 63L459.5 63L459.5 55.5L464.5 55.5L464.5 58L467 58L467 53L472 53L472 50.5L474.5 50.5L474.5 48L477 48L477 50.5L482 50.5L482 53L487 53L487 55.5L489.5 55.5L489.5 58L492 58L492 55.5L494.5 55.5L494.5 58L499.5 58L499.5 55.5L502 55.5L502 58L504.5 58L504.5 63L502 63L502 60.5L499.5 60.5L499.5 63L497 63L497 60.5L494.5 60.5L494.5 65.5L492 65.5L492 70.5L489.5 70.5L489.5 60.5L487 60.5L487 65.5L484.5 65.5L484.5 63L482 63L482 65.5L484.5 65.5L484.5 73L482 73L482 70.5L479.5 70.5L479.5 75.5L477 75.5L477 73L472 73L472 75.5ZM474.5 70.5L474.5 65.5L472 65.5L472 70.5L474.5 70.5Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M489.5 53L492 53L492 50.5L489.5 50.5L489.5 45.5L487 45.5L487 48L484.5 48L484.5 50.5L489.5 50.5L489.5 53Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M454.5 60.5L457 60.5L457 55.5L454.5 55.5L454.5 58L444.5 58L444.5 63L447 63L447 60.5L449.5 60.5L449.5 65.5L452 65.5L452 63L454.5 63L454.5 60.5Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M389 119.5L386.5 119.5L386.5 112L384 112L384 114.5L381.5 114.5L381.5 109.5L379 109.5L379 107L381.5 107L381.5 104.5L379 104.5L379 107L376.5 107L376.5 99.5L381.5 99.5L381.5 102L384 102L384 97L389 97L389 94.5L391.5 94.5L391.5 92L394 92L394 94.5L399 94.5L399 97L404 97L404 99.5L406.5 99.5L406.5 102L409 102L409 99.5L411.5 99.5L411.5 102L416.5 102L416.5 99.5L419 99.5L419 102L421.5 102L421.5 107L419 107L419 104.5L416.5 104.5L416.5 107L414 107L414 104.5L411.5 104.5L411.5 109.5L409 109.5L409 114.5L406.5 114.5L406.5 104.5L404 104.5L404 109.5L401.5 109.5L401.5 107L399 107L399 109.5L401.5 109.5L401.5 117L399 117L399 114.5L396.5 114.5L396.5 119.5L394 119.5L394 117L389 117L389 119.5ZM391.5 114.5L391.5 109.5L389 109.5L389 114.5L391.5 114.5Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M406.5 97L409 97L409 94.5L406.5 94.5L406.5 89.5L404 89.5L404 92L401.5 92L401.5 94.5L406.5 94.5L406.5 97Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M371.5 104.5L374 104.5L374 99.5L371.5 99.5L371.5 102L361.5 102L361.5 107L364 107L364 104.5L366.5 104.5L366.5 109.5L369 109.5L369 107L371.5 107L371.5 104.5Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M510 215.667L507.5 215.667L507.5 222.667L505 222.667L505 220.333L502.5 220.333L502.5 225L500 225L500 227.333L502.5 227.333L502.5 229.667L500 229.667L500 227.333L497.5 227.333L497.5 234.333L502.5 234.333L502.5 232L505 232L505 236.667L510 236.667L510 239L512.5 239L512.5 241.333L515 241.333L515 239L520 239L520 236.667L525 236.667L525 234.333L527.5 234.333L527.5 232L530 232L530 234.333L532.5 234.333L532.5 232L537.5 232L537.5 234.333L540 234.333L540 232L542.5 232L542.5 227.333L540 227.333L540 229.667L537.5 229.667L537.5 227.333L535 227.333L535 229.667L532.5 229.667L532.5 225L530 225L530 220.333L527.5 220.333L527.5 229.667L525 229.667L525 225L522.5 225L522.5 227.333L520 227.333L520 225L522.5 225L522.5 218L520 218L520 220.333L517.5 220.333L517.5 215.667L515 215.667L515 218L510 218L510 215.667ZM512.5 220.333L512.5 225L510 225L510 220.333L512.5 220.333Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M527.5 236.667L530 236.667L530 239L527.5 239L527.5 243.667L525 243.667L525 241.333L522.5 241.333L522.5 239L527.5 239L527.5 236.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M492.5 229.667L495 229.667L495 234.333L492.5 234.333L492.5 232L482.5 232L482.5 227.333L485 227.333L485 229.667L487.5 229.667L487.5 225L490 225L490 227.333L492.5 227.333L492.5 229.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M162 115.667L159.5 115.667L159.5 122.667L157 122.667L157 120.333L154.5 120.333L154.5 125L152 125L152 127.333L154.5 127.333L154.5 129.667L152 129.667L152 127.333L149.5 127.333L149.5 134.333L154.5 134.333L154.5 132L157 132L157 136.667L162 136.667L162 139L164.5 139L164.5 141.333L167 141.333L167 139L172 139L172 136.667L177 136.667L177 134.333L179.5 134.333L179.5 132L182 132L182 134.333L184.5 134.333L184.5 132L189.5 132L189.5 134.333L192 134.333L192 132L194.5 132L194.5 127.333L192 127.333L192 129.667L189.5 129.667L189.5 127.333L187 127.333L187 129.667L184.5 129.667L184.5 125L182 125L182 120.333L179.5 120.333L179.5 129.667L177 129.667L177 125L174.5 125L174.5 127.333L172 127.333L172 125L174.5 125L174.5 118L172 118L172 120.333L169.5 120.333L169.5 115.667L167 115.667L167 118L162 118L162 115.667ZM164.5 120.333L164.5 125L162 125L162 120.333L164.5 120.333Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M179.5 136.667L182 136.667L182 139L179.5 139L179.5 143.667L177 143.667L177 141.333L174.5 141.333L174.5 139L179.5 139L179.5 136.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M144.5 129.667L147 129.667L147 134.333L144.5 134.333L144.5 132L134.5 132L134.5 127.333L137 127.333L137 129.667L139.5 129.667L139.5 125L142 125L142 127.333L144.5 127.333L144.5 129.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M585 134.667L582.5 134.667L582.5 141.667L580 141.667L580 139.333L577.5 139.333L577.5 144L575 144L575 146.333L577.5 146.333L577.5 148.667L575 148.667L575 146.333L572.5 146.333L572.5 153.333L577.5 153.333L577.5 151L580 151L580 155.667L585 155.667L585 158L587.5 158L587.5 160.333L590 160.333L590 158L595 158L595 155.667L600 155.667L600 153.333L602.5 153.333L602.5 151L605 151L605 153.333L607.5 153.333L607.5 151L612.5 151L612.5 153.333L615 153.333L615 151L617.5 151L617.5 146.333L615 146.333L615 148.667L612.5 148.667L612.5 146.333L610 146.333L610 148.667L607.5 148.667L607.5 144L605 144L605 139.333L602.5 139.333L602.5 148.667L600 148.667L600 144L597.5 144L597.5 146.333L595 146.333L595 144L597.5 144L597.5 137L595 137L595 139.333L592.5 139.333L592.5 134.667L590 134.667L590 137L585 137L585 134.667ZM587.5 139.333L587.5 144L585 144L585 139.333L587.5 139.333Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M602.5 155.667L605 155.667L605 158L602.5 158L602.5 162.667L600 162.667L600 160.333L597.5 160.333L597.5 158L602.5 158L602.5 155.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M567.5 148.667L570 148.667L570 153.333L567.5 153.333L567.5 151L557.5 151L557.5 146.333L560 146.333L560 148.667L562.5 148.667L562.5 144L565 144L565 146.333L567.5 146.333L567.5 148.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M257 195.667L254.5 195.667L254.5 202.667L252 202.667L252 200.333L249.5 200.333L249.5 205L247 205L247 207.333L249.5 207.333L249.5 209.667L247 209.667L247 207.333L244.5 207.333L244.5 214.333L249.5 214.333L249.5 212L252 212L252 216.667L257 216.667L257 219L259.5 219L259.5 221.333L262 221.333L262 219L267 219L267 216.667L272 216.667L272 214.333L274.5 214.333L274.5 212L277 212L277 214.333L279.5 214.333L279.5 212L284.5 212L284.5 214.333L287 214.333L287 212L289.5 212L289.5 207.333L287 207.333L287 209.667L284.5 209.667L284.5 207.333L282 207.333L282 209.667L279.5 209.667L279.5 205L277 205L277 200.333L274.5 200.333L274.5 209.667L272 209.667L272 205L269.5 205L269.5 207.333L267 207.333L267 205L269.5 205L269.5 198L267 198L267 200.333L264.5 200.333L264.5 195.667L262 195.667L262 198L257 198L257 195.667ZM259.5 200.333L259.5 205L257 205L257 200.333L259.5 200.333Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M274.5 216.667L277 216.667L277 219L274.5 219L274.5 223.667L272 223.667L272 221.333L269.5 221.333L269.5 219L274.5 219L274.5 216.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M239.5 209.667L242 209.667L242 214.333L239.5 214.333L239.5 212L229.5 212L229.5 207.333L232 207.333L232 209.667L234.5 209.667L234.5 205L237 205L237 207.333L239.5 207.333L239.5 209.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M277 187.667L274.5 187.667L274.5 194.667L272 194.667L272 192.333L269.5 192.333L269.5 197L267 197L267 199.333L269.5 199.333L269.5 201.667L267 201.667L267 199.333L264.5 199.333L264.5 206.333L269.5 206.333L269.5 204L272 204L272 208.667L277 208.667L277 211L279.5 211L279.5 213.333L282 213.333L282 211L287 211L287 208.667L292 208.667L292 206.333L294.5 206.333L294.5 204L297 204L297 206.333L299.5 206.333L299.5 204L304.5 204L304.5 206.333L307 206.333L307 204L309.5 204L309.5 199.333L307 199.333L307 201.667L304.5 201.667L304.5 199.333L302 199.333L302 201.667L299.5 201.667L299.5 197L297 197L297 192.333L294.5 192.333L294.5 201.667L292 201.667L292 197L289.5 197L289.5 199.333L287 199.333L287 197L289.5 197L289.5 190L287 190L287 192.333L284.5 192.333L284.5 187.667L282 187.667L282 190L277 190L277 187.667ZM279.5 192.333L279.5 197L277 197L277 192.333L279.5 192.333Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M294.5 208.667L297 208.667L297 211L294.5 211L294.5 215.667L292 215.667L292 213.333L289.5 213.333L289.5 211L294.5 211L294.5 208.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <path d="M259.5 201.667L262 201.667L262 206.333L259.5 206.333L259.5 204L249.5 204L249.5 199.333L252 199.333L252 201.667L254.5 201.667L254.5 197L257 197L257 199.333L259.5 199.333L259.5 201.667Z" fill="#4D5C55" fill-opacity="0.6"/>
            <rect x="114" y="218" width="28" height="2" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="116.154" y="217.5" width="23.6923" height="0.5" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="116.154" y="220" width="23.6923" height="0.5" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="118.307" y="217" width="19.3846" height="0.5" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="118.307" y="220.5" width="19.3846" height="0.5" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="117.275" y="191.234" width="3.96653" height="27.7657" fill="#7F4D2A"/>
            <rect x="121.242" y="191.234" width="4.29707" height="27.7657" fill="#7F4D2A"/>
            <rect x="125.539" y="191.234" width="4.29707" height="27.7657" fill="#7F4D2A"/>
            <rect x="129.838" y="191.234" width="4.29707" height="27.7657" fill="#79421B"/>
            <rect x="134.133" y="191.234" width="3.96653" height="27.7657" fill="#743E1C"/>
            <rect x="125.588" y="61" width="4.19913" height="4.19913" fill="#F9F9F9"/>
            <rect x="121.389" y="65.1992" width="4.19913" height="4.19913" fill="#F4FDFF"/>
            <rect x="125.588" y="65.1992" width="4.19913" height="4.19913" fill="#F9F9F9"/>
            <rect x="129.787" y="65.1992" width="4.19913" height="4.19913" fill="#EBEFF0"/>
            <rect x="121.389" y="69.3984" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="125.588" y="69.3984" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="69.3984" width="4.19913" height="4.19913" fill="#EFEFEF"/>
            <rect x="133.986" y="69.3984" width="4.19913" height="4.19913" fill="#335C4A"/>
            <rect x="117.191" y="73.5977" width="4.19913" height="4.19913" fill="#EEEFE7"/>
            <rect x="121.389" y="73.5977" width="4.19913" height="4.19913" fill="#F1F1F1"/>
            <rect x="125.588" y="73.5977" width="4.19913" height="4.19913" fill="#EFEFEF"/>
            <rect x="129.787" y="73.5977" width="4.19913" height="4.19913" fill="#ECECEC"/>
            <rect x="133.986" y="73.5977" width="4.19913" height="4.19913" fill="#EEF8F0"/>
            <rect x="112.99" y="77.7959" width="4.19913" height="4.19913" fill="#F7FFFF"/>
            <rect x="117.191" y="77.7959" width="4.19913" height="4.19913" fill="#FDFFFC"/>
            <rect x="121.389" y="77.7959" width="4.19913" height="4.19913" fill="#F9FFF6"/>
            <rect x="125.588" y="77.7959" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="77.7959" width="4.19913" height="4.19913" fill="#F2F2F2"/>
            <rect x="133.986" y="77.7959" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="138.188" y="77.7959" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="112.99" y="81.9951" width="4.19913" height="4.19913" fill="#3F6568"/>
            <rect x="117.191" y="81.9951" width="4.19913" height="4.19913" fill="#436E50"/>
            <rect x="121.389" y="81.9951" width="4.19913" height="4.19913" fill="#3F714E"/>
            <rect x="125.588" y="81.9951" width="4.19913" height="4.19913" fill="#EDFAF3"/>
            <rect x="129.787" y="81.9951" width="4.19913" height="4.19913" fill="#F1F1F1"/>
            <rect x="133.986" y="81.9951" width="4.19913" height="4.19913" fill="#F3FAF2"/>
            <rect x="138.188" y="81.9951" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="108.793" y="86.1943" width="4.19913" height="4.19913" fill="#34554E"/>
            <rect x="112.99" y="86.1943" width="4.19913" height="4.19913" fill="#366342"/>
            <rect x="117.191" y="86.1943" width="4.19913" height="4.19913" fill="#45734F"/>
            <rect x="121.389" y="86.1943" width="4.19913" height="4.19913" fill="#43714D"/>
            <rect x="125.588" y="86.1943" width="4.19913" height="4.19913" fill="#396743"/>
            <rect x="129.787" y="86.1943" width="4.19913" height="4.19913" fill="#F1F6F0"/>
            <rect x="133.986" y="86.1943" width="4.19913" height="4.19913" fill="#365840"/>
            <rect x="138.188" y="86.1943" width="4.19913" height="4.19913" fill="#396645"/>
            <rect x="104.592" y="90.3936" width="4.19913" height="4.19913" fill="#F2FFFF"/>
            <rect x="112.99" y="90.3936" width="4.19913" height="4.19913" fill="#5F893F"/>
            <rect x="117.191" y="90.3936" width="4.19913" height="4.19913" fill="#5A8A36"/>
            <rect x="121.389" y="90.3936" width="4.19913" height="4.19913" fill="#5B8B37"/>
            <rect x="125.588" y="90.3936" width="4.19913" height="4.19913" fill="#325F3E"/>
            <rect x="129.787" y="90.3936" width="4.19913" height="4.19913" fill="#335B40"/>
            <rect x="133.986" y="90.3936" width="4.19913" height="4.19913" fill="#547F38"/>
            <rect x="138.188" y="90.3936" width="4.19913" height="4.19913" fill="#5A8334"/>
            <rect x="142.385" y="90.3936" width="4.19913" height="4.19913" fill="#588242"/>
            <rect x="100.395" y="94.5938" width="4.19913" height="4.19913" fill="#EFFCFF"/>
            <rect x="104.592" y="94.5938" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="108.793" y="94.5938" width="4.19913" height="4.19913" fill="#DBDBDB"/>
            <rect x="112.99" y="94.5938" width="4.19913" height="4.19913" fill="#F8FFEA"/>
            <rect x="117.191" y="94.5938" width="4.19913" height="4.19913" fill="#638F36"/>
            <rect x="121.389" y="94.5938" width="4.19913" height="4.19913" fill="#5D833A"/>
            <rect x="125.588" y="94.5938" width="4.19913" height="4.19913" fill="#5A8631"/>
            <rect x="129.787" y="94.5938" width="4.19913" height="4.19913" fill="#5C822B"/>
            <rect x="133.986" y="94.5938" width="4.19913" height="4.19913" fill="#577E2B"/>
            <rect x="138.188" y="94.5938" width="4.19913" height="4.19913" fill="#5E8630"/>
            <rect x="142.385" y="94.5938" width="4.19913" height="4.19913" fill="#FAFFF9"/>
            <rect x="146.586" y="94.5938" width="4.19913" height="4.19913" fill="#F7FEFF"/>
            <rect x="100.395" y="98.793" width="4.19913" height="4.19913" fill="#FDFEF9"/>
            <rect x="104.592" y="98.793" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="108.793" y="98.793" width="4.19913" height="4.19913" fill="#E0E0E0"/>
            <rect x="112.99" y="98.793" width="4.19913" height="4.19913" fill="white"/>
            <rect x="117.191" y="98.793" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="121.389" y="98.793" width="4.19913" height="4.19913" fill="#FEFFF9"/>
            <rect x="125.588" y="98.793" width="4.19913" height="4.19913" fill="#54783B"/>
            <rect x="129.787" y="98.793" width="4.19913" height="4.19913" fill="#517827"/>
            <rect x="133.986" y="98.793" width="4.19913" height="4.19913" fill="#4D7828"/>
            <rect x="138.188" y="98.793" width="4.19913" height="4.19913" fill="#4F7A28"/>
            <rect x="142.385" y="98.793" width="4.19913" height="4.19913" fill="#FFFDFF"/>
            <rect x="146.586" y="98.793" width="4.19913" height="4.19913" fill="#FCFDFF"/>
            <rect x="150.783" y="98.793" width="4.19913" height="4.19913" fill="#F8FCFD"/>
            <rect x="100.395" y="102.991" width="4.19913" height="4.19913" fill="#355C57"/>
            <rect x="104.592" y="102.991" width="4.19913" height="4.19913" fill="#315A3C"/>
            <rect x="108.793" y="102.991" width="4.19913" height="4.19913" fill="#24482E"/>
            <rect x="112.99" y="102.991" width="4.19913" height="4.19913" fill="#F1F8F1"/>
            <rect x="117.191" y="102.991" width="4.19913" height="4.19913" fill="white"/>
            <rect x="121.389" y="102.991" width="4.19913" height="4.19913" fill="white"/>
            <rect x="125.588" y="102.991" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="102.991" width="4.19913" height="4.19913" fill="#EDEFE4"/>
            <rect x="133.986" y="102.991" width="4.19913" height="4.19913" fill="white"/>
            <rect x="138.188" y="102.991" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="142.385" y="102.991" width="4.19913" height="4.19913" fill="#FEFFFF"/>
            <rect x="146.586" y="102.991" width="4.19913" height="4.19913" fill="#375241"/>
            <rect x="150.783" y="102.991" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="100.395" y="107.19" width="4.19913" height="4.19913" fill="#366342"/>
            <rect x="104.592" y="107.19" width="4.19913" height="4.19913" fill="#315F3B"/>
            <rect x="108.793" y="107.19" width="4.19913" height="4.19913" fill="#1C4A26"/>
            <rect x="112.99" y="107.19" width="4.19913" height="4.19913" fill="#345B3E"/>
            <rect x="117.191" y="107.19" width="4.19913" height="4.19913" fill="#E9FEF5"/>
            <rect x="121.389" y="107.19" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="125.588" y="107.19" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="107.19" width="4.19913" height="4.19913" fill="#F3F3F3"/>
            <rect x="133.986" y="107.19" width="4.19913" height="4.19913" fill="#334C39"/>
            <rect x="138.188" y="107.19" width="4.19913" height="4.19913" fill="#295733"/>
            <rect x="142.385" y="107.19" width="4.19913" height="4.19913" fill="#315139"/>
            <rect x="146.586" y="107.19" width="4.19913" height="4.19913" fill="#295834"/>
            <rect x="150.783" y="107.19" width="4.19913" height="4.19913" fill="#36523B"/>
            <rect x="154.982" y="107.19" width="4.19913" height="4.19913" fill="#21502E"/>
            <rect x="96.1953" y="111.39" width="4.19913" height="4.19913" fill="#67933C"/>
            <rect x="100.395" y="111.39" width="4.19913" height="4.19913" fill="#F2FFEC"/>
            <rect x="104.592" y="111.39" width="4.19913" height="4.19913" fill="#588439"/>
            <rect x="108.793" y="111.39" width="4.19913" height="4.19913" fill="#497128"/>
            <rect x="112.99" y="111.39" width="4.19913" height="4.19913" fill="#2B5D3A"/>
            <rect x="117.191" y="111.39" width="4.19913" height="4.19913" fill="#356042"/>
            <rect x="121.389" y="111.39" width="4.19913" height="4.19913" fill="#336240"/>
            <rect x="125.588" y="111.39" width="4.19913" height="4.19913" fill="#2C5B37"/>
            <rect x="129.787" y="111.39" width="4.19913" height="4.19913" fill="#264C37"/>
            <rect x="133.986" y="111.39" width="4.19913" height="4.19913" fill="#235031"/>
            <rect x="138.188" y="111.39" width="4.19913" height="4.19913" fill="#52813D"/>
            <rect x="142.385" y="111.39" width="4.19913" height="4.19913" fill="#588230"/>
            <rect x="146.586" y="111.39" width="4.19913" height="4.19913" fill="#528028"/>
            <rect x="150.783" y="111.39" width="4.19913" height="4.19913" fill="#558231"/>
            <rect x="154.982" y="111.39" width="4.19913" height="4.19913" fill="#4C7C16"/>
            <rect x="91.9961" y="115.589" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="96.1953" y="115.589" width="4.19913" height="4.19913" fill="#65853C"/>
            <rect x="100.395" y="115.589" width="4.19913" height="4.19913" fill="#F0F7F0"/>
            <rect x="104.592" y="115.589" width="4.19913" height="4.19913" fill="#FCFFF3"/>
            <rect x="108.793" y="115.589" width="4.19913" height="4.19913" fill="#496E20"/>
            <rect x="112.99" y="115.589" width="4.19913" height="4.19913" fill="#588230"/>
            <rect x="117.191" y="115.589" width="4.19913" height="4.19913" fill="#568132"/>
            <rect x="121.389" y="115.589" width="4.19913" height="4.19913" fill="#5C813B"/>
            <rect x="125.588" y="115.589" width="4.19913" height="4.19913" fill="#547B3A"/>
            <rect x="129.787" y="115.589" width="4.19913" height="4.19913" fill="#517626"/>
            <rect x="133.986" y="115.589" width="4.19913" height="4.19913" fill="#527C34"/>
            <rect x="138.188" y="115.589" width="4.19913" height="4.19913" fill="#577C2E"/>
            <rect x="142.385" y="115.589" width="4.19913" height="4.19913" fill="#547A2D"/>
            <rect x="146.586" y="115.589" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="150.783" y="115.589" width="4.19913" height="4.19913" fill="#618346"/>
            <rect x="154.982" y="115.589" width="4.19913" height="4.19913" fill="#4D7627"/>
            <rect x="91.9961" y="119.788" width="4.19913" height="4.19913" fill="#F6FFFF"/>
            <rect x="96.1953" y="119.788" width="4.19913" height="4.19913" fill="#FAFAFA"/>
            <rect x="100.395" y="119.788" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="104.592" y="119.788" width="4.19913" height="4.19913" fill="white"/>
            <rect x="108.793" y="119.788" width="4.19913" height="4.19913" fill="#E0E0E0"/>
            <rect x="112.99" y="119.788" width="4.19913" height="4.19913" fill="#F8F5EC"/>
            <rect x="117.191" y="119.788" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="121.389" y="119.788" width="4.19913" height="4.19913" fill="#FEFFFB"/>
            <rect x="125.588" y="119.788" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="119.788" width="4.19913" height="4.19913" fill="#EDF2EC"/>
            <rect x="133.986" y="119.788" width="4.19913" height="4.19913" fill="#FDFDFB"/>
            <rect x="138.188" y="119.788" width="4.19913" height="4.19913" fill="#F9FFFF"/>
            <rect x="142.385" y="119.788" width="4.19913" height="4.19913" fill="#FFFFFB"/>
            <rect x="146.586" y="119.788" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="150.783" y="119.788" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="154.982" y="119.788" width="4.19913" height="4.19913" fill="#F8FFF0"/>
            <rect x="91.9961" y="123.987" width="4.19913" height="4.19913" fill="#FAFAFA"/>
            <rect x="96.1953" y="123.987" width="4.19913" height="4.19913" fill="#FCFCFA"/>
            <rect x="100.395" y="123.987" width="4.19913" height="4.19913" fill="#396544"/>
            <rect x="104.592" y="123.987" width="4.19913" height="4.19913" fill="#2F5435"/>
            <rect x="108.793" y="123.987" width="4.19913" height="4.19913" fill="#DFDCE3"/>
            <rect x="112.99" y="123.987" width="4.19913" height="4.19913" fill="#35553D"/>
            <rect x="117.191" y="123.987" width="4.19913" height="4.19913" fill="white"/>
            <rect x="121.389" y="123.987" width="4.19913" height="4.19913" fill="white"/>
            <rect x="125.588" y="123.987" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="123.987" width="4.19913" height="4.19913" fill="#F4F4F4"/>
            <rect x="133.986" y="123.987" width="4.19913" height="4.19913" fill="#2D4434"/>
            <rect x="138.188" y="123.987" width="4.19913" height="4.19913" fill="#224E2B"/>
            <rect x="142.385" y="123.987" width="4.19913" height="4.19913" fill="#37573F"/>
            <rect x="146.586" y="123.987" width="4.19913" height="4.19913" fill="#22502C"/>
            <rect x="150.783" y="123.987" width="4.19913" height="4.19913" fill="#2D4F36"/>
            <rect x="154.982" y="123.987" width="4.19913" height="4.19913" fill="white"/>
            <rect x="159.182" y="123.987" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="91.9961" y="128.187" width="4.19913" height="4.19913" fill="#F8F8F8"/>
            <rect x="96.1953" y="128.187" width="4.19913" height="4.19913" fill="#3B6847"/>
            <rect x="100.395" y="128.187" width="4.19913" height="4.19913" fill="#33603F"/>
            <rect x="104.592" y="128.187" width="4.19913" height="4.19913" fill="#547F2D"/>
            <rect x="108.793" y="128.187" width="4.19913" height="4.19913" fill="#446C2D"/>
            <rect x="112.99" y="128.187" width="4.19913" height="4.19913" fill="#295834"/>
            <rect x="117.191" y="128.187" width="4.19913" height="4.19913" fill="#356243"/>
            <rect x="121.389" y="128.187" width="4.19913" height="4.19913" fill="#FEFCFD"/>
            <rect x="125.588" y="128.187" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="128.187" width="4.19913" height="4.19913" fill="#314333"/>
            <rect x="133.986" y="128.187" width="4.19913" height="4.19913" fill="#1C4928"/>
            <rect x="138.188" y="128.187" width="4.19913" height="4.19913" fill="#24502D"/>
            <rect x="142.385" y="128.187" width="4.19913" height="4.19913" fill="#245132"/>
            <rect x="146.586" y="128.187" width="4.19913" height="4.19913" fill="#23552F"/>
            <rect x="150.783" y="128.187" width="4.19913" height="4.19913" fill="#28512F"/>
            <rect x="154.982" y="128.187" width="4.19913" height="4.19913" fill="#FBFFFF"/>
            <rect x="159.182" y="128.187" width="4.19913" height="4.19913" fill="#274430"/>
            <rect x="91.9961" y="132.385" width="4.19913" height="4.19913" fill="#63903F"/>
            <rect x="96.1953" y="132.385" width="4.19913" height="4.19913" fill="#5E8937"/>
            <rect x="100.395" y="132.385" width="4.19913" height="4.19913" fill="#5F8D35"/>
            <rect x="104.592" y="132.385" width="4.19913" height="4.19913" fill="#587F2E"/>
            <rect x="108.793" y="132.385" width="4.19913" height="4.19913" fill="#47711F"/>
            <rect x="112.99" y="132.385" width="4.19913" height="4.19913" fill="#4E7C33"/>
            <rect x="117.191" y="132.385" width="4.19913" height="4.19913" fill="#537F42"/>
            <rect x="121.389" y="132.385" width="4.19913" height="4.19913" fill="#558637"/>
            <rect x="125.588" y="132.385" width="4.19913" height="4.19913" fill="#275332"/>
            <rect x="129.787" y="132.385" width="4.19913" height="4.19913" fill="#255233"/>
            <rect x="133.986" y="132.385" width="4.19913" height="4.19913" fill="#25512D"/>
            <rect x="138.188" y="132.385" width="4.19913" height="4.19913" fill="#537F2A"/>
            <rect x="142.385" y="132.385" width="4.19913" height="4.19913" fill="#2B5724"/>
            <rect x="146.586" y="132.385" width="4.19913" height="4.19913" fill="#527F22"/>
            <rect x="150.783" y="132.385" width="4.19913" height="4.19913" fill="#53793C"/>
            <rect x="154.982" y="132.385" width="4.19913" height="4.19913" fill="#49771F"/>
            <rect x="159.182" y="132.385" width="4.19913" height="4.19913" fill="#4A7627"/>
            <rect x="83.5977" y="136.584" width="4.19913" height="4.19913" fill="#F2FBFF"/>
            <rect x="87.7969" y="136.584" width="4.19913" height="4.19913" fill="#C2C6C5"/>
            <rect x="91.9961" y="136.584" width="4.19913" height="4.19913" fill="#668051"/>
            <rect x="96.1953" y="136.584" width="4.19913" height="4.19913" fill="#F9FDFC"/>
            <rect x="100.395" y="136.584" width="4.19913" height="4.19913" fill="#638046"/>
            <rect x="104.592" y="136.584" width="4.19913" height="4.19913" fill="#597F32"/>
            <rect x="108.793" y="136.584" width="4.19913" height="4.19913" fill="#497128"/>
            <rect x="112.99" y="136.584" width="4.19913" height="4.19913" fill="#588238"/>
            <rect x="117.191" y="136.584" width="4.19913" height="4.19913" fill="#5D8839"/>
            <rect x="121.389" y="136.584" width="4.19913" height="4.19913" fill="#5A8239"/>
            <rect x="125.588" y="136.584" width="4.19913" height="4.19913" fill="#537F34"/>
            <rect x="129.787" y="136.584" width="4.19913" height="4.19913" fill="#5D8336"/>
            <rect x="133.986" y="136.584" width="4.19913" height="4.19913" fill="#4F782C"/>
            <rect x="138.188" y="136.584" width="4.19913" height="4.19913" fill="#547F30"/>
            <rect x="142.385" y="136.584" width="4.19913" height="4.19913" fill="#587E31"/>
            <rect x="146.586" y="136.584" width="4.19913" height="4.19913" fill="#527C32"/>
            <rect x="150.783" y="136.584" width="4.19913" height="4.19913" fill="#F9FFF8"/>
            <rect x="154.982" y="136.584" width="4.19913" height="4.19913" fill="#F9FFFB"/>
            <rect x="159.182" y="136.584" width="4.19913" height="4.19913" fill="#517629"/>
            <rect x="163.381" y="136.584" width="4.19913" height="4.19913" fill="#537E36"/>
            <rect x="79.3984" y="140.783" width="4.19913" height="4.19913" fill="#F4FEFF"/>
            <rect x="83.5977" y="140.783" width="4.19913" height="4.19913" fill="#FEFAFB"/>
            <rect x="87.7969" y="140.783" width="4.19913" height="4.19913" fill="#C3C3C3"/>
            <rect x="91.9961" y="140.783" width="4.19913" height="4.19913" fill="#F8F8F8"/>
            <rect x="96.1953" y="140.783" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="100.395" y="140.783" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="104.592" y="140.783" width="4.19913" height="4.19913" fill="#5E7B3B"/>
            <rect x="108.793" y="140.783" width="4.19913" height="4.19913" fill="#4F7623"/>
            <rect x="112.99" y="140.783" width="4.19913" height="4.19913" fill="#598635"/>
            <rect x="117.191" y="140.783" width="4.19913" height="4.19913" fill="#F1FFE4"/>
            <rect x="121.389" y="140.783" width="4.19913" height="4.19913" fill="#F8FEFA"/>
            <rect x="125.588" y="140.783" width="4.19913" height="4.19913" fill="#F7FFE7"/>
            <rect x="129.787" y="140.783" width="4.19913" height="4.19913" fill="#F4F4F4"/>
            <rect x="133.986" y="140.783" width="4.19913" height="4.19913" fill="#4E712F"/>
            <rect x="138.188" y="140.783" width="4.19913" height="4.19913" fill="#57812D"/>
            <rect x="142.385" y="140.783" width="4.19913" height="4.19913" fill="#56822D"/>
            <rect x="146.586" y="140.783" width="4.19913" height="4.19913" fill="#548130"/>
            <rect x="150.783" y="140.783" width="4.19913" height="4.19913" fill="#F8FEF0"/>
            <rect x="154.982" y="140.783" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="159.182" y="140.783" width="4.19913" height="4.19913" fill="#FCFFF3"/>
            <rect x="163.381" y="140.783" width="4.19913" height="4.19913" fill="#F7FFEA"/>
            <rect x="167.58" y="140.783" width="4.19913" height="4.19913" fill="#FFFFFD"/>
            <rect x="79.3984" y="144.982" width="4.19913" height="4.19913" fill="#F3FDFF"/>
            <rect x="83.5977" y="144.982" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="87.7969" y="144.982" width="4.19913" height="4.19913" fill="#C2C2C2"/>
            <rect x="91.9961" y="144.982" width="4.19913" height="4.19913" fill="#F7F7F9"/>
            <rect x="96.1953" y="144.982" width="4.19913" height="4.19913" fill="#3D5A44"/>
            <rect x="100.395" y="144.982" width="4.19913" height="4.19913" fill="#FBFBFD"/>
            <rect x="104.592" y="144.982" width="4.19913" height="4.19913" fill="white"/>
            <rect x="108.793" y="144.982" width="4.19913" height="4.19913" fill="#DBE0D9"/>
            <rect x="112.99" y="144.982" width="4.19913" height="4.19913" fill="#FBFFFA"/>
            <rect x="117.191" y="144.982" width="4.19913" height="4.19913" fill="#FEFCFD"/>
            <rect x="121.389" y="144.982" width="4.19913" height="4.19913" fill="#FDFDFB"/>
            <rect x="125.588" y="144.982" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="144.982" width="4.19913" height="4.19913" fill="#F2F2F2"/>
            <rect x="133.986" y="144.982" width="4.19913" height="4.19913" fill="#FFFDFE"/>
            <rect x="138.188" y="144.982" width="4.19913" height="4.19913" fill="#507236"/>
            <rect x="142.385" y="144.982" width="4.19913" height="4.19913" fill="#FEFFFD"/>
            <rect x="146.586" y="144.982" width="4.19913" height="4.19913" fill="#547832"/>
            <rect x="150.783" y="144.982" width="4.19913" height="4.19913" fill="white"/>
            <rect x="154.982" y="144.982" width="4.19913" height="4.19913" fill="#FFFEFF"/>
            <rect x="159.182" y="144.982" width="4.19913" height="4.19913" fill="#FEFFFF"/>
            <rect x="163.381" y="144.982" width="4.19913" height="4.19913" fill="white"/>
            <rect x="167.58" y="144.982" width="4.19913" height="4.19913" fill="#FEFFFF"/>
            <rect x="171.779" y="144.982" width="4.19913" height="4.19913" fill="#26583D"/>
            <rect x="83.5977" y="149.182" width="4.19913" height="4.19913" fill="#315E47"/>
            <rect x="87.7969" y="149.182" width="4.19913" height="4.19913" fill="#C5C0C4"/>
            <rect x="91.9961" y="149.182" width="4.19913" height="4.19913" fill="#3E724C"/>
            <rect x="96.1953" y="149.182" width="4.19913" height="4.19913" fill="#416A48"/>
            <rect x="100.395" y="149.182" width="4.19913" height="4.19913" fill="#386544"/>
            <rect x="104.592" y="149.182" width="4.19913" height="4.19913" fill="#F9FFFA"/>
            <rect x="108.793" y="149.182" width="4.19913" height="4.19913" fill="#203A2D"/>
            <rect x="112.99" y="149.182" width="4.19913" height="4.19913" fill="#F8FFFA"/>
            <rect x="117.191" y="149.182" width="4.19913" height="4.19913" fill="white"/>
            <rect x="121.389" y="149.182" width="4.19913" height="4.19913" fill="white"/>
            <rect x="125.588" y="149.182" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="149.182" width="4.19913" height="4.19913" fill="#264A2E"/>
            <rect x="133.986" y="149.182" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="138.188" y="149.182" width="4.19913" height="4.19913" fill="#2C4734"/>
            <rect x="142.385" y="149.182" width="4.19913" height="4.19913" fill="#FFFDFD"/>
            <rect x="146.586" y="149.182" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="150.783" y="149.182" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="154.982" y="149.182" width="4.19913" height="4.19913" fill="#274B31"/>
            <rect x="159.182" y="149.182" width="4.19913" height="4.19913" fill="#224B2D"/>
            <rect x="163.381" y="149.182" width="4.19913" height="4.19913" fill="white"/>
            <rect x="167.58" y="149.182" width="4.19913" height="4.19913" fill="#26522F"/>
            <rect x="171.779" y="149.182" width="4.19913" height="4.19913" fill="#2C5537"/>
            <rect x="79.3984" y="153.381" width="4.19913" height="4.19913" fill="#44664D"/>
            <rect x="83.5977" y="153.381" width="4.19913" height="4.19913" fill="#35633F"/>
            <rect x="87.7969" y="153.381" width="4.19913" height="4.19913" fill="#3B601B"/>
            <rect x="91.9961" y="153.381" width="4.19913" height="4.19913" fill="#3D6C48"/>
            <rect x="96.1953" y="153.381" width="4.19913" height="4.19913" fill="#618F51"/>
            <rect x="100.395" y="153.381" width="4.19913" height="4.19913" fill="#33613D"/>
            <rect x="104.592" y="153.381" width="4.19913" height="4.19913" fill="#548146"/>
            <rect x="108.793" y="153.381" width="4.19913" height="4.19913" fill="#244C27"/>
            <rect x="112.99" y="153.381" width="4.19913" height="4.19913" fill="#30573A"/>
            <rect x="117.191" y="153.381" width="4.19913" height="4.19913" fill="#F1FFF7"/>
            <rect x="121.389" y="153.381" width="4.19913" height="4.19913" fill="#FDFFFC"/>
            <rect x="125.588" y="153.381" width="4.19913" height="4.19913" fill="#275531"/>
            <rect x="129.787" y="153.381" width="4.19913" height="4.19913" fill="#265430"/>
            <rect x="133.986" y="153.381" width="4.19913" height="4.19913" fill="#4C7730"/>
            <rect x="138.188" y="153.381" width="4.19913" height="4.19913" fill="#22512D"/>
            <rect x="142.385" y="153.381" width="4.19913" height="4.19913" fill="#265531"/>
            <rect x="146.586" y="153.381" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="150.783" y="153.381" width="4.19913" height="4.19913" fill="#3C553F"/>
            <rect x="154.982" y="153.381" width="4.19913" height="4.19913" fill="#194B28"/>
            <rect x="159.182" y="153.381" width="4.19913" height="4.19913" fill="#1D4926"/>
            <rect x="163.381" y="153.381" width="4.19913" height="4.19913" fill="#1F4E2A"/>
            <rect x="167.58" y="153.381" width="4.19913" height="4.19913" fill="#21502E"/>
            <rect x="171.779" y="153.381" width="4.19913" height="4.19913" fill="#578233"/>
            <rect x="75.1992" y="157.58" width="4.19913" height="4.19913" fill="#FCFCFA"/>
            <rect x="79.3984" y="157.58" width="4.19913" height="4.19913" fill="#FDFFFC"/>
            <rect x="83.5977" y="157.58" width="4.19913" height="4.19913" fill="#63883B"/>
            <rect x="87.7969" y="157.58" width="4.19913" height="4.19913" fill="#3C611B"/>
            <rect x="91.9961" y="157.58" width="4.19913" height="4.19913" fill="#658E40"/>
            <rect x="96.1953" y="157.58" width="4.19913" height="4.19913" fill="#68904A"/>
            <rect x="100.395" y="157.58" width="4.19913" height="4.19913" fill="#5C8134"/>
            <rect x="104.592" y="157.58" width="4.19913" height="4.19913" fill="#5C8134"/>
            <rect x="108.793" y="157.58" width="4.19913" height="4.19913" fill="#517130"/>
            <rect x="112.99" y="157.58" width="4.19913" height="4.19913" fill="#3C6336"/>
            <rect x="117.191" y="157.58" width="4.19913" height="4.19913" fill="#3A6345"/>
            <rect x="121.389" y="157.58" width="4.19913" height="4.19913" fill="#2F5E34"/>
            <rect x="125.588" y="157.58" width="4.19913" height="4.19913" fill="#335B40"/>
            <rect x="129.787" y="157.58" width="4.19913" height="4.19913" fill="#587A2D"/>
            <rect x="133.986" y="157.58" width="4.19913" height="4.19913" fill="#587B39"/>
            <rect x="138.188" y="157.58" width="4.19913" height="4.19913" fill="#557E30"/>
            <rect x="142.385" y="157.58" width="4.19913" height="4.19913" fill="#335A2B"/>
            <rect x="146.586" y="157.58" width="4.19913" height="4.19913" fill="#5A7D3B"/>
            <rect x="150.783" y="157.58" width="4.19913" height="4.19913" fill="#2F582C"/>
            <rect x="154.982" y="157.58" width="4.19913" height="4.19913" fill="#254F29"/>
            <rect x="159.182" y="157.58" width="4.19913" height="4.19913" fill="#527B2D"/>
            <rect x="163.381" y="157.58" width="4.19913" height="4.19913" fill="#537C2E"/>
            <rect x="167.58" y="157.58" width="4.19913" height="4.19913" fill="#FAFFF9"/>
            <rect x="171.779" y="157.58" width="4.19913" height="4.19913" fill="#60813A"/>
            <rect x="71" y="161.779" width="4.19913" height="4.19913" fill="#F6F7F9"/>
            <rect x="75.1992" y="161.779" width="4.19913" height="4.19913" fill="#F7F7F7"/>
            <rect x="79.3984" y="161.779" width="4.19913" height="4.19913" fill="#689145"/>
            <rect x="83.5977" y="161.779" width="4.19913" height="4.19913" fill="#628C38"/>
            <rect x="87.7969" y="161.779" width="4.19913" height="4.19913" fill="#3D6618"/>
            <rect x="91.9961" y="161.779" width="4.19913" height="4.19913" fill="#689341"/>
            <rect x="96.1953" y="161.779" width="4.19913" height="4.19913" fill="#6C9342"/>
            <rect x="100.395" y="161.779" width="4.19913" height="4.19913" fill="#638C3E"/>
            <rect x="104.592" y="161.779" width="4.19913" height="4.19913" fill="#5E8534"/>
            <rect x="108.793" y="161.779" width="4.19913" height="4.19913" fill="#4E7323"/>
            <rect x="112.99" y="161.779" width="4.19913" height="4.19913" fill="#5C8833"/>
            <rect x="117.191" y="161.779" width="4.19913" height="4.19913" fill="#5D8A35"/>
            <rect x="121.389" y="161.779" width="4.19913" height="4.19913" fill="#5C8737"/>
            <rect x="125.588" y="161.779" width="4.19913" height="4.19913" fill="#578031"/>
            <rect x="129.787" y="161.779" width="4.19913" height="4.19913" fill="#577C2C"/>
            <rect x="133.986" y="161.779" width="4.19913" height="4.19913" fill="#527B2C"/>
            <rect x="138.188" y="161.779" width="4.19913" height="4.19913" fill="#5A8130"/>
            <rect x="142.385" y="161.779" width="4.19913" height="4.19913" fill="#5A8430"/>
            <rect x="146.586" y="161.779" width="4.19913" height="4.19913" fill="#558030"/>
            <rect x="150.783" y="161.779" width="4.19913" height="4.19913" fill="#588037"/>
            <rect x="154.982" y="161.779" width="4.19913" height="4.19913" fill="#4E7927"/>
            <rect x="159.182" y="161.779" width="4.19913" height="4.19913" fill="#527D2B"/>
            <rect x="163.381" y="161.779" width="4.19913" height="4.19913" fill="#F7FFF8"/>
            <rect x="167.58" y="161.779" width="4.19913" height="4.19913" fill="white"/>
            <rect x="171.779" y="161.779" width="4.19913" height="4.19913" fill="#FAFFFF"/>
            <rect x="75.1992" y="165.979" width="4.19913" height="4.19913" fill="#728F61"/>
            <rect x="79.3984" y="165.979" width="4.19913" height="4.19913" fill="#628D3D"/>
            <rect x="83.5977" y="165.979" width="4.19913" height="4.19913" fill="#5F8937"/>
            <rect x="87.7969" y="165.979" width="4.19913" height="4.19913" fill="#3D661A"/>
            <rect x="91.9961" y="165.979" width="4.19913" height="4.19913" fill="#628D3B"/>
            <rect x="96.1953" y="165.979" width="4.19913" height="4.19913" fill="#F6F6F8"/>
            <rect x="100.395" y="165.979" width="4.19913" height="4.19913" fill="#698646"/>
            <rect x="104.592" y="165.979" width="4.19913" height="4.19913" fill="#5D8433"/>
            <rect x="108.793" y="165.979" width="4.19913" height="4.19913" fill="#4D7222"/>
            <rect x="112.99" y="165.979" width="4.19913" height="4.19913" fill="#598434"/>
            <rect x="117.191" y="165.979" width="4.19913" height="4.19913" fill="#5D8836"/>
            <rect x="121.389" y="165.979" width="4.19913" height="4.19913" fill="#5D8637"/>
            <rect x="125.588" y="165.979" width="4.19913" height="4.19913" fill="#537E2F"/>
            <rect x="129.787" y="165.979" width="4.19913" height="4.19913" fill="#557C29"/>
            <rect x="133.986" y="165.979" width="4.19913" height="4.19913" fill="#547B2C"/>
            <rect x="138.188" y="165.979" width="4.19913" height="4.19913" fill="#5A822C"/>
            <rect x="142.385" y="165.979" width="4.19913" height="4.19913" fill="#557F2D"/>
            <rect x="146.586" y="165.979" width="4.19913" height="4.19913" fill="#527D2D"/>
            <rect x="150.783" y="165.979" width="4.19913" height="4.19913" fill="#5E833D"/>
            <rect x="154.982" y="165.979" width="4.19913" height="4.19913" fill="#4F7B24"/>
            <rect x="159.182" y="165.979" width="4.19913" height="4.19913" fill="#4F7829"/>
            <rect x="163.381" y="165.979" width="4.19913" height="4.19913" fill="#4E7E28"/>
            <rect x="167.58" y="165.979" width="4.19913" height="4.19913" fill="#FFFFF1"/>
            <rect x="171.779" y="165.979" width="4.19913" height="4.19913" fill="white"/>
            <rect x="175.979" y="165.979" width="4.19913" height="4.19913" fill="#FEFFFF"/>
            <rect x="71" y="170.178" width="4.19913" height="4.19913" fill="#FCFCFE"/>
            <rect x="75.1992" y="170.178" width="4.19913" height="4.19913" fill="#FCFFF4"/>
            <rect x="79.3984" y="170.178" width="4.19913" height="4.19913" fill="#FAFEFD"/>
            <rect x="83.5977" y="170.178" width="4.19913" height="4.19913" fill="white"/>
            <rect x="87.7969" y="170.178" width="4.19913" height="4.19913" fill="#BFBFC7"/>
            <rect x="91.9961" y="170.178" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="96.1953" y="170.178" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="100.395" y="170.178" width="4.19913" height="4.19913" fill="#669138"/>
            <rect x="104.592" y="170.178" width="4.19913" height="4.19913" fill="#5B8231"/>
            <rect x="108.793" y="170.178" width="4.19913" height="4.19913" fill="#4E722A"/>
            <rect x="112.99" y="170.178" width="4.19913" height="4.19913" fill="#5C8A32"/>
            <rect x="117.191" y="170.178" width="4.19913" height="4.19913" fill="#F5FFEC"/>
            <rect x="121.389" y="170.178" width="4.19913" height="4.19913" fill="#FEFFFB"/>
            <rect x="125.588" y="170.178" width="4.19913" height="4.19913" fill="#557438"/>
            <rect x="129.787" y="170.178" width="4.19913" height="4.19913" fill="#527F22"/>
            <rect x="133.986" y="170.178" width="4.19913" height="4.19913" fill="#F6FFEF"/>
            <rect x="138.188" y="170.178" width="4.19913" height="4.19913" fill="white"/>
            <rect x="142.385" y="170.178" width="4.19913" height="4.19913" fill="#F9FFF3"/>
            <rect x="146.586" y="170.178" width="4.19913" height="4.19913" fill="#FCFFF8"/>
            <rect x="150.783" y="170.178" width="4.19913" height="4.19913" fill="#F7FFFB"/>
            <rect x="154.982" y="170.178" width="4.19913" height="4.19913" fill="#4B7C21"/>
            <rect x="159.182" y="170.178" width="4.19913" height="4.19913" fill="#4E7F24"/>
            <rect x="163.381" y="170.178" width="4.19913" height="4.19913" fill="#F4FFFD"/>
            <rect x="167.58" y="170.178" width="4.19913" height="4.19913" fill="white"/>
            <rect x="171.779" y="170.178" width="4.19913" height="4.19913" fill="white"/>
            <rect x="175.979" y="170.178" width="4.19913" height="4.19913" fill="white"/>
            <rect x="180.178" y="170.178" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="71" y="174.377" width="4.19913" height="4.19913" fill="#F8F8F8"/>
            <rect x="75.1992" y="174.377" width="4.19913" height="4.19913" fill="#F8F8F8"/>
            <rect x="79.3984" y="174.377" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="83.5977" y="174.377" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="87.7969" y="174.377" width="4.19913" height="4.19913" fill="#C4C4C4"/>
            <rect x="91.9961" y="174.377" width="4.19913" height="4.19913" fill="#F8F8F8"/>
            <rect x="96.1953" y="174.377" width="4.19913" height="4.19913" fill="#FAFAFA"/>
            <rect x="100.395" y="174.377" width="4.19913" height="4.19913" fill="#63823F"/>
            <rect x="104.592" y="174.377" width="4.19913" height="4.19913" fill="#FFFFFB"/>
            <rect x="108.793" y="174.377" width="4.19913" height="4.19913" fill="#DAE5D7"/>
            <rect x="112.99" y="174.377" width="4.19913" height="4.19913" fill="#F9FFF3"/>
            <rect x="117.191" y="174.377" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="121.389" y="174.377" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="125.588" y="174.377" width="4.19913" height="4.19913" fill="#FBFCF6"/>
            <rect x="129.787" y="174.377" width="4.19913" height="4.19913" fill="#537A27"/>
            <rect x="133.986" y="174.377" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="138.188" y="174.377" width="4.19913" height="4.19913" fill="white"/>
            <rect x="142.385" y="174.377" width="4.19913" height="4.19913" fill="white"/>
            <rect x="146.586" y="174.377" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="150.783" y="174.377" width="4.19913" height="4.19913" fill="white"/>
            <rect x="154.982" y="174.377" width="4.19913" height="4.19913" fill="#FBFEF5"/>
            <rect x="159.182" y="174.377" width="4.19913" height="4.19913" fill="#F7F7F9"/>
            <rect x="163.381" y="174.377" width="4.19913" height="4.19913" fill="#FFFBF8"/>
            <rect x="167.58" y="174.377" width="4.19913" height="4.19913" fill="white"/>
            <rect x="171.779" y="174.377" width="4.19913" height="4.19913" fill="white"/>
            <rect x="175.979" y="174.377" width="4.19913" height="4.19913" fill="white"/>
            <rect x="71" y="178.576" width="4.19913" height="4.19913" fill="#F7F7F7"/>
            <rect x="75.1992" y="178.576" width="4.19913" height="4.19913" fill="#F7F7F7"/>
            <rect x="79.3984" y="178.576" width="4.19913" height="4.19913" fill="#FBFCFE"/>
            <rect x="83.5977" y="178.576" width="4.19913" height="4.19913" fill="#F5FFF8"/>
            <rect x="87.7969" y="178.576" width="4.19913" height="4.19913" fill="#C2C4C3"/>
            <rect x="91.9961" y="178.576" width="4.19913" height="4.19913" fill="#F8F8F8"/>
            <rect x="96.1953" y="178.576" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="100.395" y="178.576" width="4.19913" height="4.19913" fill="#FCFAFB"/>
            <rect x="104.592" y="178.576" width="4.19913" height="4.19913" fill="white"/>
            <rect x="108.793" y="178.576" width="4.19913" height="4.19913" fill="#DFDFDF"/>
            <rect x="112.99" y="178.576" width="4.19913" height="4.19913" fill="white"/>
            <rect x="117.191" y="178.576" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="121.389" y="178.576" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="125.588" y="178.576" width="4.19913" height="4.19913" fill="white"/>
            <rect x="129.787" y="178.576" width="4.19913" height="4.19913" fill="#F2F2F4"/>
            <rect x="133.986" y="178.576" width="4.19913" height="4.19913" fill="white"/>
            <rect x="138.188" y="178.576" width="4.19913" height="4.19913" fill="white"/>
            <rect x="142.385" y="178.576" width="4.19913" height="4.19913" fill="white"/>
            <rect x="146.586" y="178.576" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="150.783" y="178.576" width="4.19913" height="4.19913" fill="#FFFDFF"/>
            <rect x="154.982" y="178.576" width="4.19913" height="4.19913" fill="white"/>
            <rect x="159.182" y="178.576" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="163.381" y="178.576" width="4.19913" height="4.19913" fill="#FFFEFF"/>
            <rect x="167.58" y="178.576" width="4.19913" height="4.19913" fill="white"/>
            <rect x="171.779" y="178.576" width="4.19913" height="4.19913" fill="#FEFEFC"/>
            <rect x="175.979" y="178.576" width="4.19913" height="4.19913" fill="#FFFDFE"/>
            <rect x="180.178" y="178.576" width="4.19913" height="4.19913" fill="#FAFFFF"/>
            <rect x="71" y="182.775" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="75.1992" y="182.775" width="4.19913" height="4.19913" fill="#FAFAFA"/>
            <rect x="79.3984" y="182.775" width="4.19913" height="4.19913" fill="#456E4C"/>
            <rect x="83.5977" y="182.775" width="4.19913" height="4.19913" fill="#3D6B47"/>
            <rect x="87.7969" y="182.775" width="4.19913" height="4.19913" fill="#C4C4C4"/>
            <rect x="91.9961" y="182.775" width="4.19913" height="4.19913" fill="#FAFAFA"/>
            <rect x="96.1953" y="182.775" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="100.395" y="182.775" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="104.592" y="182.775" width="4.19913" height="4.19913" fill="#395441"/>
            <rect x="108.793" y="182.775" width="4.19913" height="4.19913" fill="#E7DEE1"/>
            <rect x="112.99" y="182.775" width="4.19913" height="4.19913" fill="white"/>
            <rect x="117.191" y="182.775" width="4.19913" height="4.19913" fill="white"/>
            <rect x="121.389" y="182.775" width="4.19913" height="4.19913" fill="#FFFEFF"/>
            <rect x="125.588" y="182.775" width="4.19913" height="4.19913" fill="#FFFEFF"/>
            <rect x="129.787" y="182.775" width="4.19913" height="4.19913" fill="#F5F5F5"/>
            <rect x="133.986" y="182.775" width="4.19913" height="4.19913" fill="white"/>
            <rect x="138.188" y="182.775" width="4.19913" height="4.19913" fill="white"/>
            <rect x="142.385" y="182.775" width="4.19913" height="4.19913" fill="#364E40"/>
            <rect x="146.586" y="182.775" width="4.19913" height="4.19913" fill="#2C5B37"/>
            <rect x="150.783" y="182.775" width="4.19913" height="4.19913" fill="#32593A"/>
            <rect x="154.982" y="182.775" width="4.19913" height="4.19913" fill="white"/>
            <rect x="159.182" y="182.775" width="4.19913" height="4.19913" fill="white"/>
            <rect x="163.381" y="182.775" width="4.19913" height="4.19913" fill="#2C4E35"/>
            <rect x="167.58" y="182.775" width="4.19913" height="4.19913" fill="white"/>
            <rect x="171.779" y="182.775" width="4.19913" height="4.19913" fill="#375A42"/>
            <rect x="175.979" y="182.775" width="4.19913" height="4.19913" fill="#FBFFFF"/>
            <rect x="180.178" y="182.775" width="4.19913" height="4.19913" fill="#FEFFFF"/>
            <rect x="75.1992" y="186.974" width="4.19913" height="4.19913" fill="#497659"/>
            <rect x="79.3984" y="186.974" width="4.19913" height="4.19913" fill="#487451"/>
            <rect x="83.5977" y="186.974" width="4.19913" height="4.19913" fill="#F7FFF8"/>
            <rect x="87.7969" y="186.974" width="4.19913" height="4.19913" fill="#C6C5C3"/>
            <rect x="91.9961" y="186.974" width="4.19913" height="4.19913" fill="#F5FFFA"/>
            <rect x="96.1953" y="186.974" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="100.395" y="186.974" width="4.19913" height="4.19913" fill="#3B523E"/>
            <rect x="104.592" y="186.974" width="4.19913" height="4.19913" fill="#376541"/>
            <rect x="108.793" y="186.974" width="4.19913" height="4.19913" fill="#2B4F33"/>
            <rect x="112.99" y="186.974" width="4.19913" height="4.19913" fill="white"/>
            <rect x="117.191" y="186.974" width="4.19913" height="4.19913" fill="white"/>
            <rect x="121.389" y="186.974" width="4.19913" height="4.19913" fill="#376944"/>
            <rect x="125.588" y="186.974" width="4.19913" height="4.19913" fill="#2E5D39"/>
            <rect x="129.787" y="186.974" width="4.19913" height="4.19913" fill="#F0FBF3"/>
            <rect x="133.986" y="186.974" width="4.19913" height="4.19913" fill="white"/>
            <rect x="138.188" y="186.974" width="4.19913" height="4.19913" fill="#35513B"/>
            <rect x="142.385" y="186.974" width="4.19913" height="4.19913" fill="#2C5E39"/>
            <rect x="146.586" y="186.974" width="4.19913" height="4.19913" fill="#2B5D38"/>
            <rect x="150.783" y="186.974" width="4.19913" height="4.19913" fill="#2F5C3B"/>
            <rect x="154.982" y="186.974" width="4.19913" height="4.19913" fill="#285536"/>
            <rect x="163.381" y="186.974" width="4.19913" height="4.19913" fill="#275531"/>
            <rect x="167.58" y="186.974" width="4.19913" height="4.19913" fill="#285337"/>
            <rect x="175.979" y="186.974" width="4.19913" height="4.19913" fill="#285430"/>
            <rect x="180.178" y="186.974" width="4.19913" height="4.19913" fill="#254F39"/>
            <rect x="87.7969" y="191.173" width="4.19913" height="4.19913" fill="#204921"/>
            <rect x="91.9961" y="191.173" width="4.19913" height="4.19913" fill="#43764B"/>
            <rect x="96.1953" y="191.173" width="4.19913" height="4.19913" fill="#416855"/>
            <rect x="100.395" y="191.173" width="4.19913" height="4.19913" fill="#3D6A49"/>
            <rect x="104.592" y="191.173" width="4.19913" height="4.19913" fill="#37663C"/>
            <rect x="121.389" y="191.173" width="4.19913" height="4.19913" fill="#415F3D"/>
            <rect x="125.588" y="191.173" width="4.19913" height="4.19913" fill="#31613B"/>
            <rect x="129.787" y="191.173" width="4.19913" height="4.19913" fill="#2E5F3F"/>
            <rect x="107.029" y="134.381" width="6.61088" height="6.61088" transform="rotate(-180 107.029 134.381)" fill="#C50306"/>
            <rect x="136.117" y="112.564" width="6.61088" height="6.61088" transform="rotate(-180 136.117 112.564)" fill="#C50306"/>
            <rect x="126.861" y="86.7832" width="6.61088" height="6.61088" transform="rotate(-180 126.861 86.7832)" fill="#C50306"/>
            <rect x="160.248" y="154.544" width="6.61088" height="6.61088" transform="rotate(-180 160.248 154.544)" fill="#C50306"/>
            <rect x="118.268" y="176.69" width="6.61088" height="6.61088" transform="rotate(-180 118.268 176.69)" fill="#C50306"/>
            <rect x="85.2147" y="174.707" width="6.61088" height="6.61088" transform="rotate(-180 85.2147 174.707)" fill="#C50306"/>
            <rect x="171.814" y="173.385" width="6.61088" height="6.61088" transform="rotate(-180 171.814 173.385)" fill="#C50306"/>
            <rect x="406.588" y="201" width="4.19913" height="4.19913" fill="#F9F9F9"/>
            <rect x="402.389" y="205.199" width="4.19913" height="4.19913" fill="#F4FDFF"/>
            <rect x="406.588" y="205.199" width="4.19913" height="4.19913" fill="#F9F9F9"/>
            <rect x="410.787" y="205.199" width="4.19913" height="4.19913" fill="#EBEFF0"/>
            <rect x="402.389" y="209.398" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="406.588" y="209.398" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="209.398" width="4.19913" height="4.19913" fill="#EFEFEF"/>
            <rect x="414.986" y="209.398" width="4.19913" height="4.19913" fill="#335C4A"/>
            <rect x="398.191" y="213.598" width="4.19913" height="4.19913" fill="#EEEFE7"/>
            <rect x="402.389" y="213.598" width="4.19913" height="4.19913" fill="#F1F1F1"/>
            <rect x="406.588" y="213.598" width="4.19913" height="4.19913" fill="#EFEFEF"/>
            <rect x="410.787" y="213.598" width="4.19913" height="4.19913" fill="#ECECEC"/>
            <rect x="414.986" y="213.598" width="4.19913" height="4.19913" fill="#EEF8F0"/>
            <rect x="393.99" y="217.796" width="4.19913" height="4.19913" fill="#F7FFFF"/>
            <rect x="398.191" y="217.796" width="4.19913" height="4.19913" fill="#FDFFFC"/>
            <rect x="402.389" y="217.796" width="4.19913" height="4.19913" fill="#F9FFF6"/>
            <rect x="406.588" y="217.796" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="217.796" width="4.19913" height="4.19913" fill="#F2F2F2"/>
            <rect x="414.986" y="217.796" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="419.188" y="217.796" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="393.99" y="221.995" width="4.19913" height="4.19913" fill="#3F6568"/>
            <rect x="398.191" y="221.995" width="4.19913" height="4.19913" fill="#436E50"/>
            <rect x="402.389" y="221.995" width="4.19913" height="4.19913" fill="#3F714E"/>
            <rect x="406.588" y="221.995" width="4.19913" height="4.19913" fill="#EDFAF3"/>
            <rect x="410.787" y="221.995" width="4.19913" height="4.19913" fill="#F1F1F1"/>
            <rect x="414.986" y="221.995" width="4.19913" height="4.19913" fill="#F3FAF2"/>
            <rect x="419.188" y="221.995" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="389.793" y="226.194" width="4.19913" height="4.19913" fill="#34554E"/>
            <rect x="393.99" y="226.194" width="4.19913" height="4.19913" fill="#366342"/>
            <rect x="398.191" y="226.194" width="4.19913" height="4.19913" fill="#45734F"/>
            <rect x="402.389" y="226.194" width="4.19913" height="4.19913" fill="#43714D"/>
            <rect x="406.588" y="226.194" width="4.19913" height="4.19913" fill="#396743"/>
            <rect x="410.787" y="226.194" width="4.19913" height="4.19913" fill="#F1F6F0"/>
            <rect x="414.986" y="226.194" width="4.19913" height="4.19913" fill="#365840"/>
            <rect x="419.188" y="226.194" width="4.19913" height="4.19913" fill="#396645"/>
            <rect x="385.592" y="230.394" width="4.19913" height="4.19913" fill="#F2FFFF"/>
            <rect x="393.99" y="230.394" width="4.19913" height="4.19913" fill="#5F893F"/>
            <rect x="398.191" y="230.394" width="4.19913" height="4.19913" fill="#5A8A36"/>
            <rect x="402.389" y="230.394" width="4.19913" height="4.19913" fill="#5B8B37"/>
            <rect x="406.588" y="230.394" width="4.19913" height="4.19913" fill="#325F3E"/>
            <rect x="410.787" y="230.394" width="4.19913" height="4.19913" fill="#335B40"/>
            <rect x="414.986" y="230.394" width="4.19913" height="4.19913" fill="#547F38"/>
            <rect x="419.188" y="230.394" width="4.19913" height="4.19913" fill="#5A8334"/>
            <rect x="423.385" y="230.394" width="4.19913" height="4.19913" fill="#588242"/>
            <rect x="381.395" y="234.594" width="4.19913" height="4.19913" fill="#EFFCFF"/>
            <rect x="385.592" y="234.594" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="389.793" y="234.594" width="4.19913" height="4.19913" fill="#DBDBDB"/>
            <rect x="393.99" y="234.594" width="4.19913" height="4.19913" fill="#F8FFEA"/>
            <rect x="398.191" y="234.594" width="4.19913" height="4.19913" fill="#638F36"/>
            <rect x="402.389" y="234.594" width="4.19913" height="4.19913" fill="#5D833A"/>
            <rect x="406.588" y="234.594" width="4.19913" height="4.19913" fill="#5A8631"/>
            <rect x="410.787" y="234.594" width="4.19913" height="4.19913" fill="#5C822B"/>
            <rect x="414.986" y="234.594" width="4.19913" height="4.19913" fill="#577E2B"/>
            <rect x="419.188" y="234.594" width="4.19913" height="4.19913" fill="#5E8630"/>
            <rect x="423.385" y="234.594" width="4.19913" height="4.19913" fill="#FAFFF9"/>
            <rect x="427.586" y="234.594" width="4.19913" height="4.19913" fill="#F7FEFF"/>
            <rect x="381.395" y="238.793" width="4.19913" height="4.19913" fill="#FDFEF9"/>
            <rect x="385.592" y="238.793" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="389.793" y="238.793" width="4.19913" height="4.19913" fill="#E0E0E0"/>
            <rect x="393.99" y="238.793" width="4.19913" height="4.19913" fill="white"/>
            <rect x="398.191" y="238.793" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="402.389" y="238.793" width="4.19913" height="4.19913" fill="#FEFFF9"/>
            <rect x="406.588" y="238.793" width="4.19913" height="4.19913" fill="#54783B"/>
            <rect x="410.787" y="238.793" width="4.19913" height="4.19913" fill="#517827"/>
            <rect x="414.986" y="238.793" width="4.19913" height="4.19913" fill="#4D7828"/>
            <rect x="419.188" y="238.793" width="4.19913" height="4.19913" fill="#4F7A28"/>
            <rect x="423.385" y="238.793" width="4.19913" height="4.19913" fill="#FFFDFF"/>
            <rect x="427.586" y="238.793" width="4.19913" height="4.19913" fill="#FCFDFF"/>
            <rect x="431.783" y="238.793" width="4.19913" height="4.19913" fill="#F8FCFD"/>
            <rect x="381.395" y="242.991" width="4.19913" height="4.19913" fill="#355C57"/>
            <rect x="385.592" y="242.991" width="4.19913" height="4.19913" fill="#315A3C"/>
            <rect x="389.793" y="242.991" width="4.19913" height="4.19913" fill="#24482E"/>
            <rect x="393.99" y="242.991" width="4.19913" height="4.19913" fill="#F1F8F1"/>
            <rect x="398.191" y="242.991" width="4.19913" height="4.19913" fill="white"/>
            <rect x="402.389" y="242.991" width="4.19913" height="4.19913" fill="white"/>
            <rect x="406.588" y="242.991" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="242.991" width="4.19913" height="4.19913" fill="#EDEFE4"/>
            <rect x="414.986" y="242.991" width="4.19913" height="4.19913" fill="white"/>
            <rect x="419.188" y="242.991" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="423.385" y="242.991" width="4.19913" height="4.19913" fill="#FEFFFF"/>
            <rect x="427.586" y="242.991" width="4.19913" height="4.19913" fill="#375241"/>
            <rect x="431.783" y="242.991" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="381.395" y="247.19" width="4.19913" height="4.19913" fill="#366342"/>
            <rect x="385.592" y="247.19" width="4.19913" height="4.19913" fill="#315F3B"/>
            <rect x="389.793" y="247.19" width="4.19913" height="4.19913" fill="#1C4A26"/>
            <rect x="393.99" y="247.19" width="4.19913" height="4.19913" fill="#345B3E"/>
            <rect x="398.191" y="247.19" width="4.19913" height="4.19913" fill="#E9FEF5"/>
            <rect x="402.389" y="247.19" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="406.588" y="247.19" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="247.19" width="4.19913" height="4.19913" fill="#F3F3F3"/>
            <rect x="414.986" y="247.19" width="4.19913" height="4.19913" fill="#334C39"/>
            <rect x="419.188" y="247.19" width="4.19913" height="4.19913" fill="#295733"/>
            <rect x="423.385" y="247.19" width="4.19913" height="4.19913" fill="#315139"/>
            <rect x="427.586" y="247.19" width="4.19913" height="4.19913" fill="#295834"/>
            <rect x="431.783" y="247.19" width="4.19913" height="4.19913" fill="#36523B"/>
            <rect x="435.982" y="247.19" width="4.19913" height="4.19913" fill="#21502E"/>
            <rect x="377.195" y="251.39" width="4.19913" height="4.19913" fill="#67933C"/>
            <rect x="381.395" y="251.39" width="4.19913" height="4.19913" fill="#F2FFEC"/>
            <rect x="385.592" y="251.39" width="4.19913" height="4.19913" fill="#588439"/>
            <rect x="389.793" y="251.39" width="4.19913" height="4.19913" fill="#497128"/>
            <rect x="393.99" y="251.39" width="4.19913" height="4.19913" fill="#2B5D3A"/>
            <rect x="398.191" y="251.39" width="4.19913" height="4.19913" fill="#356042"/>
            <rect x="402.389" y="251.39" width="4.19913" height="4.19913" fill="#336240"/>
            <rect x="406.588" y="251.39" width="4.19913" height="4.19913" fill="#2C5B37"/>
            <rect x="410.787" y="251.39" width="4.19913" height="4.19913" fill="#264C37"/>
            <rect x="414.986" y="251.39" width="4.19913" height="4.19913" fill="#235031"/>
            <rect x="419.188" y="251.39" width="4.19913" height="4.19913" fill="#52813D"/>
            <rect x="423.385" y="251.39" width="4.19913" height="4.19913" fill="#588230"/>
            <rect x="427.586" y="251.39" width="4.19913" height="4.19913" fill="#528028"/>
            <rect x="431.783" y="251.39" width="4.19913" height="4.19913" fill="#558231"/>
            <rect x="435.982" y="251.39" width="4.19913" height="4.19913" fill="#4C7C16"/>
            <rect x="372.996" y="255.589" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="377.195" y="255.589" width="4.19913" height="4.19913" fill="#65853C"/>
            <rect x="381.395" y="255.589" width="4.19913" height="4.19913" fill="#F0F7F0"/>
            <rect x="385.592" y="255.589" width="4.19913" height="4.19913" fill="#FCFFF3"/>
            <rect x="389.793" y="255.589" width="4.19913" height="4.19913" fill="#496E20"/>
            <rect x="393.99" y="255.589" width="4.19913" height="4.19913" fill="#588230"/>
            <rect x="398.191" y="255.589" width="4.19913" height="4.19913" fill="#568132"/>
            <rect x="402.389" y="255.589" width="4.19913" height="4.19913" fill="#5C813B"/>
            <rect x="406.588" y="255.589" width="4.19913" height="4.19913" fill="#547B3A"/>
            <rect x="410.787" y="255.589" width="4.19913" height="4.19913" fill="#517626"/>
            <rect x="414.986" y="255.589" width="4.19913" height="4.19913" fill="#527C34"/>
            <rect x="419.188" y="255.589" width="4.19913" height="4.19913" fill="#577C2E"/>
            <rect x="423.385" y="255.589" width="4.19913" height="4.19913" fill="#547A2D"/>
            <rect x="427.586" y="255.589" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="431.783" y="255.589" width="4.19913" height="4.19913" fill="#618346"/>
            <rect x="435.982" y="255.589" width="4.19913" height="4.19913" fill="#4D7627"/>
            <rect x="372.996" y="259.788" width="4.19913" height="4.19913" fill="#F6FFFF"/>
            <rect x="377.195" y="259.788" width="4.19913" height="4.19913" fill="#FAFAFA"/>
            <rect x="381.395" y="259.788" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="385.592" y="259.788" width="4.19913" height="4.19913" fill="white"/>
            <rect x="389.793" y="259.788" width="4.19913" height="4.19913" fill="#E0E0E0"/>
            <rect x="393.99" y="259.788" width="4.19913" height="4.19913" fill="#F8F5EC"/>
            <rect x="398.191" y="259.788" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="402.389" y="259.788" width="4.19913" height="4.19913" fill="#FEFFFB"/>
            <rect x="406.588" y="259.788" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="259.788" width="4.19913" height="4.19913" fill="#EDF2EC"/>
            <rect x="414.986" y="259.788" width="4.19913" height="4.19913" fill="#FDFDFB"/>
            <rect x="419.188" y="259.788" width="4.19913" height="4.19913" fill="#F9FFFF"/>
            <rect x="423.385" y="259.788" width="4.19913" height="4.19913" fill="#FFFFFB"/>
            <rect x="427.586" y="259.788" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="431.783" y="259.788" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="435.982" y="259.788" width="4.19913" height="4.19913" fill="#F8FFF0"/>
            <rect x="372.996" y="263.987" width="4.19913" height="4.19913" fill="#FAFAFA"/>
            <rect x="377.195" y="263.987" width="4.19913" height="4.19913" fill="#FCFCFA"/>
            <rect x="381.395" y="263.987" width="4.19913" height="4.19913" fill="#396544"/>
            <rect x="385.592" y="263.987" width="4.19913" height="4.19913" fill="#2F5435"/>
            <rect x="389.793" y="263.987" width="4.19913" height="4.19913" fill="#DFDCE3"/>
            <rect x="393.99" y="263.987" width="4.19913" height="4.19913" fill="#35553D"/>
            <rect x="398.191" y="263.987" width="4.19913" height="4.19913" fill="white"/>
            <rect x="402.389" y="263.987" width="4.19913" height="4.19913" fill="white"/>
            <rect x="406.588" y="263.987" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="263.987" width="4.19913" height="4.19913" fill="#F4F4F4"/>
            <rect x="414.986" y="263.987" width="4.19913" height="4.19913" fill="#2D4434"/>
            <rect x="419.188" y="263.987" width="4.19913" height="4.19913" fill="#224E2B"/>
            <rect x="423.385" y="263.987" width="4.19913" height="4.19913" fill="#37573F"/>
            <rect x="427.586" y="263.987" width="4.19913" height="4.19913" fill="#22502C"/>
            <rect x="431.783" y="263.987" width="4.19913" height="4.19913" fill="#2D4F36"/>
            <rect x="435.982" y="263.987" width="4.19913" height="4.19913" fill="white"/>
            <rect x="440.182" y="263.987" width="4.19913" height="4.19913" fill="#FCFFFF"/>
            <rect x="372.996" y="268.187" width="4.19913" height="4.19913" fill="#F8F8F8"/>
            <rect x="377.195" y="268.187" width="4.19913" height="4.19913" fill="#3B6847"/>
            <rect x="381.395" y="268.187" width="4.19913" height="4.19913" fill="#33603F"/>
            <rect x="385.592" y="268.187" width="4.19913" height="4.19913" fill="#547F2D"/>
            <rect x="389.793" y="268.187" width="4.19913" height="4.19913" fill="#446C2D"/>
            <rect x="393.99" y="268.187" width="4.19913" height="4.19913" fill="#295834"/>
            <rect x="398.191" y="268.187" width="4.19913" height="4.19913" fill="#356243"/>
            <rect x="402.389" y="268.187" width="4.19913" height="4.19913" fill="#FEFCFD"/>
            <rect x="406.588" y="268.187" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="268.187" width="4.19913" height="4.19913" fill="#314333"/>
            <rect x="414.986" y="268.187" width="4.19913" height="4.19913" fill="#1C4928"/>
            <rect x="419.188" y="268.187" width="4.19913" height="4.19913" fill="#24502D"/>
            <rect x="423.385" y="268.187" width="4.19913" height="4.19913" fill="#245132"/>
            <rect x="427.586" y="268.187" width="4.19913" height="4.19913" fill="#23552F"/>
            <rect x="431.783" y="268.187" width="4.19913" height="4.19913" fill="#28512F"/>
            <rect x="435.982" y="268.187" width="4.19913" height="4.19913" fill="#FBFFFF"/>
            <rect x="440.182" y="268.187" width="4.19913" height="4.19913" fill="#274430"/>
            <rect x="372.996" y="272.385" width="4.19913" height="4.19913" fill="#63903F"/>
            <rect x="377.195" y="272.385" width="4.19913" height="4.19913" fill="#5E8937"/>
            <rect x="381.395" y="272.385" width="4.19913" height="4.19913" fill="#5F8D35"/>
            <rect x="385.592" y="272.385" width="4.19913" height="4.19913" fill="#587F2E"/>
            <rect x="389.793" y="272.385" width="4.19913" height="4.19913" fill="#47711F"/>
            <rect x="393.99" y="272.385" width="4.19913" height="4.19913" fill="#4E7C33"/>
            <rect x="398.191" y="272.385" width="4.19913" height="4.19913" fill="#537F42"/>
            <rect x="402.389" y="272.385" width="4.19913" height="4.19913" fill="#558637"/>
            <rect x="406.588" y="272.385" width="4.19913" height="4.19913" fill="#275332"/>
            <rect x="410.787" y="272.385" width="4.19913" height="4.19913" fill="#255233"/>
            <rect x="414.986" y="272.385" width="4.19913" height="4.19913" fill="#25512D"/>
            <rect x="419.188" y="272.385" width="4.19913" height="4.19913" fill="#537F2A"/>
            <rect x="423.385" y="272.385" width="4.19913" height="4.19913" fill="#2B5724"/>
            <rect x="427.586" y="272.385" width="4.19913" height="4.19913" fill="#527F22"/>
            <rect x="431.783" y="272.385" width="4.19913" height="4.19913" fill="#53793C"/>
            <rect x="435.982" y="272.385" width="4.19913" height="4.19913" fill="#49771F"/>
            <rect x="440.182" y="272.385" width="4.19913" height="4.19913" fill="#4A7627"/>
            <rect x="364.598" y="276.584" width="4.19913" height="4.19913" fill="#F2FBFF"/>
            <rect x="368.797" y="276.584" width="4.19913" height="4.19913" fill="#C2C6C5"/>
            <rect x="372.996" y="276.584" width="4.19913" height="4.19913" fill="#668051"/>
            <rect x="377.195" y="276.584" width="4.19913" height="4.19913" fill="#F9FDFC"/>
            <rect x="381.395" y="276.584" width="4.19913" height="4.19913" fill="#638046"/>
            <rect x="385.592" y="276.584" width="4.19913" height="4.19913" fill="#597F32"/>
            <rect x="389.793" y="276.584" width="4.19913" height="4.19913" fill="#497128"/>
            <rect x="393.99" y="276.584" width="4.19913" height="4.19913" fill="#588238"/>
            <rect x="398.191" y="276.584" width="4.19913" height="4.19913" fill="#5D8839"/>
            <rect x="402.389" y="276.584" width="4.19913" height="4.19913" fill="#5A8239"/>
            <rect x="406.588" y="276.584" width="4.19913" height="4.19913" fill="#537F34"/>
            <rect x="410.787" y="276.584" width="4.19913" height="4.19913" fill="#5D8336"/>
            <rect x="414.986" y="276.584" width="4.19913" height="4.19913" fill="#4F782C"/>
            <rect x="419.188" y="276.584" width="4.19913" height="4.19913" fill="#547F30"/>
            <rect x="423.385" y="276.584" width="4.19913" height="4.19913" fill="#587E31"/>
            <rect x="427.586" y="276.584" width="4.19913" height="4.19913" fill="#527C32"/>
            <rect x="431.783" y="276.584" width="4.19913" height="4.19913" fill="#F9FFF8"/>
            <rect x="435.982" y="276.584" width="4.19913" height="4.19913" fill="#F9FFFB"/>
            <rect x="440.182" y="276.584" width="4.19913" height="4.19913" fill="#517629"/>
            <rect x="444.381" y="276.584" width="4.19913" height="4.19913" fill="#537E36"/>
            <rect x="360.398" y="280.783" width="4.19913" height="4.19913" fill="#F4FEFF"/>
            <rect x="364.598" y="280.783" width="4.19913" height="4.19913" fill="#FEFAFB"/>
            <rect x="368.797" y="280.783" width="4.19913" height="4.19913" fill="#C3C3C3"/>
            <rect x="372.996" y="280.783" width="4.19913" height="4.19913" fill="#F8F8F8"/>
            <rect x="377.195" y="280.783" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="381.395" y="280.783" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="385.592" y="280.783" width="4.19913" height="4.19913" fill="#5E7B3B"/>
            <rect x="389.793" y="280.783" width="4.19913" height="4.19913" fill="#4F7623"/>
            <rect x="393.99" y="280.783" width="4.19913" height="4.19913" fill="#598635"/>
            <rect x="398.191" y="280.783" width="4.19913" height="4.19913" fill="#F1FFE4"/>
            <rect x="402.389" y="280.783" width="4.19913" height="4.19913" fill="#F8FEFA"/>
            <rect x="406.588" y="280.783" width="4.19913" height="4.19913" fill="#F7FFE7"/>
            <rect x="410.787" y="280.783" width="4.19913" height="4.19913" fill="#F4F4F4"/>
            <rect x="414.986" y="280.783" width="4.19913" height="4.19913" fill="#4E712F"/>
            <rect x="419.188" y="280.783" width="4.19913" height="4.19913" fill="#57812D"/>
            <rect x="423.385" y="280.783" width="4.19913" height="4.19913" fill="#56822D"/>
            <rect x="427.586" y="280.783" width="4.19913" height="4.19913" fill="#548130"/>
            <rect x="431.783" y="280.783" width="4.19913" height="4.19913" fill="#F8FEF0"/>
            <rect x="435.982" y="280.783" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="440.182" y="280.783" width="4.19913" height="4.19913" fill="#FCFFF3"/>
            <rect x="444.381" y="280.783" width="4.19913" height="4.19913" fill="#F7FFEA"/>
            <rect x="448.58" y="280.783" width="4.19913" height="4.19913" fill="#FFFFFD"/>
            <rect x="360.398" y="284.982" width="4.19913" height="4.19913" fill="#F3FDFF"/>
            <rect x="364.598" y="284.982" width="4.19913" height="4.19913" fill="#FBFBFB"/>
            <rect x="368.797" y="284.982" width="4.19913" height="4.19913" fill="#C2C2C2"/>
            <rect x="372.996" y="284.982" width="4.19913" height="4.19913" fill="#F7F7F9"/>
            <rect x="377.195" y="284.982" width="4.19913" height="4.19913" fill="#3D5A44"/>
            <rect x="381.395" y="284.982" width="4.19913" height="4.19913" fill="#FBFBFD"/>
            <rect x="385.592" y="284.982" width="4.19913" height="4.19913" fill="white"/>
            <rect x="389.793" y="284.982" width="4.19913" height="4.19913" fill="#DBE0D9"/>
            <rect x="393.99" y="284.982" width="4.19913" height="4.19913" fill="#FBFFFA"/>
            <rect x="398.191" y="284.982" width="4.19913" height="4.19913" fill="#FEFCFD"/>
            <rect x="402.389" y="284.982" width="4.19913" height="4.19913" fill="#FDFDFB"/>
            <rect x="406.588" y="284.982" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="284.982" width="4.19913" height="4.19913" fill="#F2F2F2"/>
            <rect x="414.986" y="284.982" width="4.19913" height="4.19913" fill="#FFFDFE"/>
            <rect x="419.188" y="284.982" width="4.19913" height="4.19913" fill="#507236"/>
            <rect x="423.385" y="284.982" width="4.19913" height="4.19913" fill="#FEFFFD"/>
            <rect x="427.586" y="284.982" width="4.19913" height="4.19913" fill="#547832"/>
            <rect x="431.783" y="284.982" width="4.19913" height="4.19913" fill="white"/>
            <rect x="435.982" y="284.982" width="4.19913" height="4.19913" fill="#FFFEFF"/>
            <rect x="440.182" y="284.982" width="4.19913" height="4.19913" fill="#FEFFFF"/>
            <rect x="444.381" y="284.982" width="4.19913" height="4.19913" fill="white"/>
            <rect x="448.58" y="284.982" width="4.19913" height="4.19913" fill="#FEFFFF"/>
            <rect x="452.779" y="284.982" width="4.19913" height="4.19913" fill="#26583D"/>
            <rect x="364.598" y="289.182" width="4.19913" height="4.19913" fill="#315E47"/>
            <rect x="368.797" y="289.182" width="4.19913" height="4.19913" fill="#C5C0C4"/>
            <rect x="372.996" y="289.182" width="4.19913" height="4.19913" fill="#3E724C"/>
            <rect x="377.195" y="289.182" width="4.19913" height="4.19913" fill="#416A48"/>
            <rect x="381.395" y="289.182" width="4.19913" height="4.19913" fill="#386544"/>
            <rect x="385.592" y="289.182" width="4.19913" height="4.19913" fill="#F9FFFA"/>
            <rect x="389.793" y="289.182" width="4.19913" height="4.19913" fill="#203A2D"/>
            <rect x="393.99" y="289.182" width="4.19913" height="4.19913" fill="#F8FFFA"/>
            <rect x="398.191" y="289.182" width="4.19913" height="4.19913" fill="white"/>
            <rect x="402.389" y="289.182" width="4.19913" height="4.19913" fill="white"/>
            <rect x="406.588" y="289.182" width="4.19913" height="4.19913" fill="white"/>
            <rect x="410.787" y="289.182" width="4.19913" height="4.19913" fill="#264A2E"/>
            <rect x="414.986" y="289.182" width="4.19913" height="4.19913" fill="#FEFEFE"/>
            <rect x="419.188" y="289.182" width="4.19913" height="4.19913" fill="#2C4734"/>
            <rect x="423.385" y="289.182" width="4.19913" height="4.19913" fill="#FFFDFD"/>
            <rect x="427.586" y="289.182" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="431.783" y="289.182" width="4.19913" height="4.19913" fill="#FCFCFC"/>
            <rect x="435.982" y="289.182" width="4.19913" height="4.19913" fill="#274B31"/>
            <rect x="440.182" y="289.182" width="4.19913" height="4.19913" fill="#224B2D"/>
            <rect x="444.381" y="289.182" width="4.19913" height="4.19913" fill="white"/>
            <rect x="448.58" y="289.182" width="4.19913" height="4.19913" fill="#26522F"/>
            <rect x="452.779" y="289.182" width="4.19913" height="4.19913" fill="#2C5537"/>
            <rect x="360.398" y="293.381" width="4.19913" height="4.19913" fill="#44664D"/>
            <rect x="364.598" y="293.381" width="4.19913" height="4.19913" fill="#35633F"/>
            <rect x="368.797" y="293.381" width="4.19913" height="4.19913" fill="#3B601B"/>
            <rect x="372.996" y="293.381" width="4.19913" height="4.19913" fill="#3D6C48"/>
            <rect x="377.195" y="293.381" width="4.19913" height="4.19913" fill="#618F51"/>
            <rect x="381.395" y="293.381" width="4.19913" height="4.19913" fill="#33613D"/>
            <rect x="385.592" y="293.381" width="4.19913" height="4.19913" fill="#548146"/>
            <rect x="389.793" y="293.381" width="4.19913" height="4.19913" fill="#244C27"/>
            <rect x="393.99" y="293.381" width="4.19913" height="4.19913" fill="#30573A"/>
            <rect x="398.191" y="293.381" width="4.19913" height="4.19913" fill="#F1FFF7"/>
            <rect x="402.389" y="293.381" width="4.19913" height="4.19913" fill="#FDFFFC"/>
            <rect x="406.588" y="293.381" width="4.19913" height="4.19913" fill="#275531"/>
            <rect x="410.787" y="293.381" width="4.19913" height="4.19913" fill="#265430"/>
            <rect x="414.986" y="293.381" width="4.19913" height="4.19913" fill="#4C7730"/>
            <rect x="419.188" y="293.381" width="4.19913" height="4.19913" fill="#22512D"/>
            <rect x="423.385" y="293.381" width="4.19913" height="4.19913" fill="#265531"/>
            <rect x="427.586" y="293.381" width="4.19913" height="4.19913" fill="#FDFDFD"/>
            <rect x="431.783" y="293.381" width="4.19913" height="4.19913" fill="#3C553F"/>
            <rect x="435.982" y="293.381" width="4.19913" height="4.19913" fill="#194B28"/>
            <rect x="440.182" y="293.381" width="4.19913" height="4.19913" fill="#1D4926"/>
            <rect x="444.381" y="293.381" width="4.19913" height="4.19913" fill="#1F4E2A"/>
            <rect x="448.58" y="293.381" width="4.19913" height="4.19913" fill="#21502E"/>
            <rect x="452.779" y="293.381" width="4.19913" height="4.19913" fill="#578233"/>
            <rect x="356.199" y="297.58" width="4.19913" height="4.19913" fill="#FCFCFA"/>
            <rect x="360.398" y="297.58" width="4.19913" height="4.19913" fill="#FDFFFC"/>
            <rect x="364.598" y="297.58" width="4.19913" height="4.19913" fill="#63883B"/>
            <rect x="368.797" y="297.58" width="4.19913" height="4.19913" fill="#3C611B"/>
            <rect x="372.996" y="297.58" width="4.19913" height="4.19913" fill="#658E40"/>
            <rect x="377.195" y="297.58" width="4.19913" height="4.19913" fill="#68904A"/>
            <rect x="381.395" y="297.58" width="4.19913" height="4.19913" fill="#5C8134"/>
            <rect x="385.592" y="297.58" width="4.19913" height="4.19913" fill="#5C8134"/>
            <rect x="389.793" y="297.58" width="4.19913" height="4.19913" fill="#517130"/>
            <rect x="393.99" y="297.58" width="4.19913" height="4.19913" fill="#3C6336"/>
            <rect x="398.191" y="297.58" width="4.19913" height="4.19913" fill="#3A6345"/>
            <rect x="402.389" y="297.58" width="4.19913" height="4.19913" fill="#2F5E34"/>
            <rect x="406.588" y="297.58" width="4.19913" height="4.19913" fill="#335B40"/>
            <rect x="410.787" y="297.58" width="4.19913" height="4.19913" fill="#587A2D"/>
            <rect x="414.986" y="297.58" width="4.19913" height="4.19913" fill="#587B39"/>
            <rect x="419.188" y="297.58" width="4.19913" height="4.19913" fill="#557E30"/>
            <rect x="423.385" y="297.58" width="4.19913" height="4.19913" fill="#335A2B"/>
            <rect x="427.586" y="297.58" width="4.19913" height="4.19913" fill="#5A7D3B"/>
            <rect x="431.783" y="297.58" width="4.19913" height="4.19913" fill="#2F582C"/>
            <rect x="435.982" y="297.58" width="4.19913" height="4.19913" fill="#254F29"/>
            <rect x="440.182" y="297.58" width="4.19913" height="4.19913" fill="#527B2D"/>
            <rect x="444.381" y="297.58" width="4.19913" height="4.19913" fill="#537C2E"/>
            <rect x="448.58" y="297.58" width="4.19913" height="4.19913" fill="#FAFFF9"/>
            <rect x="452.779" y="297.58" width="4.19913" height="4.19913" fill="#60813A"/>
            <rect x="388.029" y="274.381" width="6.61088" height="6.61088" transform="rotate(-180 388.029 274.381)" fill="#C50306"/>
            <rect x="417.117" y="252.564" width="6.61088" height="6.61088" transform="rotate(-180 417.117 252.564)" fill="#C50306"/>
            <rect x="407.861" y="226.783" width="6.61088" height="6.61088" transform="rotate(-180 407.861 226.783)" fill="#C50306"/>
            <rect x="441.248" y="294.544" width="6.61088" height="6.61088" transform="rotate(-180 441.248 294.544)" fill="#C50306"/>
            <rect x="493.175" y="111.825" width="20.3" height="1.45" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="494.737" y="111.463" width="17.1769" height="0.3625" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="494.737" y="113.275" width="17.1769" height="0.3625" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="496.298" y="111.1" width="14.0539" height="0.3625" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="496.298" y="113.638" width="14.0539" height="0.3625" fill="#2B4447" fill-opacity="0.1"/>
            <rect x="495.55" y="92.4199" width="2.87573" height="20.1301" fill="#7F4D2A"/>
            <rect x="498.426" y="92.4199" width="3.11538" height="20.1301" fill="#7F4D2A"/>
            <rect x="501.541" y="92.4199" width="3.11538" height="20.1301" fill="#7F4D2A"/>
            <rect x="504.657" y="92.4199" width="3.11538" height="20.1301" fill="#79421B"/>
            <rect x="507.771" y="92.4199" width="2.87573" height="20.1301" fill="#743E1C"/>
            <rect x="501.576" y="-2" width="3.04437" height="3.04437" fill="#F9F9F9"/>
            <rect x="498.532" y="1.04443" width="3.04437" height="3.04437" fill="#F4FDFF"/>
            <rect x="501.576" y="1.04443" width="3.04437" height="3.04437" fill="#F9F9F9"/>
            <rect x="504.621" y="1.04443" width="3.04437" height="3.04437" fill="#EBEFF0"/>
            <rect x="498.532" y="4.08887" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="501.576" y="4.08887" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="4.08887" width="3.04437" height="3.04437" fill="#EFEFEF"/>
            <rect x="507.665" y="4.08887" width="3.04437" height="3.04437" fill="#335C4A"/>
            <rect x="495.489" y="7.1333" width="3.04437" height="3.04437" fill="#EEEFE7"/>
            <rect x="498.532" y="7.1333" width="3.04437" height="3.04437" fill="#F1F1F1"/>
            <rect x="501.576" y="7.1333" width="3.04437" height="3.04437" fill="#EFEFEF"/>
            <rect x="504.621" y="7.1333" width="3.04437" height="3.04437" fill="#ECECEC"/>
            <rect x="507.665" y="7.1333" width="3.04437" height="3.04437" fill="#EEF8F0"/>
            <rect x="492.443" y="10.177" width="3.04437" height="3.04437" fill="#F7FFFF"/>
            <rect x="495.489" y="10.177" width="3.04437" height="3.04437" fill="#FDFFFC"/>
            <rect x="498.532" y="10.177" width="3.04437" height="3.04437" fill="#F9FFF6"/>
            <rect x="501.576" y="10.177" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="10.177" width="3.04437" height="3.04437" fill="#F2F2F2"/>
            <rect x="507.665" y="10.177" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="510.711" y="10.177" width="3.04437" height="3.04437" fill="#FCFFFF"/>
            <rect x="492.443" y="13.2214" width="3.04437" height="3.04437" fill="#3F6568"/>
            <rect x="495.489" y="13.2214" width="3.04437" height="3.04437" fill="#436E50"/>
            <rect x="498.532" y="13.2214" width="3.04437" height="3.04437" fill="#3F714E"/>
            <rect x="501.576" y="13.2214" width="3.04437" height="3.04437" fill="#EDFAF3"/>
            <rect x="504.621" y="13.2214" width="3.04437" height="3.04437" fill="#F1F1F1"/>
            <rect x="507.665" y="13.2214" width="3.04437" height="3.04437" fill="#F3FAF2"/>
            <rect x="510.711" y="13.2214" width="3.04437" height="3.04437" fill="#FCFCFC"/>
            <rect x="489.4" y="16.2659" width="3.04437" height="3.04437" fill="#34554E"/>
            <rect x="492.443" y="16.2659" width="3.04437" height="3.04437" fill="#366342"/>
            <rect x="495.489" y="16.2659" width="3.04437" height="3.04437" fill="#45734F"/>
            <rect x="498.532" y="16.2659" width="3.04437" height="3.04437" fill="#43714D"/>
            <rect x="501.576" y="16.2659" width="3.04437" height="3.04437" fill="#396743"/>
            <rect x="504.621" y="16.2659" width="3.04437" height="3.04437" fill="#F1F6F0"/>
            <rect x="507.665" y="16.2659" width="3.04437" height="3.04437" fill="#365840"/>
            <rect x="510.711" y="16.2659" width="3.04437" height="3.04437" fill="#396645"/>
            <rect x="486.354" y="19.3103" width="3.04437" height="3.04437" fill="#F2FFFF"/>
            <rect x="492.443" y="19.3103" width="3.04437" height="3.04437" fill="#5F893F"/>
            <rect x="495.489" y="19.3103" width="3.04437" height="3.04437" fill="#5A8A36"/>
            <rect x="498.532" y="19.3103" width="3.04437" height="3.04437" fill="#5B8B37"/>
            <rect x="501.576" y="19.3103" width="3.04437" height="3.04437" fill="#325F3E"/>
            <rect x="504.621" y="19.3103" width="3.04437" height="3.04437" fill="#335B40"/>
            <rect x="507.665" y="19.3103" width="3.04437" height="3.04437" fill="#547F38"/>
            <rect x="510.711" y="19.3103" width="3.04437" height="3.04437" fill="#5A8334"/>
            <rect x="513.754" y="19.3103" width="3.04437" height="3.04437" fill="#588242"/>
            <rect x="483.311" y="22.3555" width="3.04437" height="3.04437" fill="#EFFCFF"/>
            <rect x="486.354" y="22.3555" width="3.04437" height="3.04437" fill="#FBFBFB"/>
            <rect x="489.4" y="22.3555" width="3.04437" height="3.04437" fill="#DBDBDB"/>
            <rect x="492.443" y="22.3555" width="3.04437" height="3.04437" fill="#F8FFEA"/>
            <rect x="495.489" y="22.3555" width="3.04437" height="3.04437" fill="#638F36"/>
            <rect x="498.532" y="22.3555" width="3.04437" height="3.04437" fill="#5D833A"/>
            <rect x="501.576" y="22.3555" width="3.04437" height="3.04437" fill="#5A8631"/>
            <rect x="504.621" y="22.3555" width="3.04437" height="3.04437" fill="#5C822B"/>
            <rect x="507.665" y="22.3555" width="3.04437" height="3.04437" fill="#577E2B"/>
            <rect x="510.711" y="22.3555" width="3.04437" height="3.04437" fill="#5E8630"/>
            <rect x="513.754" y="22.3555" width="3.04437" height="3.04437" fill="#FAFFF9"/>
            <rect x="516.8" y="22.3555" width="3.04437" height="3.04437" fill="#F7FEFF"/>
            <rect x="483.311" y="25.3999" width="3.04437" height="3.04437" fill="#FDFEF9"/>
            <rect x="486.354" y="25.3999" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="489.4" y="25.3999" width="3.04437" height="3.04437" fill="#E0E0E0"/>
            <rect x="492.443" y="25.3999" width="3.04437" height="3.04437" fill="white"/>
            <rect x="495.489" y="25.3999" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="498.532" y="25.3999" width="3.04437" height="3.04437" fill="#FEFFF9"/>
            <rect x="501.576" y="25.3999" width="3.04437" height="3.04437" fill="#54783B"/>
            <rect x="504.621" y="25.3999" width="3.04437" height="3.04437" fill="#517827"/>
            <rect x="507.665" y="25.3999" width="3.04437" height="3.04437" fill="#4D7828"/>
            <rect x="510.711" y="25.3999" width="3.04437" height="3.04437" fill="#4F7A28"/>
            <rect x="513.754" y="25.3999" width="3.04437" height="3.04437" fill="#FFFDFF"/>
            <rect x="516.8" y="25.3999" width="3.04437" height="3.04437" fill="#FCFDFF"/>
            <rect x="519.843" y="25.3999" width="3.04437" height="3.04437" fill="#F8FCFD"/>
            <rect x="483.311" y="28.4436" width="3.04437" height="3.04437" fill="#355C57"/>
            <rect x="486.354" y="28.4436" width="3.04437" height="3.04437" fill="#315A3C"/>
            <rect x="489.4" y="28.4436" width="3.04437" height="3.04437" fill="#24482E"/>
            <rect x="492.443" y="28.4436" width="3.04437" height="3.04437" fill="#F1F8F1"/>
            <rect x="495.489" y="28.4436" width="3.04437" height="3.04437" fill="white"/>
            <rect x="498.532" y="28.4436" width="3.04437" height="3.04437" fill="white"/>
            <rect x="501.576" y="28.4436" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="28.4436" width="3.04437" height="3.04437" fill="#EDEFE4"/>
            <rect x="507.665" y="28.4436" width="3.04437" height="3.04437" fill="white"/>
            <rect x="510.711" y="28.4436" width="3.04437" height="3.04437" fill="#FCFFFF"/>
            <rect x="513.754" y="28.4436" width="3.04437" height="3.04437" fill="#FEFFFF"/>
            <rect x="516.8" y="28.4436" width="3.04437" height="3.04437" fill="#375241"/>
            <rect x="519.843" y="28.4436" width="3.04437" height="3.04437" fill="#FCFFFF"/>
            <rect x="483.311" y="31.488" width="3.04437" height="3.04437" fill="#366342"/>
            <rect x="486.354" y="31.488" width="3.04437" height="3.04437" fill="#315F3B"/>
            <rect x="489.4" y="31.488" width="3.04437" height="3.04437" fill="#1C4A26"/>
            <rect x="492.443" y="31.488" width="3.04437" height="3.04437" fill="#345B3E"/>
            <rect x="495.489" y="31.488" width="3.04437" height="3.04437" fill="#E9FEF5"/>
            <rect x="498.532" y="31.488" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="501.576" y="31.488" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="31.488" width="3.04437" height="3.04437" fill="#F3F3F3"/>
            <rect x="507.665" y="31.488" width="3.04437" height="3.04437" fill="#334C39"/>
            <rect x="510.711" y="31.488" width="3.04437" height="3.04437" fill="#295733"/>
            <rect x="513.754" y="31.488" width="3.04437" height="3.04437" fill="#315139"/>
            <rect x="516.8" y="31.488" width="3.04437" height="3.04437" fill="#295834"/>
            <rect x="519.843" y="31.488" width="3.04437" height="3.04437" fill="#36523B"/>
            <rect x="522.887" y="31.488" width="3.04437" height="3.04437" fill="#21502E"/>
            <rect x="480.267" y="34.5325" width="3.04437" height="3.04437" fill="#67933C"/>
            <rect x="483.311" y="34.5325" width="3.04437" height="3.04437" fill="#F2FFEC"/>
            <rect x="486.354" y="34.5325" width="3.04437" height="3.04437" fill="#588439"/>
            <rect x="489.4" y="34.5325" width="3.04437" height="3.04437" fill="#497128"/>
            <rect x="492.443" y="34.5325" width="3.04437" height="3.04437" fill="#2B5D3A"/>
            <rect x="495.489" y="34.5325" width="3.04437" height="3.04437" fill="#356042"/>
            <rect x="498.532" y="34.5325" width="3.04437" height="3.04437" fill="#336240"/>
            <rect x="501.576" y="34.5325" width="3.04437" height="3.04437" fill="#2C5B37"/>
            <rect x="504.621" y="34.5325" width="3.04437" height="3.04437" fill="#264C37"/>
            <rect x="507.665" y="34.5325" width="3.04437" height="3.04437" fill="#235031"/>
            <rect x="510.711" y="34.5325" width="3.04437" height="3.04437" fill="#52813D"/>
            <rect x="513.754" y="34.5325" width="3.04437" height="3.04437" fill="#588230"/>
            <rect x="516.8" y="34.5325" width="3.04437" height="3.04437" fill="#528028"/>
            <rect x="519.843" y="34.5325" width="3.04437" height="3.04437" fill="#558231"/>
            <rect x="522.887" y="34.5325" width="3.04437" height="3.04437" fill="#4C7C16"/>
            <rect x="477.222" y="37.5769" width="3.04437" height="3.04437" fill="#FBFBFB"/>
            <rect x="480.267" y="37.5769" width="3.04437" height="3.04437" fill="#65853C"/>
            <rect x="483.311" y="37.5769" width="3.04437" height="3.04437" fill="#F0F7F0"/>
            <rect x="486.354" y="37.5769" width="3.04437" height="3.04437" fill="#FCFFF3"/>
            <rect x="489.4" y="37.5769" width="3.04437" height="3.04437" fill="#496E20"/>
            <rect x="492.443" y="37.5769" width="3.04437" height="3.04437" fill="#588230"/>
            <rect x="495.489" y="37.5769" width="3.04437" height="3.04437" fill="#568132"/>
            <rect x="498.532" y="37.5769" width="3.04437" height="3.04437" fill="#5C813B"/>
            <rect x="501.576" y="37.5769" width="3.04437" height="3.04437" fill="#547B3A"/>
            <rect x="504.621" y="37.5769" width="3.04437" height="3.04437" fill="#517626"/>
            <rect x="507.665" y="37.5769" width="3.04437" height="3.04437" fill="#527C34"/>
            <rect x="510.711" y="37.5769" width="3.04437" height="3.04437" fill="#577C2E"/>
            <rect x="513.754" y="37.5769" width="3.04437" height="3.04437" fill="#547A2D"/>
            <rect x="516.8" y="37.5769" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="519.843" y="37.5769" width="3.04437" height="3.04437" fill="#618346"/>
            <rect x="522.887" y="37.5769" width="3.04437" height="3.04437" fill="#4D7627"/>
            <rect x="477.222" y="40.6213" width="3.04437" height="3.04437" fill="#F6FFFF"/>
            <rect x="480.267" y="40.6213" width="3.04437" height="3.04437" fill="#FAFAFA"/>
            <rect x="483.311" y="40.6213" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="486.354" y="40.6213" width="3.04437" height="3.04437" fill="white"/>
            <rect x="489.4" y="40.6213" width="3.04437" height="3.04437" fill="#E0E0E0"/>
            <rect x="492.443" y="40.6213" width="3.04437" height="3.04437" fill="#F8F5EC"/>
            <rect x="495.489" y="40.6213" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="498.532" y="40.6213" width="3.04437" height="3.04437" fill="#FEFFFB"/>
            <rect x="501.576" y="40.6213" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="40.6213" width="3.04437" height="3.04437" fill="#EDF2EC"/>
            <rect x="507.665" y="40.6213" width="3.04437" height="3.04437" fill="#FDFDFB"/>
            <rect x="510.711" y="40.6213" width="3.04437" height="3.04437" fill="#F9FFFF"/>
            <rect x="513.754" y="40.6213" width="3.04437" height="3.04437" fill="#FFFFFB"/>
            <rect x="516.8" y="40.6213" width="3.04437" height="3.04437" fill="#FCFCFC"/>
            <rect x="519.843" y="40.6213" width="3.04437" height="3.04437" fill="#FCFCFC"/>
            <rect x="522.887" y="40.6213" width="3.04437" height="3.04437" fill="#F8FFF0"/>
            <rect x="477.222" y="43.6658" width="3.04437" height="3.04437" fill="#FAFAFA"/>
            <rect x="480.267" y="43.6658" width="3.04437" height="3.04437" fill="#FCFCFA"/>
            <rect x="483.311" y="43.6658" width="3.04437" height="3.04437" fill="#396544"/>
            <rect x="486.354" y="43.6658" width="3.04437" height="3.04437" fill="#2F5435"/>
            <rect x="489.4" y="43.6658" width="3.04437" height="3.04437" fill="#DFDCE3"/>
            <rect x="492.443" y="43.6658" width="3.04437" height="3.04437" fill="#35553D"/>
            <rect x="495.489" y="43.6658" width="3.04437" height="3.04437" fill="white"/>
            <rect x="498.532" y="43.6658" width="3.04437" height="3.04437" fill="white"/>
            <rect x="501.576" y="43.6658" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="43.6658" width="3.04437" height="3.04437" fill="#F4F4F4"/>
            <rect x="507.665" y="43.6658" width="3.04437" height="3.04437" fill="#2D4434"/>
            <rect x="510.711" y="43.6658" width="3.04437" height="3.04437" fill="#224E2B"/>
            <rect x="513.754" y="43.6658" width="3.04437" height="3.04437" fill="#37573F"/>
            <rect x="516.8" y="43.6658" width="3.04437" height="3.04437" fill="#22502C"/>
            <rect x="519.843" y="43.6658" width="3.04437" height="3.04437" fill="#2D4F36"/>
            <rect x="522.887" y="43.6658" width="3.04437" height="3.04437" fill="white"/>
            <rect x="525.932" y="43.6658" width="3.04437" height="3.04437" fill="#FCFFFF"/>
            <rect x="477.222" y="46.7102" width="3.04437" height="3.04437" fill="#F8F8F8"/>
            <rect x="480.267" y="46.7102" width="3.04437" height="3.04437" fill="#3B6847"/>
            <rect x="483.311" y="46.7102" width="3.04437" height="3.04437" fill="#33603F"/>
            <rect x="486.354" y="46.7102" width="3.04437" height="3.04437" fill="#547F2D"/>
            <rect x="489.4" y="46.7102" width="3.04437" height="3.04437" fill="#446C2D"/>
            <rect x="492.443" y="46.7102" width="3.04437" height="3.04437" fill="#295834"/>
            <rect x="495.489" y="46.7102" width="3.04437" height="3.04437" fill="#356243"/>
            <rect x="498.532" y="46.7102" width="3.04437" height="3.04437" fill="#FEFCFD"/>
            <rect x="501.576" y="46.7102" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="46.7102" width="3.04437" height="3.04437" fill="#314333"/>
            <rect x="507.665" y="46.7102" width="3.04437" height="3.04437" fill="#1C4928"/>
            <rect x="510.711" y="46.7102" width="3.04437" height="3.04437" fill="#24502D"/>
            <rect x="513.754" y="46.7102" width="3.04437" height="3.04437" fill="#245132"/>
            <rect x="516.8" y="46.7102" width="3.04437" height="3.04437" fill="#23552F"/>
            <rect x="519.843" y="46.7102" width="3.04437" height="3.04437" fill="#28512F"/>
            <rect x="522.887" y="46.7102" width="3.04437" height="3.04437" fill="#FBFFFF"/>
            <rect x="525.932" y="46.7102" width="3.04437" height="3.04437" fill="#274430"/>
            <rect x="477.222" y="49.7539" width="3.04437" height="3.04437" fill="#63903F"/>
            <rect x="480.267" y="49.7539" width="3.04437" height="3.04437" fill="#5E8937"/>
            <rect x="483.311" y="49.7539" width="3.04437" height="3.04437" fill="#5F8D35"/>
            <rect x="486.354" y="49.7539" width="3.04437" height="3.04437" fill="#587F2E"/>
            <rect x="489.4" y="49.7539" width="3.04437" height="3.04437" fill="#47711F"/>
            <rect x="492.443" y="49.7539" width="3.04437" height="3.04437" fill="#4E7C33"/>
            <rect x="495.489" y="49.7539" width="3.04437" height="3.04437" fill="#537F42"/>
            <rect x="498.532" y="49.7539" width="3.04437" height="3.04437" fill="#558637"/>
            <rect x="501.576" y="49.7539" width="3.04437" height="3.04437" fill="#275332"/>
            <rect x="504.621" y="49.7539" width="3.04437" height="3.04437" fill="#255233"/>
            <rect x="507.665" y="49.7539" width="3.04437" height="3.04437" fill="#25512D"/>
            <rect x="510.711" y="49.7539" width="3.04437" height="3.04437" fill="#537F2A"/>
            <rect x="513.754" y="49.7539" width="3.04437" height="3.04437" fill="#2B5724"/>
            <rect x="516.8" y="49.7539" width="3.04437" height="3.04437" fill="#527F22"/>
            <rect x="519.843" y="49.7539" width="3.04437" height="3.04437" fill="#53793C"/>
            <rect x="522.887" y="49.7539" width="3.04437" height="3.04437" fill="#49771F"/>
            <rect x="525.932" y="49.7539" width="3.04437" height="3.04437" fill="#4A7627"/>
            <rect x="471.133" y="52.7983" width="3.04437" height="3.04437" fill="#F2FBFF"/>
            <rect x="474.178" y="52.7983" width="3.04437" height="3.04437" fill="#C2C6C5"/>
            <rect x="477.222" y="52.7983" width="3.04437" height="3.04437" fill="#668051"/>
            <rect x="480.267" y="52.7983" width="3.04437" height="3.04437" fill="#F9FDFC"/>
            <rect x="483.311" y="52.7983" width="3.04437" height="3.04437" fill="#638046"/>
            <rect x="486.354" y="52.7983" width="3.04437" height="3.04437" fill="#597F32"/>
            <rect x="489.4" y="52.7983" width="3.04437" height="3.04437" fill="#497128"/>
            <rect x="492.443" y="52.7983" width="3.04437" height="3.04437" fill="#588238"/>
            <rect x="495.489" y="52.7983" width="3.04437" height="3.04437" fill="#5D8839"/>
            <rect x="498.532" y="52.7983" width="3.04437" height="3.04437" fill="#5A8239"/>
            <rect x="501.576" y="52.7983" width="3.04437" height="3.04437" fill="#537F34"/>
            <rect x="504.621" y="52.7983" width="3.04437" height="3.04437" fill="#5D8336"/>
            <rect x="507.665" y="52.7983" width="3.04437" height="3.04437" fill="#4F782C"/>
            <rect x="510.711" y="52.7983" width="3.04437" height="3.04437" fill="#547F30"/>
            <rect x="513.754" y="52.7983" width="3.04437" height="3.04437" fill="#587E31"/>
            <rect x="516.8" y="52.7983" width="3.04437" height="3.04437" fill="#527C32"/>
            <rect x="519.843" y="52.7983" width="3.04437" height="3.04437" fill="#F9FFF8"/>
            <rect x="522.887" y="52.7983" width="3.04437" height="3.04437" fill="#F9FFFB"/>
            <rect x="525.932" y="52.7983" width="3.04437" height="3.04437" fill="#517629"/>
            <rect x="528.976" y="52.7983" width="3.04437" height="3.04437" fill="#537E36"/>
            <rect x="468.089" y="55.8428" width="3.04437" height="3.04437" fill="#F4FEFF"/>
            <rect x="471.133" y="55.8428" width="3.04437" height="3.04437" fill="#FEFAFB"/>
            <rect x="474.178" y="55.8428" width="3.04437" height="3.04437" fill="#C3C3C3"/>
            <rect x="477.222" y="55.8428" width="3.04437" height="3.04437" fill="#F8F8F8"/>
            <rect x="480.267" y="55.8428" width="3.04437" height="3.04437" fill="#FBFBFB"/>
            <rect x="483.311" y="55.8428" width="3.04437" height="3.04437" fill="#FCFCFC"/>
            <rect x="486.354" y="55.8428" width="3.04437" height="3.04437" fill="#5E7B3B"/>
            <rect x="489.4" y="55.8428" width="3.04437" height="3.04437" fill="#4F7623"/>
            <rect x="492.443" y="55.8428" width="3.04437" height="3.04437" fill="#598635"/>
            <rect x="495.489" y="55.8428" width="3.04437" height="3.04437" fill="#F1FFE4"/>
            <rect x="498.532" y="55.8428" width="3.04437" height="3.04437" fill="#F8FEFA"/>
            <rect x="501.576" y="55.8428" width="3.04437" height="3.04437" fill="#F7FFE7"/>
            <rect x="504.621" y="55.8428" width="3.04437" height="3.04437" fill="#F4F4F4"/>
            <rect x="507.665" y="55.8428" width="3.04437" height="3.04437" fill="#4E712F"/>
            <rect x="510.711" y="55.8428" width="3.04437" height="3.04437" fill="#57812D"/>
            <rect x="513.754" y="55.8428" width="3.04437" height="3.04437" fill="#56822D"/>
            <rect x="516.8" y="55.8428" width="3.04437" height="3.04437" fill="#548130"/>
            <rect x="519.843" y="55.8428" width="3.04437" height="3.04437" fill="#F8FEF0"/>
            <rect x="522.887" y="55.8428" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="525.932" y="55.8428" width="3.04437" height="3.04437" fill="#FCFFF3"/>
            <rect x="528.976" y="55.8428" width="3.04437" height="3.04437" fill="#F7FFEA"/>
            <rect x="532.021" y="55.8428" width="3.04437" height="3.04437" fill="#FFFFFD"/>
            <rect x="468.089" y="58.8872" width="3.04437" height="3.04437" fill="#F3FDFF"/>
            <rect x="471.133" y="58.8872" width="3.04437" height="3.04437" fill="#FBFBFB"/>
            <rect x="474.178" y="58.8872" width="3.04437" height="3.04437" fill="#C2C2C2"/>
            <rect x="477.222" y="58.8872" width="3.04437" height="3.04437" fill="#F7F7F9"/>
            <rect x="480.267" y="58.8872" width="3.04437" height="3.04437" fill="#3D5A44"/>
            <rect x="483.311" y="58.8872" width="3.04437" height="3.04437" fill="#FBFBFD"/>
            <rect x="486.354" y="58.8872" width="3.04437" height="3.04437" fill="white"/>
            <rect x="489.4" y="58.8872" width="3.04437" height="3.04437" fill="#DBE0D9"/>
            <rect x="492.443" y="58.8872" width="3.04437" height="3.04437" fill="#FBFFFA"/>
            <rect x="495.489" y="58.8872" width="3.04437" height="3.04437" fill="#FEFCFD"/>
            <rect x="498.532" y="58.8872" width="3.04437" height="3.04437" fill="#FDFDFB"/>
            <rect x="501.576" y="58.8872" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="58.8872" width="3.04437" height="3.04437" fill="#F2F2F2"/>
            <rect x="507.665" y="58.8872" width="3.04437" height="3.04437" fill="#FFFDFE"/>
            <rect x="510.711" y="58.8872" width="3.04437" height="3.04437" fill="#507236"/>
            <rect x="513.754" y="58.8872" width="3.04437" height="3.04437" fill="#FEFFFD"/>
            <rect x="516.8" y="58.8872" width="3.04437" height="3.04437" fill="#547832"/>
            <rect x="519.843" y="58.8872" width="3.04437" height="3.04437" fill="white"/>
            <rect x="522.887" y="58.8872" width="3.04437" height="3.04437" fill="#FFFEFF"/>
            <rect x="525.932" y="58.8872" width="3.04437" height="3.04437" fill="#FEFFFF"/>
            <rect x="528.976" y="58.8872" width="3.04437" height="3.04437" fill="white"/>
            <rect x="532.021" y="58.8872" width="3.04437" height="3.04437" fill="#FEFFFF"/>
            <rect x="535.065" y="58.8872" width="3.04437" height="3.04437" fill="#26583D"/>
            <rect x="471.133" y="61.9316" width="3.04437" height="3.04437" fill="#315E47"/>
            <rect x="474.178" y="61.9316" width="3.04437" height="3.04437" fill="#C5C0C4"/>
            <rect x="477.222" y="61.9316" width="3.04437" height="3.04437" fill="#3E724C"/>
            <rect x="480.267" y="61.9316" width="3.04437" height="3.04437" fill="#416A48"/>
            <rect x="483.311" y="61.9316" width="3.04437" height="3.04437" fill="#386544"/>
            <rect x="486.354" y="61.9316" width="3.04437" height="3.04437" fill="#F9FFFA"/>
            <rect x="489.4" y="61.9316" width="3.04437" height="3.04437" fill="#203A2D"/>
            <rect x="492.443" y="61.9316" width="3.04437" height="3.04437" fill="#F8FFFA"/>
            <rect x="495.489" y="61.9316" width="3.04437" height="3.04437" fill="white"/>
            <rect x="498.532" y="61.9316" width="3.04437" height="3.04437" fill="white"/>
            <rect x="501.576" y="61.9316" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="61.9316" width="3.04437" height="3.04437" fill="#264A2E"/>
            <rect x="507.665" y="61.9316" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="510.711" y="61.9316" width="3.04437" height="3.04437" fill="#2C4734"/>
            <rect x="513.754" y="61.9316" width="3.04437" height="3.04437" fill="#FFFDFD"/>
            <rect x="516.8" y="61.9316" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="519.843" y="61.9316" width="3.04437" height="3.04437" fill="#FCFCFC"/>
            <rect x="522.887" y="61.9316" width="3.04437" height="3.04437" fill="#274B31"/>
            <rect x="525.932" y="61.9316" width="3.04437" height="3.04437" fill="#224B2D"/>
            <rect x="528.976" y="61.9316" width="3.04437" height="3.04437" fill="white"/>
            <rect x="532.021" y="61.9316" width="3.04437" height="3.04437" fill="#26522F"/>
            <rect x="535.065" y="61.9316" width="3.04437" height="3.04437" fill="#2C5537"/>
            <rect x="468.089" y="64.9761" width="3.04437" height="3.04437" fill="#44664D"/>
            <rect x="471.133" y="64.9761" width="3.04437" height="3.04437" fill="#35633F"/>
            <rect x="474.178" y="64.9761" width="3.04437" height="3.04437" fill="#3B601B"/>
            <rect x="477.222" y="64.9761" width="3.04437" height="3.04437" fill="#3D6C48"/>
            <rect x="480.267" y="64.9761" width="3.04437" height="3.04437" fill="#618F51"/>
            <rect x="483.311" y="64.9761" width="3.04437" height="3.04437" fill="#33613D"/>
            <rect x="486.354" y="64.9761" width="3.04437" height="3.04437" fill="#548146"/>
            <rect x="489.4" y="64.9761" width="3.04437" height="3.04437" fill="#244C27"/>
            <rect x="492.443" y="64.9761" width="3.04437" height="3.04437" fill="#30573A"/>
            <rect x="495.489" y="64.9761" width="3.04437" height="3.04437" fill="#F1FFF7"/>
            <rect x="498.532" y="64.9761" width="3.04437" height="3.04437" fill="#FDFFFC"/>
            <rect x="501.576" y="64.9761" width="3.04437" height="3.04437" fill="#275531"/>
            <rect x="504.621" y="64.9761" width="3.04437" height="3.04437" fill="#265430"/>
            <rect x="507.665" y="64.9761" width="3.04437" height="3.04437" fill="#4C7730"/>
            <rect x="510.711" y="64.9761" width="3.04437" height="3.04437" fill="#22512D"/>
            <rect x="513.754" y="64.9761" width="3.04437" height="3.04437" fill="#265531"/>
            <rect x="516.8" y="64.9761" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="519.843" y="64.9761" width="3.04437" height="3.04437" fill="#3C553F"/>
            <rect x="522.887" y="64.9761" width="3.04437" height="3.04437" fill="#194B28"/>
            <rect x="525.932" y="64.9761" width="3.04437" height="3.04437" fill="#1D4926"/>
            <rect x="528.976" y="64.9761" width="3.04437" height="3.04437" fill="#1F4E2A"/>
            <rect x="532.021" y="64.9761" width="3.04437" height="3.04437" fill="#21502E"/>
            <rect x="535.065" y="64.9761" width="3.04437" height="3.04437" fill="#578233"/>
            <rect x="465.044" y="68.0205" width="3.04437" height="3.04437" fill="#FCFCFA"/>
            <rect x="468.089" y="68.0205" width="3.04437" height="3.04437" fill="#FDFFFC"/>
            <rect x="471.133" y="68.0205" width="3.04437" height="3.04437" fill="#63883B"/>
            <rect x="474.178" y="68.0205" width="3.04437" height="3.04437" fill="#3C611B"/>
            <rect x="477.222" y="68.0205" width="3.04437" height="3.04437" fill="#658E40"/>
            <rect x="480.267" y="68.0205" width="3.04437" height="3.04437" fill="#68904A"/>
            <rect x="483.311" y="68.0205" width="3.04437" height="3.04437" fill="#5C8134"/>
            <rect x="486.354" y="68.0205" width="3.04437" height="3.04437" fill="#5C8134"/>
            <rect x="489.4" y="68.0205" width="3.04437" height="3.04437" fill="#517130"/>
            <rect x="492.443" y="68.0205" width="3.04437" height="3.04437" fill="#3C6336"/>
            <rect x="495.489" y="68.0205" width="3.04437" height="3.04437" fill="#3A6345"/>
            <rect x="498.532" y="68.0205" width="3.04437" height="3.04437" fill="#2F5E34"/>
            <rect x="501.576" y="68.0205" width="3.04437" height="3.04437" fill="#335B40"/>
            <rect x="504.621" y="68.0205" width="3.04437" height="3.04437" fill="#587A2D"/>
            <rect x="507.665" y="68.0205" width="3.04437" height="3.04437" fill="#587B39"/>
            <rect x="510.711" y="68.0205" width="3.04437" height="3.04437" fill="#557E30"/>
            <rect x="513.754" y="68.0205" width="3.04437" height="3.04437" fill="#335A2B"/>
            <rect x="516.8" y="68.0205" width="3.04437" height="3.04437" fill="#5A7D3B"/>
            <rect x="519.843" y="68.0205" width="3.04437" height="3.04437" fill="#2F582C"/>
            <rect x="522.887" y="68.0205" width="3.04437" height="3.04437" fill="#254F29"/>
            <rect x="525.932" y="68.0205" width="3.04437" height="3.04437" fill="#527B2D"/>
            <rect x="528.976" y="68.0205" width="3.04437" height="3.04437" fill="#537C2E"/>
            <rect x="532.021" y="68.0205" width="3.04437" height="3.04437" fill="#FAFFF9"/>
            <rect x="535.065" y="68.0205" width="3.04437" height="3.04437" fill="#60813A"/>
            <rect x="462" y="71.0649" width="3.04437" height="3.04437" fill="#F6F7F9"/>
            <rect x="465.044" y="71.0649" width="3.04437" height="3.04437" fill="#F7F7F7"/>
            <rect x="468.089" y="71.0649" width="3.04437" height="3.04437" fill="#689145"/>
            <rect x="471.133" y="71.0649" width="3.04437" height="3.04437" fill="#628C38"/>
            <rect x="474.178" y="71.0649" width="3.04437" height="3.04437" fill="#3D6618"/>
            <rect x="477.222" y="71.0649" width="3.04437" height="3.04437" fill="#689341"/>
            <rect x="480.267" y="71.0649" width="3.04437" height="3.04437" fill="#6C9342"/>
            <rect x="483.311" y="71.0649" width="3.04437" height="3.04437" fill="#638C3E"/>
            <rect x="486.354" y="71.0649" width="3.04437" height="3.04437" fill="#5E8534"/>
            <rect x="489.4" y="71.0649" width="3.04437" height="3.04437" fill="#4E7323"/>
            <rect x="492.443" y="71.0649" width="3.04437" height="3.04437" fill="#5C8833"/>
            <rect x="495.489" y="71.0649" width="3.04437" height="3.04437" fill="#5D8A35"/>
            <rect x="498.532" y="71.0649" width="3.04437" height="3.04437" fill="#5C8737"/>
            <rect x="501.576" y="71.0649" width="3.04437" height="3.04437" fill="#578031"/>
            <rect x="504.621" y="71.0649" width="3.04437" height="3.04437" fill="#577C2C"/>
            <rect x="507.665" y="71.0649" width="3.04437" height="3.04437" fill="#527B2C"/>
            <rect x="510.711" y="71.0649" width="3.04437" height="3.04437" fill="#5A8130"/>
            <rect x="513.754" y="71.0649" width="3.04437" height="3.04437" fill="#5A8430"/>
            <rect x="516.8" y="71.0649" width="3.04437" height="3.04437" fill="#558030"/>
            <rect x="519.843" y="71.0649" width="3.04437" height="3.04437" fill="#588037"/>
            <rect x="522.887" y="71.0649" width="3.04437" height="3.04437" fill="#4E7927"/>
            <rect x="525.932" y="71.0649" width="3.04437" height="3.04437" fill="#527D2B"/>
            <rect x="528.976" y="71.0649" width="3.04437" height="3.04437" fill="#F7FFF8"/>
            <rect x="532.021" y="71.0649" width="3.04437" height="3.04437" fill="white"/>
            <rect x="535.065" y="71.0649" width="3.04437" height="3.04437" fill="#FAFFFF"/>
            <rect x="465.044" y="74.1094" width="3.04437" height="3.04437" fill="#728F61"/>
            <rect x="468.089" y="74.1094" width="3.04437" height="3.04437" fill="#628D3D"/>
            <rect x="471.133" y="74.1094" width="3.04437" height="3.04437" fill="#5F8937"/>
            <rect x="474.178" y="74.1094" width="3.04437" height="3.04437" fill="#3D661A"/>
            <rect x="477.222" y="74.1094" width="3.04437" height="3.04437" fill="#628D3B"/>
            <rect x="480.267" y="74.1094" width="3.04437" height="3.04437" fill="#F6F6F8"/>
            <rect x="483.311" y="74.1094" width="3.04437" height="3.04437" fill="#698646"/>
            <rect x="486.354" y="74.1094" width="3.04437" height="3.04437" fill="#5D8433"/>
            <rect x="489.4" y="74.1094" width="3.04437" height="3.04437" fill="#4D7222"/>
            <rect x="492.443" y="74.1094" width="3.04437" height="3.04437" fill="#598434"/>
            <rect x="495.489" y="74.1094" width="3.04437" height="3.04437" fill="#5D8836"/>
            <rect x="498.532" y="74.1094" width="3.04437" height="3.04437" fill="#5D8637"/>
            <rect x="501.576" y="74.1094" width="3.04437" height="3.04437" fill="#537E2F"/>
            <rect x="504.621" y="74.1094" width="3.04437" height="3.04437" fill="#557C29"/>
            <rect x="507.665" y="74.1094" width="3.04437" height="3.04437" fill="#547B2C"/>
            <rect x="510.711" y="74.1094" width="3.04437" height="3.04437" fill="#5A822C"/>
            <rect x="513.754" y="74.1094" width="3.04437" height="3.04437" fill="#557F2D"/>
            <rect x="516.8" y="74.1094" width="3.04437" height="3.04437" fill="#527D2D"/>
            <rect x="519.843" y="74.1094" width="3.04437" height="3.04437" fill="#5E833D"/>
            <rect x="522.887" y="74.1094" width="3.04437" height="3.04437" fill="#4F7B24"/>
            <rect x="525.932" y="74.1094" width="3.04437" height="3.04437" fill="#4F7829"/>
            <rect x="528.976" y="74.1094" width="3.04437" height="3.04437" fill="#4E7E28"/>
            <rect x="532.021" y="74.1094" width="3.04437" height="3.04437" fill="#FFFFF1"/>
            <rect x="535.065" y="74.1094" width="3.04437" height="3.04437" fill="white"/>
            <rect x="538.109" y="74.1094" width="3.04437" height="3.04437" fill="#FEFFFF"/>
            <rect x="462" y="77.1538" width="3.04437" height="3.04437" fill="#FCFCFE"/>
            <rect x="465.044" y="77.1538" width="3.04437" height="3.04437" fill="#FCFFF4"/>
            <rect x="468.089" y="77.1538" width="3.04437" height="3.04437" fill="#FAFEFD"/>
            <rect x="471.133" y="77.1538" width="3.04437" height="3.04437" fill="white"/>
            <rect x="474.178" y="77.1538" width="3.04437" height="3.04437" fill="#BFBFC7"/>
            <rect x="477.222" y="77.1538" width="3.04437" height="3.04437" fill="#FBFBFB"/>
            <rect x="480.267" y="77.1538" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="483.311" y="77.1538" width="3.04437" height="3.04437" fill="#669138"/>
            <rect x="486.354" y="77.1538" width="3.04437" height="3.04437" fill="#5B8231"/>
            <rect x="489.4" y="77.1538" width="3.04437" height="3.04437" fill="#4E722A"/>
            <rect x="492.443" y="77.1538" width="3.04437" height="3.04437" fill="#5C8A32"/>
            <rect x="495.489" y="77.1538" width="3.04437" height="3.04437" fill="#F5FFEC"/>
            <rect x="498.532" y="77.1538" width="3.04437" height="3.04437" fill="#FEFFFB"/>
            <rect x="501.576" y="77.1538" width="3.04437" height="3.04437" fill="#557438"/>
            <rect x="504.621" y="77.1538" width="3.04437" height="3.04437" fill="#527F22"/>
            <rect x="507.665" y="77.1538" width="3.04437" height="3.04437" fill="#F6FFEF"/>
            <rect x="510.711" y="77.1538" width="3.04437" height="3.04437" fill="white"/>
            <rect x="513.754" y="77.1538" width="3.04437" height="3.04437" fill="#F9FFF3"/>
            <rect x="516.8" y="77.1538" width="3.04437" height="3.04437" fill="#FCFFF8"/>
            <rect x="519.843" y="77.1538" width="3.04437" height="3.04437" fill="#F7FFFB"/>
            <rect x="522.887" y="77.1538" width="3.04437" height="3.04437" fill="#4B7C21"/>
            <rect x="525.932" y="77.1538" width="3.04437" height="3.04437" fill="#4E7F24"/>
            <rect x="528.976" y="77.1538" width="3.04437" height="3.04437" fill="#F4FFFD"/>
            <rect x="532.021" y="77.1538" width="3.04437" height="3.04437" fill="white"/>
            <rect x="535.065" y="77.1538" width="3.04437" height="3.04437" fill="white"/>
            <rect x="538.109" y="77.1538" width="3.04437" height="3.04437" fill="white"/>
            <rect x="541.154" y="77.1538" width="3.04437" height="3.04437" fill="#FCFFFF"/>
            <rect x="462" y="80.1982" width="3.04437" height="3.04437" fill="#F8F8F8"/>
            <rect x="465.044" y="80.1982" width="3.04437" height="3.04437" fill="#F8F8F8"/>
            <rect x="468.089" y="80.1982" width="3.04437" height="3.04437" fill="#FCFCFC"/>
            <rect x="471.133" y="80.1982" width="3.04437" height="3.04437" fill="#FCFCFC"/>
            <rect x="474.178" y="80.1982" width="3.04437" height="3.04437" fill="#C4C4C4"/>
            <rect x="477.222" y="80.1982" width="3.04437" height="3.04437" fill="#F8F8F8"/>
            <rect x="480.267" y="80.1982" width="3.04437" height="3.04437" fill="#FAFAFA"/>
            <rect x="483.311" y="80.1982" width="3.04437" height="3.04437" fill="#63823F"/>
            <rect x="486.354" y="80.1982" width="3.04437" height="3.04437" fill="#FFFFFB"/>
            <rect x="489.4" y="80.1982" width="3.04437" height="3.04437" fill="#DAE5D7"/>
            <rect x="492.443" y="80.1982" width="3.04437" height="3.04437" fill="#F9FFF3"/>
            <rect x="495.489" y="80.1982" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="498.532" y="80.1982" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="501.576" y="80.1982" width="3.04437" height="3.04437" fill="#FBFCF6"/>
            <rect x="504.621" y="80.1982" width="3.04437" height="3.04437" fill="#537A27"/>
            <rect x="507.665" y="80.1982" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="510.711" y="80.1982" width="3.04437" height="3.04437" fill="white"/>
            <rect x="513.754" y="80.1982" width="3.04437" height="3.04437" fill="white"/>
            <rect x="516.8" y="80.1982" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="519.843" y="80.1982" width="3.04437" height="3.04437" fill="white"/>
            <rect x="522.887" y="80.1982" width="3.04437" height="3.04437" fill="#FBFEF5"/>
            <rect x="525.932" y="80.1982" width="3.04437" height="3.04437" fill="#F7F7F9"/>
            <rect x="528.976" y="80.1982" width="3.04437" height="3.04437" fill="#FFFBF8"/>
            <rect x="532.021" y="80.1982" width="3.04437" height="3.04437" fill="white"/>
            <rect x="535.065" y="80.1982" width="3.04437" height="3.04437" fill="white"/>
            <rect x="538.109" y="80.1982" width="3.04437" height="3.04437" fill="white"/>
            <rect x="462" y="83.2427" width="3.04437" height="3.04437" fill="#F7F7F7"/>
            <rect x="465.044" y="83.2427" width="3.04437" height="3.04437" fill="#F7F7F7"/>
            <rect x="468.089" y="83.2427" width="3.04437" height="3.04437" fill="#FBFCFE"/>
            <rect x="471.133" y="83.2427" width="3.04437" height="3.04437" fill="#F5FFF8"/>
            <rect x="474.178" y="83.2427" width="3.04437" height="3.04437" fill="#C2C4C3"/>
            <rect x="477.222" y="83.2427" width="3.04437" height="3.04437" fill="#F8F8F8"/>
            <rect x="480.267" y="83.2427" width="3.04437" height="3.04437" fill="#FBFBFB"/>
            <rect x="483.311" y="83.2427" width="3.04437" height="3.04437" fill="#FCFAFB"/>
            <rect x="486.354" y="83.2427" width="3.04437" height="3.04437" fill="white"/>
            <rect x="489.4" y="83.2427" width="3.04437" height="3.04437" fill="#DFDFDF"/>
            <rect x="492.443" y="83.2427" width="3.04437" height="3.04437" fill="white"/>
            <rect x="495.489" y="83.2427" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="498.532" y="83.2427" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="501.576" y="83.2427" width="3.04437" height="3.04437" fill="white"/>
            <rect x="504.621" y="83.2427" width="3.04437" height="3.04437" fill="#F2F2F4"/>
            <rect x="507.665" y="83.2427" width="3.04437" height="3.04437" fill="white"/>
            <rect x="510.711" y="83.2427" width="3.04437" height="3.04437" fill="white"/>
            <rect x="513.754" y="83.2427" width="3.04437" height="3.04437" fill="white"/>
            <rect x="516.8" y="83.2427" width="3.04437" height="3.04437" fill="#FCFFFF"/>
            <rect x="519.843" y="83.2427" width="3.04437" height="3.04437" fill="#FFFDFF"/>
            <rect x="522.887" y="83.2427" width="3.04437" height="3.04437" fill="white"/>
            <rect x="525.932" y="83.2427" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="528.976" y="83.2427" width="3.04437" height="3.04437" fill="#FFFEFF"/>
            <rect x="532.021" y="83.2427" width="3.04437" height="3.04437" fill="white"/>
            <rect x="535.065" y="83.2427" width="3.04437" height="3.04437" fill="#FEFEFC"/>
            <rect x="538.109" y="83.2427" width="3.04437" height="3.04437" fill="#FFFDFE"/>
            <rect x="541.154" y="83.2427" width="3.04437" height="3.04437" fill="#FAFFFF"/>
            <rect x="462" y="86.2871" width="3.04437" height="3.04437" fill="#FBFBFB"/>
            <rect x="465.044" y="86.2871" width="3.04437" height="3.04437" fill="#FAFAFA"/>
            <rect x="468.089" y="86.2871" width="3.04437" height="3.04437" fill="#456E4C"/>
            <rect x="471.133" y="86.2871" width="3.04437" height="3.04437" fill="#3D6B47"/>
            <rect x="474.178" y="86.2871" width="3.04437" height="3.04437" fill="#C4C4C4"/>
            <rect x="477.222" y="86.2871" width="3.04437" height="3.04437" fill="#FAFAFA"/>
            <rect x="480.267" y="86.2871" width="3.04437" height="3.04437" fill="#FCFCFC"/>
            <rect x="483.311" y="86.2871" width="3.04437" height="3.04437" fill="#FDFDFD"/>
            <rect x="486.354" y="86.2871" width="3.04437" height="3.04437" fill="#395441"/>
            <rect x="489.4" y="86.2871" width="3.04437" height="3.04437" fill="#E7DEE1"/>
            <rect x="492.443" y="86.2871" width="3.04437" height="3.04437" fill="white"/>
            <rect x="495.489" y="86.2871" width="3.04437" height="3.04437" fill="white"/>
            <rect x="498.532" y="86.2871" width="3.04437" height="3.04437" fill="#FFFEFF"/>
            <rect x="501.576" y="86.2871" width="3.04437" height="3.04437" fill="#FFFEFF"/>
            <rect x="504.621" y="86.2871" width="3.04437" height="3.04437" fill="#F5F5F5"/>
            <rect x="507.665" y="86.2871" width="3.04437" height="3.04437" fill="white"/>
            <rect x="510.711" y="86.2871" width="3.04437" height="3.04437" fill="white"/>
            <rect x="513.754" y="86.2871" width="3.04437" height="3.04437" fill="#364E40"/>
            <rect x="516.8" y="86.2871" width="3.04437" height="3.04437" fill="#2C5B37"/>
            <rect x="519.843" y="86.2871" width="3.04437" height="3.04437" fill="#32593A"/>
            <rect x="522.887" y="86.2871" width="3.04437" height="3.04437" fill="white"/>
            <rect x="525.932" y="86.2871" width="3.04437" height="3.04437" fill="white"/>
            <rect x="528.976" y="86.2871" width="3.04437" height="3.04437" fill="#2C4E35"/>
            <rect x="532.021" y="86.2871" width="3.04437" height="3.04437" fill="white"/>
            <rect x="535.065" y="86.2871" width="3.04437" height="3.04437" fill="#375A42"/>
            <rect x="538.109" y="86.2871" width="3.04437" height="3.04437" fill="#FBFFFF"/>
            <rect x="541.154" y="86.2871" width="3.04437" height="3.04437" fill="#FEFFFF"/>
            <rect x="465.044" y="89.3308" width="3.04437" height="3.04437" fill="#497659"/>
            <rect x="468.089" y="89.3308" width="3.04437" height="3.04437" fill="#487451"/>
            <rect x="471.133" y="89.3308" width="3.04437" height="3.04437" fill="#F7FFF8"/>
            <rect x="474.178" y="89.3308" width="3.04437" height="3.04437" fill="#C6C5C3"/>
            <rect x="477.222" y="89.3308" width="3.04437" height="3.04437" fill="#F5FFFA"/>
            <rect x="480.267" y="89.3308" width="3.04437" height="3.04437" fill="#FEFEFE"/>
            <rect x="483.311" y="89.3308" width="3.04437" height="3.04437" fill="#3B523E"/>
            <rect x="486.354" y="89.3308" width="3.04437" height="3.04437" fill="#376541"/>
            <rect x="489.4" y="89.3308" width="3.04437" height="3.04437" fill="#2B4F33"/>
            <rect x="492.443" y="89.3308" width="3.04437" height="3.04437" fill="white"/>
            <rect x="495.489" y="89.3308" width="3.04437" height="3.04437" fill="white"/>
            <rect x="498.532" y="89.3308" width="3.04437" height="3.04437" fill="#376944"/>
            <rect x="501.576" y="89.3308" width="3.04437" height="3.04437" fill="#2E5D39"/>
            <rect x="504.621" y="89.3308" width="3.04437" height="3.04437" fill="#F0FBF3"/>
            <rect x="507.665" y="89.3308" width="3.04437" height="3.04437" fill="white"/>
            <rect x="510.711" y="89.3308" width="3.04437" height="3.04437" fill="#35513B"/>
            <rect x="513.754" y="89.3308" width="3.04437" height="3.04437" fill="#2C5E39"/>
            <rect x="516.8" y="89.3308" width="3.04437" height="3.04437" fill="#2B5D38"/>
            <rect x="519.843" y="89.3308" width="3.04437" height="3.04437" fill="#2F5C3B"/>
            <rect x="522.887" y="89.3308" width="3.04437" height="3.04437" fill="#285536"/>
            <rect x="528.976" y="89.3308" width="3.04437" height="3.04437" fill="#275531"/>
            <rect x="532.021" y="89.3308" width="3.04437" height="3.04437" fill="#285337"/>
            <rect x="538.109" y="89.3308" width="3.04437" height="3.04437" fill="#285430"/>
            <rect x="541.154" y="89.3308" width="3.04437" height="3.04437" fill="#254F39"/>
            <rect x="474.178" y="92.3752" width="3.04437" height="3.04437" fill="#204921"/>
            <rect x="477.222" y="92.3752" width="3.04437" height="3.04437" fill="#43764B"/>
            <rect x="480.267" y="92.3752" width="3.04437" height="3.04437" fill="#416855"/>
            <rect x="483.311" y="92.3752" width="3.04437" height="3.04437" fill="#3D6A49"/>
            <rect x="486.354" y="92.3752" width="3.04437" height="3.04437" fill="#37663C"/>
            <rect x="498.532" y="92.3752" width="3.04437" height="3.04437" fill="#415F3D"/>
            <rect x="501.576" y="92.3752" width="3.04437" height="3.04437" fill="#31613B"/>
            <rect x="504.621" y="92.3752" width="3.04437" height="3.04437" fill="#2E5F3F"/>
            <rect x="488.121" y="51.2012" width="4.79289" height="4.79289" transform="rotate(-180 488.121 51.2012)" fill="#C50306"/>
            <rect x="509.21" y="35.384" width="4.79289" height="4.79289" transform="rotate(-180 509.21 35.384)" fill="#C50306"/>
            <rect x="502.499" y="16.6929" width="4.79289" height="4.79289" transform="rotate(-180 502.499 16.6929)" fill="#C50306"/>
            <rect x="526.705" y="65.8193" width="4.79289" height="4.79289" transform="rotate(-180 526.705 65.8193)" fill="#C50306"/>
            <rect x="496.269" y="81.8755" width="4.79289" height="4.79289" transform="rotate(-180 496.269 81.8755)" fill="#C50306"/>
            <rect x="472.306" y="80.4375" width="4.79289" height="4.79289" transform="rotate(-180 472.306 80.4375)" fill="#C50306"/>
            <rect x="535.09" y="79.479" width="4.79289" height="4.79289" transform="rotate(-180 535.09 79.479)" fill="#C50306"/>
            </g>
            <defs>
            <clipPath id="clip0_2292_24949">
            <rect width="600" height="300" rx="5" fill="white"/>
            </clipPath>
            </defs>
        """.trimIndent()

        override fun drawBorder(): String {
            return "<rect x=\"0.5\" y=\"0.5\" width=\"599\" height=\"299\" rx=\"4.5\" stroke=\"#D9D9D9\"/>"
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
