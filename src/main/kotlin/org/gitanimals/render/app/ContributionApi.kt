package org.gitanimals.render.app

interface ContributionApi {

    fun getContributionCount(username: String, years: List<Int>): Map<Int, Int>

    fun getAllContributionYears(username: String): List<Int>
}
