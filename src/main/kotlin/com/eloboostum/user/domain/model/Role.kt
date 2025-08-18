package com.eloboostum.user.domain.model

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority{
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_BOOSTER,
    ROLE_MODERATOR,
    ROLE_SUPER_ADMIN;

    override fun getAuthority(): String {
       return name
    }
}