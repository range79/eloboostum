package com.eloboostum.error.api

import com.eloboostum.error.domain.model.ErrorTypes
import com.eloboostum.error.domain.model.Errors
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/errors")
interface ErrorApi {
    @GetMapping("/all")
    fun getAllErrors(@PageableDefault(size = 20, sort = ["id"]) pageable: Pageable): Page<Errors>
    @GetMapping("/errors/{id}")
    fun getError(@PathVariable id: Long): Errors?
    @GetMapping("/errors/{type}")
    fun getErrorsByStatus(@PathVariable type: ErrorTypes, @PageableDefault(size = 20, sort = ["id"]) pageable: Pageable): Page<Errors>
}