package org.gitanimals.core

import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.core.filter.MDCFilter.Companion.USER_ENTRY_POINT
import org.gitanimals.core.filter.MDCFilter.Companion.USER_ID
import org.rooftop.netx.api.Context
import org.rooftop.netx.api.ContextOrchestrate
import org.rooftop.netx.api.ContextRollback
import org.slf4j.LoggerFactory
import org.slf4j.MDC

open class TraceIdContextOrchestrator<T : Any, V : Any>(
    private val orchestrate: ContextOrchestrate<T, V>,
) : ContextOrchestrate<T, V> {

    override fun orchestrate(context: Context, request: T): V {
        runCatching { context.decodeContext(TRACE_ID, String::class) }
            .onSuccess { MDC.put(TRACE_ID, it) }
        runCatching { context.decodeContext(USER_ID, String::class) }
            .onSuccess { MDC.put(USER_ID, it) }
        runCatching { context.decodeContext(USER_ENTRY_POINT, String::class) }
            .onSuccess { MDC.put(USER_ENTRY_POINT, it) }

        return runCatching {
            orchestrate.orchestrate(context, request)
        }.getOrElse {
            logger.warn("Orchestrating fail, rollback start. request: \"$request\"", it)
            throw it
        }.also {
            MDC.remove(TRACE_ID)
            MDC.remove(USER_ID)
            MDC.remove(USER_ENTRY_POINT)
        }
    }

    private companion object {
        private val logger = LoggerFactory.getLogger(this::class.simpleName)
    }
}

open class TraceIdContextRollback<T : Any, V : Any?>(
    private val rollback: ContextRollback<T, V>,
) : ContextRollback<T, V> {

    override fun rollback(context: Context, request: T): V {
        runCatching { context.decodeContext(TRACE_ID, String::class) }
            .onSuccess { MDC.put(TRACE_ID, it) }
        runCatching { context.decodeContext(USER_ID, String::class) }
            .onSuccess { MDC.put(USER_ID, it) }
        runCatching { context.decodeContext(USER_ENTRY_POINT, String::class) }
            .onSuccess { MDC.put(USER_ENTRY_POINT, it) }

        return runCatching {
            rollback.rollback(context, request)
        }.getOrElse {
            logger.error("Rollback fail need to fix. request: \"$request\"", it)
            throw it
        }.also {
            MDC.remove(TRACE_ID)
            MDC.remove(USER_ID)
            MDC.remove(USER_ENTRY_POINT)
        }
    }

    private companion object {
        private val logger = LoggerFactory.getLogger(this::class.simpleName)
    }
}
