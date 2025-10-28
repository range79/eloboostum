package com.eloboostum.usermanagement.admin.api

import com.eloboostum.usermanagement.user.domain.model.User
import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/admin/group")
interface AdminRoleApi {
    @RateLimiter(name ="give-moderator")
    @PatchMapping("/make-moderator/{userId}")
    fun makeModerator(@PathVariable userId: Long)
    @RateLimiter(name ="remove-moderator")
    @PatchMapping("/remove-moderator/{userId}")
    fun removeModerator(@PathVariable userId: Long)
    @RateLimiter(name="make-booster")
    @PatchMapping("/make-booster/{userId}")
    fun makeBooster(@PathVariable userId: Long)
    @RateLimiter(name="remove-booster")
    @PatchMapping("/remove-booster/{userId}")
    fun removeBooster(@PathVariable userId: Long)
}