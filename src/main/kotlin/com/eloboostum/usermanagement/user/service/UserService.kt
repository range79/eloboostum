package com.eloboostum.usermanagement.user.service

import com.eloboostum.usermanagement.user.dto.UserResponse

interface UserService {
    fun getUserById(userId: Long): UserResponse

}