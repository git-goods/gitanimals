package org.gitanimals.render.infra

import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.core.instant
import org.gitanimals.render.domain.PersonaStatisticService
import org.gitanimals.render.infra.event.NewPetDropRateDistributionEvent
import org.gitanimals.render.infra.event.Type
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.context.ApplicationEventPublisher
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.temporal.ChronoUnit

@Component
class NewPetDropRateDistributionReport(
    private val personaStatisticService: PersonaStatisticService,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Scheduled(cron = EVERY_9AM, zone = "Asia/Seoul")
    fun reportDailyNewPetDropRateDistribution() {
        runCatching {
            publishDropRateDistribution(1, Type.DAILY)
        }.also {
            MDC.remove(TRACE_ID)
        }
    }

    @Scheduled(cron = EVERY_SUNDAY_9AM, zone = "Asia/Seoul")
    fun reportWeeklyNewPetDropRateDistribution() {
        runCatching {
            publishDropRateDistribution(7, Type.WEEKLY)
        }.also {
            MDC.remove(TRACE_ID)
        }
    }

    @Scheduled(cron = EVERY_FIRST_DAY_OF_MONTH_9AM, zone = "Asia/Seoul")
    fun reportMonthlyNewPetDropRateDistribution() {
        runCatching {
            publishDropRateDistribution(30, Type.MONTHLY)
        }.also {
            MDC.remove(TRACE_ID)
        }
    }

    private fun publishDropRateDistribution(days: Long, type: Type) {
        logger.info("[NewPetDropRateDistributionReport] Aggregate yesterday days pet distribution drop rate...")

        val createdAt = instant().minus(days, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS)
        val distributionResponse =
            personaStatisticService.getAggregatedPersonaDistributionByCreatedAtAfter(createdAt)

        val event = NewPetDropRateDistributionEvent(
            type = type,
            distributions = distributionResponse.map {
                NewPetDropRateDistributionEvent.Distribution(
                    it.dropRate,
                    it.count,
                )
            }
        )

        applicationEventPublisher.publishEvent(event)
    }

    companion object {
        private const val EVERY_9AM = "0 0 9 * * ?"
        private const val EVERY_SUNDAY_9AM = "0 0 9 * * SUN"
        private const val EVERY_FIRST_DAY_OF_MONTH_9AM = "0 0 9 1 * *"
    }
}
