package com.nemuki.cypherhelloworld.handler

import com.nemuki.cypherhelloworld.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorHandler {
    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun requestNotFoundError() = ErrorResponse("no handler found")

    @ExceptionHandler(Exception::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun applicationExceptionError() = ErrorResponse("something wrong ;-(")

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleValidationException(ex: ConstraintViolationException) =
        ErrorResponse("invalid parameter: detail: [${ex.localizedMessage}]")
}
