package com.eloboostum.services.mapper

import com.eloboostum.services.domain.model.Services
import com.eloboostum.services.dto.ServiceRequest
import org.springframework.stereotype.Service

@Service
class  ServiceMapper {
    fun serviceRequestToService(serviceRequest: ServiceRequest): Services=Services(
        id=null,
        name=serviceRequest.name,
        description=serviceRequest.description,
        coverImageURL=serviceRequest.coverImageURL,
    )
    fun updateService(service: Services,updateService: ServiceRequest){
        service.name = updateService.name ?: service.name
        service.description = updateService.description ?: service.description
        service.coverImageURL = updateService.coverImageURL ?: service.coverImageURL

    }
}