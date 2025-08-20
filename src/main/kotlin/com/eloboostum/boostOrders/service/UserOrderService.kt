package com.eloboostum.boostOrders.service

import com.eloboostum.boostOrders.domain.model.BoostOrder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserOrderService {
    fun requestBoost(serviceId: Long)
    fun deleteBoost(boostId: Long)
    fun findMyOrders(pageable: Pageable): Page<BoostOrder>
}