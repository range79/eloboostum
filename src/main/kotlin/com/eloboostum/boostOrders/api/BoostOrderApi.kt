package com.eloboostum.boostOrders.api

import com.eloboostum.boostOrders.domain.model.BoostOrder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/boost-orders/")
interface BoostOrderApi {
    @GetMapping("/get-my-orders")
    fun getMyBoosts(@PageableDefault(size = 20, sort = ["id"]) pageable: Pageable): Page<BoostOrder>
    @PatchMapping("/accept/{boostId} ")
    fun acceptBoost(@PathVariable boostId: Long)
    @PatchMapping("/decline/{boostId}")
    fun cancelBoost(@PathVariable boostId: Long)
}