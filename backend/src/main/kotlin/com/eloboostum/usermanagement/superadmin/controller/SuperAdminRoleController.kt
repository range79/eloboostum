package com.eloboostum.usermanagement.superadmin.controller

import com.eloboostum.usermanagement.superadmin.api.SuperAdminRoleApi
import com.eloboostum.usermanagement.superadmin.service.SuperAdminRoleService
import com.eloboostum.usermanagement.user.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController

@RestController
class SuperAdminRoleController(
    val service: SuperAdminRoleService
): SuperAdminRoleApi {
    override fun makeAdmin(userId: Long) {
        return service.makeAdmin(userId)
    }

    override fun makeUser(userId: Long) {
        return service.removeAdmin(userId)
    }

    override fun getALLUsers(pageable: Pageable): Page<UserResponse> {
        return service.getAllUsers(pageable)
    }
}