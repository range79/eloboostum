package com.eloboostum.admin.service

import com.eloboostum.admin.exception.RoleMismatchException
import com.eloboostum.user.domain.model.Role
import com.eloboostum.user.domain.model.User
import com.eloboostum.user.domain.repository.UserRepository
import com.eloboostum.user.exception.UserNotFoundException
import org.springframework.stereotype.Service

@Service
class AdminServiceImpl(
    private val userRepository: UserRepository
) :AdminService {
    override fun makeModerator(userId: Long): User {
        return changeRole(userId,Role.ROLE_MODERATOR, Role.ROLE_USER)
    }

    override fun removeModerator(userId: Long): User {
        return changeRole(userId, Role.ROLE_USER,Role.ROLE_MODERATOR)
    }

    override fun makeBooster(userId: Long): User {
        return changeRole(userId, Role.ROLE_BOOSTER, Role.ROLE_USER)
    }

    override fun removeBooster(userId: Long): User {
        return changeRole(userId,Role.ROLE_USER,Role.ROLE_BOOSTER)
    }
    private fun changeRole(userId: Long, role: Role,currentRole: Role): User{
        if(currentRole == role) throw RoleMismatchException("Role is not true")
        val user = findUser(userId)
        user.role = role
        return userRepository.save(user)
    }
    private fun findUser(userId: Long) = userRepository.findById(userId).orElseThrow { UserNotFoundException("User with ID $userId not found") }
}