package com.eloboostum.usermanagement.user.service.impl

import com.eloboostum.usermanagement.user.domain.repository.UserRepository
import com.eloboostum.usermanagement.user.dto.UserResponse
import com.eloboostum.usermanagement.user.exception.UserNotFoundException
import com.eloboostum.usermanagement.user.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
): UserService {
    override fun getUserById(userId: Long): UserResponse {
        val user = userRepository.findById(userId).orElseThrow{
            UserNotFoundException("User not found with id: $userId")
        }
        return UserResponse(
            id = userId,
            username = user.username,
            role = user.role
        )
    }
}
