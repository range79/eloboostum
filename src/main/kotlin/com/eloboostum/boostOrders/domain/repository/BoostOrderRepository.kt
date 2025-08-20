package com.eloboostum.boostOrders.domain.repository

import com.eloboostum.boostOrders.domain.model.BoostOrder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BoostOrderRepository: JpaRepository<BoostOrder, Long> {
    fun findByUserId(userId: Long?, pageable: Pageable): Page<BoostOrder>
    fun findByBoosterId(boosterId: Long,pageable: Pageable): Page<BoostOrder>
}