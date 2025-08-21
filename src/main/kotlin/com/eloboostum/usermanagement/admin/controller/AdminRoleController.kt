package com.eloboostum.usermanagement.admin.controller

import com.eloboostum.usermanagement.admin.api.AdminRoleApi
import com.eloboostum.usermanagement.admin.service.AdminRoleService
import com.eloboostum.usermanagement.user.domain.model.User

import org.springframework.web.bind.annotation.RestController

@RestController
class AdminRoleController(
    private  val service: AdminRoleService
): AdminRoleApi {
    override fun makeModerator(userId: Long) {
       return  service.makeModerator(userId)
    }

    override fun removeModerator(userId: Long) {
       return  service.removeModerator(userId)
    }

    override fun makeBooster(userId: Long) {
        return service.makeBooster(userId)
    }

    override fun removeBooster(userId: Long) {
        return service.removeBooster(userId)
    }
}