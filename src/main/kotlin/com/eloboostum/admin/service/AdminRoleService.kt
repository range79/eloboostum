package com.eloboostum.admin.service

import com.eloboostum.user.domain.model.User

interface AdminRoleService {
    fun makeModerator(userId: Long): User
    fun removeModerator(userId: Long): User
    fun makeBooster(userId: Long): User
    fun removeBooster(userId: Long): User

}