package org.gitanimals.core.auth

import org.springframework.stereotype.Component

object UserEntryPointValidationExtension {

    private lateinit var internalAuth: InternalAuth

    fun <T> withUserEntryPointValidation(
        expectedUserEntryPoints: Array<UserEntryPoint>,
        onSuccess: () -> T,
        failMessage: (UserEntryPoint?) -> String = { userEntryPoint ->
            "ExpectedUserEntryPoints: \"$expectedUserEntryPoints\" but request user entryPoint is \"$userEntryPoint\""
        }
    ): T {
        val userEntryPoint = runCatching {
            val userEntryPointString = internalAuth.getUserEntryPoint {
                throw IllegalArgumentException(failMessage.invoke(null))
            }
            UserEntryPoint.valueOf(userEntryPointString)
        }.getOrElse {
            throw IllegalArgumentException(failMessage.invoke(null))
        }

        require(
            expectedUserEntryPoints.contains(UserEntryPoint.ANY)
                    || userEntryPoint in expectedUserEntryPoints
        ) { failMessage.invoke(userEntryPoint) }

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
