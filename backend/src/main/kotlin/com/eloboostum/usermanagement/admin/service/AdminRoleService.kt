package com.eloboostum.usermanagement.admin.service

interface AdminRoleService {
    fun makeModerator(userId: Long)
    fun removeModerator(userId: Long)
    fun makeBooster(userId: Long)
    fun removeBooster(userId: Long)

}