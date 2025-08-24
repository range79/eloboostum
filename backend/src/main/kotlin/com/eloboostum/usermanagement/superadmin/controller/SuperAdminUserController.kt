package com.eloboostum.usermanagement.superadmin.controller

import com.eloboostum.usermanagement.superadmin.api.SuperAdminUserApi
import com.eloboostum.usermanagement.superadmin.service.SuperAdminUserService
import com.eloboostum.usermanagement.user.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController

@RestController
class SuperAdminUserController (
    private val service: SuperAdminUserService
): SuperAdminUserApi{
    override fun deleteUserPermanently(userId: Long) {
         return service.deleteUserPermanently(userId)
    }

    override fun getDeletedUsers(pageable: Pageable): Page<UserResponse> {
        return service.getDeletedUsers(pageable)
    }

    override fun restoreUser(userID: Long) {
        return service.restoreUser(userID)
    }
}