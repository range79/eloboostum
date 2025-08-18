package com.eloboostum.user.domain.repository

import com.eloboostum.user.domain.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface  UserRepository : JpaRepository<User, Long>{
    fun findByUsername(username: String): Optional<User>
    @Query(
        value = "SELECT * FROM users WHERE deleted = true ORDER BY id DESC",
        countQuery = "SELECT COUNT(*) FROM users WHERE deleted = true",
        nativeQuery = true
    )
    fun getDeletedUsers(pageable: Pageable): Page<User>
    @Query("SELECT* FROM users where userid=:#{#userId} and deleted=true",
        nativeQuery = true)
    fun findDeletedUserById(userId: Long): Optional<User>

}