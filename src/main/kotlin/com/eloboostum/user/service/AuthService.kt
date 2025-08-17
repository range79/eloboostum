package com.eloboostum.user.service

import com.eloboostum.user.dto.LoginRequest
import com.eloboostum.user.dto.RegisterRequest

interface AuthService
{
    fun login(loginRequest: LoginRequest): String
    fun register(registerRequest: RegisterRequest): String
}