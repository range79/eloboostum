package com.eloboostum.error.service

import com.eloboostum.error.domain.model.ErrorTypes
import com.eloboostum.error.domain.model.Errors
import com.eloboostum.error.domain.repository.ErrorRepository
import com.eloboostum.error.exception.ErrorNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ErrorServiceImpl(
    private val errorRepository: ErrorRepository,
): ErrorService {
    override fun getAllErrors(pageable: Pageable): Page<Errors> {
        return errorRepository.findAll(pageable)
    }

    override fun getError(id: Long): Errors? {
        return errorRepository.findById(id).orElseThrow { ErrorNotFoundException("Error with id $id not found") }
    }

    override fun getErrorsByStatus(
        type: ErrorTypes,
        pageable: Pageable
    ): Page<Errors> {
        return errorRepository.findByType(type,pageable)
    }

    override fun saveError(error: Errors): Errors {
       return errorRepository.save(error)
    }
}