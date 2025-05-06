package org.gitanimals.core.auth

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RequiredUserEntryPoints(
    val expected: Array<UserEntryPoint>,
)

enum class UserEntryPoint {
    ANY,
    GITHUB,
    APPLE,
    ;
}
