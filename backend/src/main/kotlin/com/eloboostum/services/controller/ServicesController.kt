package com.eloboostum.services.controller

import com.eloboostum.services.api.ServicesApi
import com.eloboostum.services.domain.model.Services
import com.eloboostum.services.dto.ServiceRequest
import com.eloboostum.services.service.ServicesService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ServicesController (
    private val service: ServicesService
): ServicesApi {
    override fun getAllServices(pageable: Pageable): Page<Services> {
        return service.getAllServices(pageable)
    }

    override fun getServiceById(id: Long): Services {
        return service.getServiceById(id)
    }

    @ResponseStatus(HttpStatus.CREATED)
    override fun createService(serviceRequest: ServiceRequest) {
        return service.createService(serviceRequest)
    }

    override fun updateService(
        id: Long,
        serviceRequest: ServiceRequest
    ): Services {
        return service.updateService(id,serviceRequest)
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun deleteServiceById(id: Long) {
        return service.deleteServiceById(id)
    }
}