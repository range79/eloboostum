package com.eloboostum.common.exception

import com.eloboostum.common.util.ErrorResponseUtil
import com.eloboostum.error.domain.model.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler (
    private val errorResponseUtil: ErrorResponseUtil
){
    @ExceptionHandler(value = [(AbstractExceptionHandler::class)])
    fun handleAbstractExceptionHandler(e: AbstractExceptionHandler): ResponseEntity<Errors> {
        return errorResponseUtil.buildErrorResponse(e.status,e)
    }
    @ExceptionHandler(value = [(Exception::class)])
    fun handleServerErrors(e: Exception): ResponseEntity<Errors> {
        return errorResponseUtil.buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,e)
    }
}