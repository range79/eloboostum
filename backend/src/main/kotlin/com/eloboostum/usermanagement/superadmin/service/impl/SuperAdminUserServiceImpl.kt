package com.eloboostum.usermanagement.superadmin.service.impl

import com.eloboostum.usermanagement.superadmin.service.SuperAdminUserService
import com.eloboostum.usermanagement.user.domain.repository.UserRepository
import com.eloboostum.usermanagement.user.dto.UserResponse
import com.eloboostum.usermanagement.user.exception.UserNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service

@Service
class SuperAdminUserServiceImpl(
    private val userRepository: UserRepository,
): SuperAdminUserService {
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    override fun deleteUserPermanently(userId: Long) {
        return userRepository.deleteById(userId)
    }

    override fun getDeletedUsers(pageable: Pageable): Page<UserResponse> {
        return userRepository.getDeletedUsers(pageable)
            .map { user-> UserResponse(user.id,user.username,user.role) }
    }

    override fun restoreUser(userID: Long) {
        val user = userRepository.findDeletedUserById(userID)
            .orElseThrow{UserNotFoundException("Deleted User not Found")}
        user.deleted= false
        userRepository.save(user)
    }
}