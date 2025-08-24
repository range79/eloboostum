package com.eloboostum.error.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Errors (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long?=null,
    val message: String?,
    val timestamp: LocalDateTime= LocalDateTime.now(),
    @Enumerated(EnumType.STRING)
    val type: ErrorTypes,
)