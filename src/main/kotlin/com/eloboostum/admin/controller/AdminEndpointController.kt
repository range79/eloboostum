package com.eloboostum.admin.controller

import com.eloboostum.admin.api.AdminEndpointApi
import com.eloboostum.admin.service.AdminService
import com.eloboostum.user.domain.model.User
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminEndpointController(
    private  val service: AdminService
): AdminEndpointApi {
    override fun makeModerator(userId: Long): User {
        return service.makeModerator(userId)
    }

    override fun removeModerator(userId: Long): User {
        return service.removeModerator(userId)
    }

    override fun makeBooster(userId: Long): User {
        return service.makeBooster(userId)
    }

    override fun removeBooster(userId: Long): User {
        return service.removeBooster(userId)
    }
}