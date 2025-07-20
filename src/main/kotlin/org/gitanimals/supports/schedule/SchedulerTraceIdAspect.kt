package org.gitanimals.supports.schedule

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.slf4j.MDC
import org.springframework.core.annotation.Order
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(value = Int.MIN_VALUE)
class SchedulerTraceIdAspect {

    @Around("@annotation(scheduled)")
    fun putMdcFilter(joinPoint: ProceedingJoinPoint, scheduled: Scheduled): Any? {
        return runCatching {
            MDC.put(TRACE_ID, IdGenerator.generate().toString())
            joinPoint.proceed()
        }.also {
            MDC.remove(TRACE_ID)
        }.onFailure {
            throw it
        }
    }
}
