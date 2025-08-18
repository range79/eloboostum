package com.eloboostum.boosters.domain.repository

import com.eloboostum.boosters.domain.model.Boost
import org.springframework.data.jpa.repository.JpaRepository

interface BoostRepository: JpaRepository<Boost, Long> {
}