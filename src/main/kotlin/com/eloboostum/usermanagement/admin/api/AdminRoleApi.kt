package com.eloboostum.usermanagement.admin.api

import com.eloboostum.usermanagement.user.domain.model.User
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/admin/group")
interface AdminRoleApi {
    @PatchMapping("/make-moderator/{userId}")
    fun makeModerator(@PathVariable userId: Long)
    @PatchMapping("/remove-moderator/{userId}")
    fun removeModerator(@PathVariable userId: Long)
    @PatchMapping("/make-booster/{userId}")
    fun makeBooster(@PathVariable userId: Long)
    @PatchMapping("/remove-booster/{userId}")
    fun removeBooster(@PathVariable userId: Long)
}