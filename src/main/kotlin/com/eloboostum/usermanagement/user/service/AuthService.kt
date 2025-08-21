package com.eloboostum.usermanagement.user.service

import com.eloboostum.usermanagement.user.dto.LoginRequest
import com.eloboostum.usermanagement.user.dto.RegisterRequest

interface AuthService
{
    fun login(loginRequest: LoginRequest): String
    fun register(registerRequest: RegisterRequest): String
}