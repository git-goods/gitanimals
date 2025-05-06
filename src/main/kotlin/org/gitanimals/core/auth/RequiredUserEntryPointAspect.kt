package org.gitanimals.core.auth

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.gitanimals.core.auth.UserEntryPointValidationExtension.withUserEntryPointValidation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class RequiredUserEntryPointAspect {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Around("@annotation(requiredUserEntryPoints)")
    fun validate(
        proceedingJoinPoint: ProceedingJoinPoint,
        requiredUserEntryPoints: RequiredUserEntryPoints,
    ): Any? {
        return withUserEntryPointValidation(
            expectedUserEntryPoints = requiredUserEntryPoints.expected,
            onSuccess = { proceedingJoinPoint.proceed() },
            failMessage = {
                val message =
                    "ExpectedUserEntryPoints: \"${requiredUserEntryPoints.expected}\" but request user entryPoint is \"$it\""
                logger.info("[RequiredUserEntryPointAspect] $message")
                message
            }
        )
    }
}
