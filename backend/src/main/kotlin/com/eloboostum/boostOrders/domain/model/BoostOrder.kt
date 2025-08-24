package com.eloboostum.boostOrders.domain.model

import com.eloboostum.boostOrders.enum.BoostStatus
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDateTime
@SQLRestriction("boosStatus = ")
@Entity
@Table(name = "boost_order")
data class BoostOrder (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var userId: Long,
    var boosterId:Long?=null,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Enumerated(EnumType.STRING)
    var boostStatus: BoostStatus,
    var acceptedAt: LocalDateTime? = null,
    var serviceId: Long,
    var deleted: Boolean = false,
)
