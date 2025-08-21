package com.eloboostum.user.service.impl

import com.eloboostum.user.domain.model.User
import com.eloboostum.user.domain.repository.UserRepository
import com.eloboostum.user.dto.UserResponse
import com.eloboostum.user.exception.UserNotFoundException
import com.eloboostum.user.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
): UserService {
    override fun getUserById(userId: Long): UserResponse {
        val user = userRepository.findById(userId).orElseThrow{
            UserNotFoundException("User not found with id: $userId")}
            return UserResponse(
                id = userId,
                username = user.username,
                role = user.role
            )
        }
}
