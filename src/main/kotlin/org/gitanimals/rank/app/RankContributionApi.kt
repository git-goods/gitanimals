package org.gitanimals.rank.app

import java.time.LocalDate

fun interface RankContributionApi {

    fun getContributionsBySpecificDays(username: String, from: LocalDate, to: LocalDate): Int
}
