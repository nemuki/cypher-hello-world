package com.naoki.takahashi.cypherhelloworld

import org.apache.juli.logging.LogFactory
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/error")
class CustomErrorController : ErrorController {

    private val log = LogFactory.getLog(CustomErrorController::class.java)

    @RequestMapping
    fun handleError(request: HttpServletRequest): ResponseEntity<ApplicationError> {

        val statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            val error = ApplicationError("no handler found")
            return ResponseEntity<ApplicationError>(error, HttpStatus.NOT_FOUND)
        }

        log.error(request.getAttribute(RequestDispatcher.ERROR_EXCEPTION))
        val error = ApplicationError("something wrong ;-(")
        return ResponseEntity<ApplicationError>(error, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
