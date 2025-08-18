package com.eloboostum.user.service.impl

import com.eloboostum.common.security.jwt.JWTUtil
import com.eloboostum.user.domain.model.Role
import com.eloboostum.user.domain.model.User
import com.eloboostum.user.domain.repository.UserRepository
import com.eloboostum.user.dto.LoginRequest
import com.eloboostum.user.dto.RegisterRequest
import com.eloboostum.user.exception.AuthenticationException
import com.eloboostum.user.exception.UserNotFoundException
import com.eloboostum.user.service.AuthService
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

        val user =userRepository.findByUsername(loginRequest.username).orElseThrow{
            AuthenticationException("Username or Password Incorrect")}
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
        )
    }

}