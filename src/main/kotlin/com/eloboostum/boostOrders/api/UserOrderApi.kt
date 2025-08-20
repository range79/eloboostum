package com.eloboostum.boostOrders.api

import com.eloboostum.boostOrders.domain.model.BoostOrder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/user/orders")
interface UserOrderApi {
    @PostMapping("/boost-orders/{serviceId}")
    fun requestBoost(serviceId: Long)
    @DeleteMapping("delete/{orderId}")
    fun deleteBoost(boostId: Long)
    @GetMapping("/get-my-orders")
    fun findMyOrders(pageable: Pageable): Page<BoostOrder>

}