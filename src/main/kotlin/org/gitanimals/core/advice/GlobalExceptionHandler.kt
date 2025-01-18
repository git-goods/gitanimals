package org.gitanimals.core.advice

import org.gitanimals.core.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingRequestHeaderException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MissingRequestHeaderException::class)
    fun handleMissingRequestHeaderException(exception: MissingRequestHeaderException): ResponseEntity<ErrorResponse> {
        if (exception.headerName == "Authorization") {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ErrorResponse.from(exception))
        }

        return ResponseEntity.badRequest().body(ErrorResponse.from(exception))
    }
}
