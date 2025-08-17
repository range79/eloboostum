package com.eloboostum.user.domain.repository

import com.eloboostum.user.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface  UserRepository : JpaRepository<User, Long>{

}