package org.gitanimals.core

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

object ProfileIdentifier {

    private lateinit var holder: Holder
    const val LOCAL = "local"
    const val LIVE = "live"

    fun getProfile(): String = holder.profile

    fun isLocal(): Boolean = holder.profile == LOCAL


    @Component
    class Holder(
        @Value("\${spring.profiles.active}") val profile: String,
    ) {
        init {
            holder = this
        }
    }
}
