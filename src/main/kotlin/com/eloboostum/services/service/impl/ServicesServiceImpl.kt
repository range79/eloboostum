package com.eloboostum.services.service.impl

import com.eloboostum.services.domain.model.Services
import com.eloboostum.services.domain.repository.ServiceRepository
import com.eloboostum.services.dto.ServiceRequest
import com.eloboostum.services.exception.ServiceNotFoundException
import com.eloboostum.services.mapper.ServiceMapper
import com.eloboostum.services.service.ServicesService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ServicesServiceImpl (
    private val servicesRepository: ServiceRepository,
    private val serviceMapper: ServiceMapper
): ServicesService {
    override fun getAllServices(pageable: Pageable): Page<Services> {
        return servicesRepository.findAll(pageable)
    }

    override fun getServiceById(id: Long): Services {
        return findService(id)
    }

    override fun createService(serviceRequest: ServiceRequest) {
        serviceMapper.serviceRequestToService(serviceRequest).let {
            servicesRepository.save(it)
        }
        return
    }

    override fun updateService(
        id: Long,
        serviceRequest: ServiceRequest
    ): Services {
        val service =findService(id)
        serviceMapper.updateService(service,serviceRequest)
        return servicesRepository.save(service)
    }

    override fun deleteServiceById(id: Long){
        val service=  findService(id)
        return servicesRepository.delete(service)
    }


    private fun findService(id: Long): Services = servicesRepository.findById(id).orElseThrow {
        ServiceNotFoundException(
            "Service with ID $id not found"
        )
    }
}