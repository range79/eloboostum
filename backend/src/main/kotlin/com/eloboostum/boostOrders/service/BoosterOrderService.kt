package com.eloboostum.boostOrders.service

import com.eloboostum.boostOrders.domain.model.BoostOrder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

import org.springframework.stereotype.Service


interface BoosterOrderService {
    fun getMyBoosts(pageable: Pageable): Page<BoostOrder>
    fun acceptBoost(boostId: Long)
    fun cancelBoost(boostId: Long)
}


