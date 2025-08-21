package com.eloboostum.usermanagement.user.dto

import com.eloboostum.usermanagement.user.domain.model.Role

data class UserResponse (
    val id : Long? = null,
    val username : String,
    var role : Role,
)