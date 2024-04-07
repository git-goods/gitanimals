package org.gitanimals.render.domain

import org.springframework.core.io.ClassPathResource
import java.nio.charset.Charset

val gooseSvg: String = ClassPathResource("persona/animal/goose.svg")
    .getContentAsString(Charset.defaultCharset())

val littleChickSvg: String = ClassPathResource("persona/animal/little-chick.svg")
    .getContentAsString(Charset.defaultCharset())

val numberSvgs = listOf(
    ClassPathResource("persona/level/small-0.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-1.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-2.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-3.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-4.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-5.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-6.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-7.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-8.svg")
        .getContentAsString(Charset.defaultCharset()),
    ClassPathResource("persona/level/small-9.svg")
        .getContentAsString(Charset.defaultCharset()),
)
