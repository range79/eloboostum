package com.eloboostum.services.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "services")
data class Services (
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name:String? = null,
    var description:String? = null,
    var coverImageURL:String? = null,
    var isActive:Boolean = true,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now()
)