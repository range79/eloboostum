package com.eloboostum.boostOrders.service.impl

import com.eloboostum.boostOrders.domain.model.BoostOrder
import com.eloboostum.boostOrders.domain.repository.BoostOrderRepository
import com.eloboostum.boostOrders.service.CommonBoostOrderService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class CommonBoostOrderServiceImpl(
    private val boosterOrderRepository: BoostOrderRepository
): CommonBoostOrderService {
    override fun getBoosterBoosts(boosterId: Long,pageable: Pageable): Page<BoostOrder> {
        return boosterOrderRepository.findByBoosterId(boosterId,pageable)
    }

    override fun getUserBoostOrders(userId: Long,pageable: Pageable): Page<BoostOrder> {
        return boosterOrderRepository.findByUserId(userId,pageable)
    }
}