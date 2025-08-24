package com.eloboostum.common.service

import com.eloboostum.common.security.details.CustomUserDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityUtils {

    fun getCurrentUserId(): Long {
        val authentication = SecurityContextHolder.getContext().authentication
            ?: throw IllegalStateException("No authentication in security context")

        val principal = authentication.principal
        return when (principal) {
            is CustomUserDetails -> principal.getId()
            else -> throw IllegalStateException("Unknown principal type: ${principal::class}")
        }
    }

}