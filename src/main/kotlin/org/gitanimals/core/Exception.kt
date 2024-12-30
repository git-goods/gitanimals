package org.gitanimals.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class AuthorizationException(message: String) : IllegalArgumentException(message)

val AUTHORIZATION_EXCEPTION = AuthorizationException("Authorization fail")
