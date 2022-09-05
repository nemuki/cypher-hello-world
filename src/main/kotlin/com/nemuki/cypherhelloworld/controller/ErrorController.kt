package com.nemuki.cypherhelloworld.controller

import com.nemuki.cypherhelloworld.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun errorRequest() = ErrorResponse("no handler found")
}
