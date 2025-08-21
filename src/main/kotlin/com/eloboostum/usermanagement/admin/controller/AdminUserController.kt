package com.eloboostum.usermanagement.admin.controller

import com.eloboostum.usermanagement.admin.api.AdminUserApi
import com.eloboostum.usermanagement.admin.service.AdminUserService

import com.eloboostum.usermanagement.user.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminUserController(
    private val service: AdminUserService
): AdminUserApi {
    override fun deleteUser(userID: Long) {
        return service.deleteUser(userID)
    }

    override fun getDeletedUsers(pageable: Pageable): Page<UserResponse> {
        return service.getDeletedUsers(pageable)
    }

    override fun restoreUser(userID: Long) {
        return service.restoreUser(userID)
    }
}