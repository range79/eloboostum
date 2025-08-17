package com.eloboostum.services.domain.repository

import com.eloboostum.services.domain.model.Services
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository: JpaRepository<Services, Long> {
}