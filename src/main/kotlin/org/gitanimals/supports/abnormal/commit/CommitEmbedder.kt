package org.gitanimals.supports.abnormal.commit

class CommitEmbedder {

    fun embed(code: String): List<Float> {
        val lines = code.split("\n")

        lines.asSequence()
            .filter {
                it.startsWith("+ ") || it.startsWith("- ")
            }
            .
    }
}


