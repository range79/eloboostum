package com.eloboostum.usermanagement.admin.service

import com.eloboostum.usermanagement.user.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface AdminUserService {
    fun deleteUser(userID: Long)
    fun getDeletedUsers(pageable: Pageable): Page<UserResponse>
    fun restoreUser(userID: Long)
}