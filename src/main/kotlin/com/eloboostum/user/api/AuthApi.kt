package com.eloboostum.user.api

import com.eloboostum.user.dto.LoginRequest
import com.eloboostum.user.dto.RegisterRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/auth/login")
interface AuthApi
{
    fun login(loginRequest: LoginRequest): ResponseEntity<String>
    fun register(registerRequest: RegisterRequest): ResponseEntity<String>
}