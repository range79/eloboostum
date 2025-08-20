package com.eloboostum.admin.service.impl

import com.eloboostum.admin.service.AdminUserService
import com.eloboostum.user.domain.model.User
import com.eloboostum.user.domain.repository.UserRepository
import com.eloboostum.user.exception.UserNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminUserServiceImpl (
    private val userRepository: UserRepository
): AdminUserService {
    @Transactional
    override fun deleteUser(userID: Long) {
        val user = findUser(userID)
        user.deleted=true
        userRepository.save(user)
    }
    @Transactional(readOnly = true)
    override fun getDeletedUsers(pageable: Pageable): Page<User> {
        return userRepository.getDeletedUsers(pageable)
    }
    @Transactional
    override fun restoreUser(userID: Long) {
        val user =userRepository.findDeletedUserById(userID).orElseThrow{
            UserNotFoundException("User not Found ")
        }
        user.deleted=false
        userRepository.save(user)
    }
    private fun findUser(userId: Long): User{
        return userRepository.findById(userId).orElseThrow{
            UserNotFoundException("User not Found ")
        }
    }
}