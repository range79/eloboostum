package com.eloboostum.boosters.service.impl

import com.eloboostum.boostOrders.domain.model.BoostOrder
import com.eloboostum.boostOrders.domain.repository.BoostOrderRepository
import com.eloboostum.boostOrders.enum.BoostStatus
import com.eloboostum.boostOrders.exception.BoostAuthorException
import com.eloboostum.boostOrders.exception.BoostInactiveOrTakenException
import com.eloboostum.boostOrders.exception.BoostOrderNotException
import com.eloboostum.boostOrders.service.BoosterOrderService
import com.eloboostum.common.exception.RoleMismatchException


import com.eloboostum.common.service.SecurityUtils
import com.eloboostum.user.domain.model.Role
import com.eloboostum.user.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
@Service
class BoosterOrderServiceImpl(
    private val userService: UserService,
    private val boostOrderRepository: BoostOrderRepository,
    private val securityUtils: SecurityUtils,
): BoosterOrderService {
    @Transactional
    override fun acceptBoost(boostId: Long){
        val boost =findBoost(boostId)
        if (boost.boosterId!=null||boost.boostStatus!= BoostStatus.ACTIVE) {
            throw BoostInactiveOrTakenException("Boost is already accepted")
        }
        val user =userService.getUserById(securityUtils.getCurrentUserId())
        if(user.role != Role.ROLE_BOOSTER){
            throw RoleMismatchException("You're not a booster")
        }
        boost.boosterId = user.id
        boost.boostStatus = BoostStatus.TAKEN
        boostOrderRepository.save(boost)
    }

    override fun cancelBoost(boostId: Long) {

        val boost= findBoost(boostId)
        if (securityUtils.getCurrentUserId()!=boost.boosterId){
            throw BoostAuthorException("You're not author of this boost")
        }
        boost.boostStatus= BoostStatus.ACTIVE
        boostOrderRepository.save(boost)

    }


    override fun getMyBoosts(pageable: Pageable): Page<BoostOrder> {
        val user= userService.getUserById(securityUtils.getCurrentUserId())
        if (user.role != Role.ROLE_BOOSTER){
            throw RoleMismatchException("You're not a booster")
        }
        return boostOrderRepository.findByUserId(user.id, pageable)
    }

    private fun findBoost(id : Long):BoostOrder{
        return boostOrderRepository.findById(id).orElseThrow{
            BoostOrderNotException("Boost not found with id: $id")
        }


    }

}