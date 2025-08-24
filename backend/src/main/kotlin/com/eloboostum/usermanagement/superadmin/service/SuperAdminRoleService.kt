package com.eloboostum.usermanagement.superadmin.service

import com.eloboostum.usermanagement.user.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SuperAdminRoleService {
     fun makeAdmin(userId: Long)
     fun removeAdmin(userId: Long)
     fun getAllUsers(pageable: Pageable): Page<UserResponse>
}