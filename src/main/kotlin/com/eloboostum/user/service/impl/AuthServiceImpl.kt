package com.eloboostum.user.service.impl

import com.eloboostum.user.domain.model.Role
import com.eloboostum.user.domain.model.User
import com.eloboostum.user.domain.repository.UserRepository
import com.eloboostum.user.dto.LoginRequest
import com.eloboostum.user.dto.RegisterRequest
import com.eloboostum.user.service.AuthService

class AuthServiceImpl (
    private val userRepository: UserRepository
): AuthService {
    override fun login(loginRequest: LoginRequest): String {

    }

    override fun register(registerRequest: RegisterRequest): String {
        userRepository.save(registerMapper(registerRequest))
        
    }

    fun registerMapper(registerRequest: RegisterRequest): User {
        return User(
            id = null,
            email = registerRequest.email,
            password = registerRequest.password,
            username = registerRequest.username,
            role = Role.ROle_User,
        )

    }

}