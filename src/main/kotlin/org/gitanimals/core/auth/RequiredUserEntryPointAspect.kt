package org.gitanimals.core.auth

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.gitanimals.core.auth.UserEntryPointValidationExtension.withUserEntryPointValidation
import org.springframework.stereotype.Component

@Aspect
@Component
class RequiredUserEntryPointAspect {

    @Around("@annotation(requiredUserEntryPoints)")
    fun validate(
        proceedingJoinPoint: ProceedingJoinPoint,
        requiredUserEntryPoints: RequiredUserEntryPoints,
    ): Any? {
        return withUserEntryPointValidation(
            expectedUserEntryPoints = requiredUserEntryPoints.expected,
            onSuccess = { proceedingJoinPoint.proceed() },
        )
    }
}
