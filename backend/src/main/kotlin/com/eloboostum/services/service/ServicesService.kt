package com.eloboostum.services.service

import com.eloboostum.services.domain.model.Services
import com.eloboostum.services.dto.ServiceRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface ServicesService {
    fun getAllServices(pageable: Pageable): Page<Services>
    fun getServiceById(id: Long): Services
    fun createService(serviceRequest: ServiceRequest)
    fun updateService(id: Long, serviceRequest: ServiceRequest): Services
    fun deleteServiceById(id: Long)
}