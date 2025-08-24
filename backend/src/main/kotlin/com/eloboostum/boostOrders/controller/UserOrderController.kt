package com.eloboostum.boostOrders.controller

import com.eloboostum.boostOrders.api.UserOrderApi
import com.eloboostum.boostOrders.domain.model.BoostOrder
import com.eloboostum.boostOrders.service.UserOrderService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserOrderController(
    private val userOrderService: UserOrderService
): UserOrderApi {
    @ResponseStatus(value = HttpStatus.CREATED)
    override fun requestBoost(serviceId: Long) {
        return userOrderService.requestBoost(serviceId)

    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    override fun deleteBoost(boostId: Long) {
       return userOrderService.deleteBoost(boostId)
    }
    @ResponseStatus(value = HttpStatus.OK)
    override fun findMyOrders(pageable: Pageable): Page<BoostOrder> {
        return userOrderService.findMyOrders(pageable)
    }
}