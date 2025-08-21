package com.eloboostum.usermanagement.user.api

import com.eloboostum.usermanagement.user.dto.LoginRequest
import com.eloboostum.usermanagement.user.dto.RegisterRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/auth")
interface  AuthApi
{
    //    @PostMapping("/login")
//    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<Void>
//    @PostMapping("/register")
//    fun register(@RequestBody registerRequest: RegisterRequest): ResponseEntity<Void>
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest):String
    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): String
}