package com.eloboostum.boosters.domain.model

import com.eloboostum.boosters.enum.BoostStatus
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "boosts")
data class Boost (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var userId: Long,
    var boosterId:Long?=null,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var boostStatus: BoostStatus,
    var acceptedAt: LocalDateTime? = null,
    var serviceId: Long
)
