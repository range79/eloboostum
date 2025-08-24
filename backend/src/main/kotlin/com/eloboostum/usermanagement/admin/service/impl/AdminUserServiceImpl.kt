package com.eloboostum.usermanagement.admin.service.impl

import com.eloboostum.usermanagement.admin.service.AdminUserService

import com.eloboostum.usermanagement.user.domain.model.User
import com.eloboostum.usermanagement.user.domain.repository.UserRepository
import com.eloboostum.usermanagement.user.dto.UserResponse
import com.eloboostum.usermanagement.user.exception.UserNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminUserServiceImpl (
    private val userRepository: UserRepository
): AdminUserService {
    @Transactional
    override fun deleteUser(userID: Long) {
        val user = findUser(userID)
        user.deleted=true
        userRepository.save(user)
    }
    private fun findUser(userId: Long): User {
        return userRepository.findById(userId).orElseThrow{
            UserNotFoundException("User not Found ")
        }
    }
}