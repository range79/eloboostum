package com.eloboostum.admin.api

import com.eloboostum.user.domain.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/admin/group")
interface AdminRoleApi {
    @GetMapping("/make-moderator/{userId}")
    fun makeModerator(@PathVariable userId: Long): User
    @GetMapping("/remove-moderator/{userId}")
    fun removeModerator(@PathVariable userId: Long): User
    @GetMapping("/make-booster/{userId}")
    fun makeBooster(@PathVariable userId: Long): User
    @GetMapping("/remove-booster/{userId}")
    fun removeBooster(@PathVariable userId: Long): User
}