package com.eloboostum.user.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import java.util.UUID

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    @Column(unique = true, nullable = false)
    val username : String,
    @Column(unique = true, nullable = false)
    @Email
    val email : String,
    val password : String,
    val role : Role,
)
