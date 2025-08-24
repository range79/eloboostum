package com.eloboostum.usermanagement.user.service.impl

import com.eloboostum.common.security.jwt.JWTUtil
import com.eloboostum.usermanagement.user.domain.model.Role
import com.eloboostum.usermanagement.user.domain.model.User
import com.eloboostum.usermanagement.user.domain.repository.UserRepository
import com.eloboostum.usermanagement.user.dto.LoginRequest
import com.eloboostum.usermanagement.user.dto.RegisterRequest
import com.eloboostum.usermanagement.user.exception.AuthenticationException
import com.eloboostum.usermanagement.user.exception.UserNotFoundException
import com.eloboostum.usermanagement.user.service.AuthService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthServiceImpl (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JWTUtil
): AuthService {
    @Transactional(readOnly = true)
    override fun login(loginRequest: LoginRequest): String {

        val user =userRepository.findByUsername(loginRequest.username)
        if (user.deleted) {
            throw UserNotFoundException("User account has been deleted")
        }
        if(!passwordEncoder.matches(loginRequest.password,user.password))
        {
            throw AuthenticationException("UserName or Password Incorrect")
        }

        return jwtUtil.generateToken(user.id,user.role)

    }
    @Transactional
    override fun register(registerRequest: RegisterRequest): String {
        val  user =userRepository.save(registerMapper(registerRequest))
        return jwtUtil.generateToken(user.id,user.role)
    }

    fun registerMapper(registerRequest: RegisterRequest): User {
        return User(
            id = null,
            email = registerRequest.email,
            password = passwordEncoder.encode(registerRequest.password),
            username = registerRequest.username,
            role = Role.ROLE_USER,
            deleted = false,
        )
    }

}