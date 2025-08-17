package com.eloboostum.user.domain.model

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority{
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_BOOSTER;

    override fun getAuthority(): String? {
       return name
    }
}