package com.eloboostum.usermanagement.superadmin.api

import com.eloboostum.usermanagement.user.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/user-management")
interface SuperAdminRoleApi{
    @PatchMapping("/make-admin/{userId}")
    fun makeAdmin( @PathVariable userId: Long)
    @DeleteMapping("/make-user/{userId}")
    fun makeUser( @PathVariable userId: Long)
    @GetMapping("/all")
    fun getALLUsers(@PageableDefault(size = 20, sort = ["id"]) pageable: Pageable): Page<UserResponse>
}