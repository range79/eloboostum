package com.eloboostum.user.domain.repository

import com.eloboostum.user.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface  UserRepository : JpaRepository<User, Long>{
fun findByUsername(username: String): Optional<User>
}