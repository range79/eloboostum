package com.eloboostum.common.service

import com.eloboostum.common.security.details.CustomUserDetails
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import kotlin.test.Test


class SecurityUtilsTest {

    private val securityUtils = SecurityUtils()

    @Test
    fun `should return current user id`() {
        val customUser = mockk<CustomUserDetails>()
        every { customUser.getId() } returns 42L

        val authentication = mockk<Authentication>()
        every { authentication.principal } returns customUser

        SecurityContextHolder.getContext().authentication = authentication

        val userId = securityUtils.getCurrentUserId()
        assertEquals(42L, userId)
    }
}


