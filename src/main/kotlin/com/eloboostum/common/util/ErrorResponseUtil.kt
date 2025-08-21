package com.eloboostum.common.util

import com.eloboostum.common.model.ErrorResponse
import com.eloboostum.error.domain.model.ErrorTypes
import com.eloboostum.error.domain.model.Errors
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ErrorResponseUtil {
    private val logger = LoggerFactory.getLogger(ErrorResponseUtil::class.java)
    fun buildErrorResponse(status: HttpStatus, e: Exception): ResponseEntity<Errors>{
        val errorTypes: ErrorTypes
        if(status.is5xxServerError){
            errorTypes= ErrorTypes.SERVER_ERROR
            logger.error(e.message)

        }
        else{
            errorTypes=ErrorTypes.CLIENT_ERROR
            logger.warn(e.message)
        }
        val error = Errors(
            id = null,
            message = e.message,
            type = errorTypes
        )
        return Error


    }
}