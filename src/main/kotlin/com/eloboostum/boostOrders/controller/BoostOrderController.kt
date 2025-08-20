package com.eloboostum.boostOrders.controller

import com.eloboostum.boostOrders.api.BoostOrderApi
import com.eloboostum.boostOrders.domain.model.BoostOrder
import com.eloboostum.boostOrders.service.BoosterOrderService
import com.eloboostum.boostOrders.service.CommonBoostOrderService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController

@RestController
class BoostOrderController(
    private val boostOrderService: BoosterOrderService
): BoostOrderApi {
    override fun getMyBoosts(pageable: Pageable): Page<BoostOrder> {
        return boostOrderService.getMyBoosts(pageable)
    }

    override fun acceptBoost(boostId: Long) {
        return boostOrderService.acceptBoost(boostId)
    }

    override fun cancelBoost(boostId: Long) {
        return boostOrderService.cancelBoost(boostId)
    }


}