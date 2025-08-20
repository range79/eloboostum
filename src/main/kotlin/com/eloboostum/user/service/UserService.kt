package com.eloboostum.user.service

import com.eloboostum.user.domain.model.User
import com.eloboostum.user.dto.UserResponse

interface UserService {
    fun getUserById(userId: Long): UserResponse

}