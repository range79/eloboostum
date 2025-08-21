package com.eloboostum.common.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [(AbstractExceptionHandler::class)])
    fun handle(e: AbstractExceptionHandler): ResponseEntity<Any> {
val a :Int=e.status.value()
    }
}