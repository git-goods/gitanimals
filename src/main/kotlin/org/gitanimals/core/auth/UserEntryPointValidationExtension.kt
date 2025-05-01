package org.gitanimals.core.auth

import org.springframework.stereotype.Component

object UserEntryPointValidationExtension {

    private lateinit var internalAuth: InternalAuth

    fun <T> withUserEntryPointValidation(
        expectedUserEntryPoints: Array<UserEntryPoint>,
        onSuccess: () -> T,
        failMessage: () -> String = {
            "\"$expectedUserEntryPoints\" User cannot pass."
        }
    ): T {
        val userEntryPoint = internalAuth.getUserEntryPoint {
            throw IllegalArgumentException(failMessage.invoke())
        }

        require(
            expectedUserEntryPoints.contains(UserEntryPoint.ANY) ||
            UserEntryPoint.valueOf(userEntryPoint) in expectedUserEntryPoints
        ) {
            failMessage.invoke()
        }

        return onSuccess.invoke()
    }

    @Component
    class UserEntryPointValidationExtensionBeanInjector(
        internalAuth: InternalAuth,
    ) {

        init {
            UserEntryPointValidationExtension.internalAuth = internalAuth
        }
    }
}
