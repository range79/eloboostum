package com.eloboostum.error.service

import com.eloboostum.error.domain.model.ErrorTypes
import com.eloboostum.error.domain.model.Errors
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface ErrorService {
    fun getAllErrors(pageable: Pageable): Page<Errors>
    fun getError(id: Long): Errors?
    fun getErrorsByStatus(type: ErrorTypes, pageable: Pageable): Page<Errors>
    fun saveError(error: Errors): Errors
}