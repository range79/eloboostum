package com.eloboostum.usermanagement.superadmin.service

import com.eloboostum.usermanagement.user.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SuperAdminUserService {
    fun deleteUserPermanently(userId: Long)
    fun getDeletedUsers(pageable: Pageable): Page<UserResponse>
    fun restoreUser(userID: Long)
}