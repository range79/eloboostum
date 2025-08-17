package com.eloboostum.user.dto

import jakarta.validation.constraints.Email
import org.jetbrains.annotations.NotNull

class RegisterRequest(
    @NotNull
    val username: String,
    @NotNull
    val password: String,
    @Email
    val email: String,
)