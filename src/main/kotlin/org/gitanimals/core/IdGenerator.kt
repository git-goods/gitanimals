package org.gitanimals.core

import com.github.f4b6a3.tsid.TsidFactory

object IdGenerator {

    private val tsidFactory = TsidFactory.newInstance256()

    fun generate(): Long = tsidFactory.create().toLong()
}
