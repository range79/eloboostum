package com.eloboostum.admin.service

import com.eloboostum.user.domain.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface AdminUserService {
    fun deleteUser(userID: Long)
    fun getDeletedUsers(pageable: Pageable): Page<User>
    fun restoreUser(userID: Long)
}