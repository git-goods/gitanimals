package org.gitanimals.core.advice

import org.gitanimals.core.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingRequestHeaderException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @ExceptionHandler(MissingRequestHeaderException::class)
    fun handleMissingRequestHeaderException(exception: MissingRequestHeaderException): ResponseEntity<ErrorResponse> {
        if (exception.headerName == "Authorization") {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ErrorResponse.from(exception))
        }

        return ResponseEntity.badRequest().body(ErrorResponse.from(exception))
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(exception: IllegalStateException): ErrorResponse {
        logger.error(exception.message, exception)
        return ErrorResponse.from(exception)
    }
}
