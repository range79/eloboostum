package com.eloboostum.usermanagement.superadmin.api

import com.eloboostum.usermanagement.user.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/superadmin/users")
interface SuperAdminUserApi {
   @DeleteMapping("/{userId}/permanent")
    fun deleteUserPermanently(userId: Long)
    @GetMapping("/deleted/all")
    fun getDeletedUsers(pageable: Pageable): Page<UserResponse>
    @GetMapping("/restore/{userId}")
    fun restoreUser(userID: Long)
}