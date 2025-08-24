package com.eloboostum.error.domain.repository

import com.eloboostum.error.domain.model.ErrorTypes
import com.eloboostum.error.domain.model.Errors
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ErrorRepository: JpaRepository<Errors, Long>{

    fun findByType(type: ErrorTypes,pageable: Pageable): Page<Errors>

}