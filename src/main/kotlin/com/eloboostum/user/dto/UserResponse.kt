package com.eloboostum.user.dto

import com.eloboostum.user.domain.model.Role

data class UserResponse (
    val id : Long? = null,
    val username : String,
    var role : Role,
)