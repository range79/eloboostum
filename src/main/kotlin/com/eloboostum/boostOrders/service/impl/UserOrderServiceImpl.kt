package com.eloboostum.boostOrders.service.impl

import com.eloboostum.boostOrders.domain.model.BoostOrder
import com.eloboostum.boostOrders.domain.repository.BoostOrderRepository
import com.eloboostum.boostOrders.enum.BoostStatus
import com.eloboostum.boostOrders.exception.BoostAuthorException
import com.eloboostum.boostOrders.exception.BoostOrderNotException
import com.eloboostum.boostOrders.service.UserOrderService
import com.eloboostum.common.service.SecurityUtils
import com.eloboostum.services.service.ServicesService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserOrderServiceImpl (
    private val servicesServices: ServicesService,
    private val boostOrderRepository: BoostOrderRepository,
    private val securityUtils: SecurityUtils,

    ): UserOrderService {

    override fun requestBoost(serviceId: Long) {
        servicesServices.getServiceById(serviceId)
        val boost = BoostOrder(
            id = null,
            userId = securityUtils.getCurrentUserId(),
            serviceId = serviceId,
            boostStatus = BoostStatus.ACTIVE,
            boosterId = null,
            acceptedAt =null,
            deleted = false,
        )
        boostOrderRepository.save(boost)

    }

    override fun deleteBoost(boostId: Long) {

        val order =findBoost(boostId)
        if (order.userId!=securityUtils.getCurrentUserId()) {
            throw BoostAuthorException("You can not delete this order!")
        }
        order.deleted = true
        boostOrderRepository.save(order)
    }

    override fun findMyOrders(pageable: Pageable): Page<BoostOrder> {
        return boostOrderRepository.findByUserId(securityUtils.getCurrentUserId(),pageable)
    }


    private fun findBoost(boostId: Long): BoostOrder {
        return boostOrderRepository.findById(boostId).orElseThrow{
            BoostOrderNotException("Boost not Found with id: $boostId")
        }
    }

}