package com.eloboostum.usermanagement.admin.service.impl

import com.eloboostum.common.exception.RoleMismatchException

import com.eloboostum.usermanagement.admin.service.AdminRoleService
import com.eloboostum.usermanagement.user.domain.model.Role
import com.eloboostum.usermanagement.user.domain.repository.UserRepository
import com.eloboostum.usermanagement.user.exception.UserNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminRoleServiceImpl(
    private val userRepository: UserRepository
) : AdminRoleService {
    @Transactional
    override fun makeModerator(userId: Long) {
        changeRole(userId, Role.ROLE_MODERATOR, Role.ROLE_USER)
    }
    @Transactional
    override fun removeModerator(userId: Long) {
        changeRole(userId, Role.ROLE_USER, Role.ROLE_MODERATOR)
    }
    @Transactional
    override fun makeBooster(userId: Long) {
        changeRole(userId, Role.ROLE_BOOSTER, Role.ROLE_USER)
    }
    @Transactional
    override fun removeBooster(userId: Long) {
        changeRole(userId, Role.ROLE_USER, Role.ROLE_BOOSTER)
    }

    private fun changeRole(userId: Long, role: Role, currentRole: Role) {
        if(currentRole == role) throw RoleMismatchException("Role is not true")
        val user = findUser(userId)
        user.role = role
        userRepository.save(user)
    }
    private fun findUser(userId: Long) = userRepository.findById(userId).orElseThrow { UserNotFoundException("User with ID $userId not found") }
}