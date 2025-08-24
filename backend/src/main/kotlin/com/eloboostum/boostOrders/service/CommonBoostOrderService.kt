package com.eloboostum.boostOrders.service

import com.eloboostum.boostOrders.domain.model.BoostOrder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CommonBoostOrderService {
    fun getBoosterBoosts(boosterId: Long,pageable: Pageable): Page<BoostOrder>
    fun getUserBoostOrders(userId: Long,pageable: Pageable): Page<BoostOrder>
}