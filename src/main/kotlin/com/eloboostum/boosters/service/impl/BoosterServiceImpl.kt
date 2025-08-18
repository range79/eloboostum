package com.eloboostum.boosters.service.impl

import com.eloboostum.boosters.domain.model.Boost
import com.eloboostum.boosters.domain.repository.BoostRepository
import com.eloboostum.boosters.enum.BoostStatus
import com.eloboostum.boosters.service.BoosterService
import com.eloboostum.common.service.SecurityUtils
import com.eloboostum.services.service.ServicesService
import org.springframework.transaction.annotation.Transactional

class BoosterServiceImpl(
    private val boostRepository: BoostRepository,
    private val servicesService: ServicesService,
    private val securityUtils: SecurityUtils,
): BoosterService {
    @Transactional
    override fun requestBoost(userId: Long, serviceId: Long) {
        servicesService.getServiceById(serviceId)


        val boost = Boost(
            id = 1L, userId = userId,
            serviceId = serviceId,
            boostStatus = BoostStatus.ACTIVE,
            boosterId = null,
            acceptedAt =null
        )
        boostRepository.save(boost)


    }

    override fun acceptBoost(boostId: Long): Boost {
        val boost = boostRepository.findById(boostId).orElseThrow()
        if (boost.boostStatus !=BoostStatus.ACTIVE) {

        }
        securityUtils.getCurrentUserId()



    }

    override fun rejectBoost(boostId: Long): Boost {
        TODO("Not yet implemented")
    }

    override fun getUserBoosts(userId: Long): List<Boost> {
        TODO("Not yet implemented")
    }

    override fun getBoosterBoosts(boosterId: Long): List<Boost> {
        TODO("Not yet implemented")
    }
}