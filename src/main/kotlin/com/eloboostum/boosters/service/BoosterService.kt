package com.eloboostum.boosters.service

import com.eloboostum.boosters.domain.model.Boost
import com.eloboostum.user.domain.model.User
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
interface BoosterService {
    fun requestBoost(userId: Long, serviceId: Long)
    fun acceptBoost(boostId: Long): Boost
    fun rejectBoost(boostId: Long): Boost
    fun getUserBoosts(userId: Long): List<Boost>
    fun getBoosterBoosts(boosterId: Long): List<Boost>

}


