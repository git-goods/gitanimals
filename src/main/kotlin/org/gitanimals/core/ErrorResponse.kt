package org.gitanimals.core

data class ErrorResponse(
    val message: String,
) {

    companion object {
        fun from(exception: Exception): ErrorResponse =
            ErrorResponse(exception.message ?: exception.localizedMessage)
    }
}
