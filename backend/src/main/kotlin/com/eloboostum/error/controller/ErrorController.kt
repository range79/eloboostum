package com.eloboostum.error.controller

import com.eloboostum.error.api.ErrorApi
import com.eloboostum.error.domain.model.ErrorTypes
import com.eloboostum.error.domain.model.Errors
import com.eloboostum.error.service.ErrorService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController

@RestController
class ErrorController (
    private val errorService: ErrorService
): ErrorApi{
    override fun getAllErrors(pageable: Pageable): Page<Errors> {
        return errorService.getAllErrors(pageable)
    }

    override fun getError(id: Long): Errors? {
        return errorService.getError(id)
    }

    override fun getErrorsByStatus(
        type: ErrorTypes,
        pageable: Pageable
    ): Page<Errors> {
        return errorService.getErrorsByStatus(type, pageable)
    }
}