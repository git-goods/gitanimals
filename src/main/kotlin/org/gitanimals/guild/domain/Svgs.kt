package org.gitanimals.guild.domain

import org.springframework.core.io.ClassPathResource
import java.nio.charset.Charset

val dummyGuildFieldSvg: String = ClassPathResource("persona/field/white-field.svg")
    .getContentAsString(Charset.defaultCharset())

val logoShowingFieldSvg: String = ClassPathResource("persona/field/logo-showing.svg")
    .getContentAsString(Charset.defaultCharset())

val largeTextSvgs = lazy {
    val map = mutableMapOf<String, String>()
    for (i in 'A'..'Z') {
        val path = "persona/text/large/$i.svg"
        map[i.toString()] = ClassPathResource(path)
            .getContentAsString(Charset.defaultCharset())
    }
    for (i in 'a'..'z') {
        val path = "persona/text/large/_$i.svg"
        map[i.toString()] = ClassPathResource(path)
            .getContentAsString(Charset.defaultCharset())
    }
    for (i in 0..9) {
        val path = "persona/text/large/$i.svg"
        map[i.toString()] = ClassPathResource(path)
            .getContentAsString(Charset.defaultCharset())
    }
    map["-"] = ClassPathResource("persona/text/large/hyphens.svg")
        .getContentAsString(Charset.defaultCharset())
    map
}.value

val mediumNumberSvgs = lazy {
    val list = mutableListOf<String>()
    for (i in 0..9) {
        val path = "persona/text/medium/$i.svg"
        list.add(
            ClassPathResource(path)
                .getContentAsString(Charset.defaultCharset())
        )
    }
    list
}.value

val numberSvgs = lazy {
    val list = mutableListOf<String>()
    for (i in 0..9) {
        val path = "persona/text/small/$i.svg"
        list.add(
            ClassPathResource(path)
                .getContentAsString(Charset.defaultCharset())
        )
    }
    list
}.value

