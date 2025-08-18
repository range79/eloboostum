package com.eloboostum.services.api

import com.eloboostum.services.domain.model.Services
import com.eloboostum.services.dto.ServiceRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RequestMapping("\${api.prefix}/services")
interface ServicesApi {
    @GetMapping("/all")
    fun getAllServices( @PageableDefault(size = 20, sort = ["id"]) pageable: Pageable): Page<Services>
    @GetMapping("/{id}")
    fun getServiceById(@PathVariable id: Long): Services
    @GetMapping("/create")
    fun createService(@RequestBody serviceRequest: ServiceRequest)
    @GetMapping("/update/{id}")
    fun updateService(@PathVariable id: Long,@RequestBody serviceRequest: ServiceRequest): Services
    @DeleteMapping("/delete/{id}")
    fun deleteServiceById(@PathVariable id: Long)
}