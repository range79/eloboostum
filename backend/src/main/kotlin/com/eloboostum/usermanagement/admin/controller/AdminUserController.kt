package com.eloboostum.usermanagement.admin.controller

import com.eloboostum.usermanagement.admin.api.AdminUserApi
import com.eloboostum.usermanagement.admin.service.AdminUserService
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminUserController(
    private val service: AdminUserService
): AdminUserApi {
    override fun deleteUser(userID: Long) {
        return service.deleteUser(userID)
    }
}