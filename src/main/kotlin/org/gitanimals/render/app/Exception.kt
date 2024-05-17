package org.gitanimals.render.app


class AuthorizationException(message: String) : IllegalArgumentException(message)

val AUTHORIZATION_EXCEPTION = AuthorizationException("Authorization fail")
