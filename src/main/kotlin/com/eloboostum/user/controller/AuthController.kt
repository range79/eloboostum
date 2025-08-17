package com.eloboostum.user.controller

import com.eloboostum.user.api.AuthApi
import com.eloboostum.user.dto.LoginRequest
import com.eloboostum.user.dto.RegisterRequest
import com.eloboostum.user.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController (
    private val authService: AuthService
): AuthApi {
    override fun login(loginRequest: LoginRequest): ResponseEntity<String> {
        return ResponseEntity.ok().body(authService.login(loginRequest))
    }

    override fun register(registerRequest: RegisterRequest): ResponseEntity<String> {
       return ResponseEntity.ok(authService.register(registerRequest))
    }
}