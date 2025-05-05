package org.gitanimals.core.extension

object StringExtension {

    fun String.trimNotDigitCharacters(): String {
        var trimed = this.trim()

        if (trimed.first().isDigit().not()) {
            trimed = trimed.drop(1)
        }
        if (trimed.last().isDigit().not()) {
            trimed = trimed.dropLast(1)
        }

        return trimed
    }

    fun String.deleteBrackets(): String {
        val start = when (this[0]) {
            '{' -> 1
            else -> 0
        }

        val end = when (this.last()) {
            '}' -> this.length - 1
            else -> this.length
        }

        return this.substring(start, end)
    }
}
