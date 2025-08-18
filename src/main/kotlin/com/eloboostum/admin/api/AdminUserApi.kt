package com.eloboostum.admin.api

import com.eloboostum.user.domain.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController("\${api.prefix}/admin/user")
interface AdminUserApi {
    @DeleteMapping("/delete/{userID}")
    fun deleteUser(@PathVariable userID: Long)
    @GetMapping("/deleted")
    fun getDeletedUsers(pageable: Pageable): Page<User>
    @DeleteMapping("/restore/{userID}")
    fun restoreUser( @PathVariable userID: Long)
}