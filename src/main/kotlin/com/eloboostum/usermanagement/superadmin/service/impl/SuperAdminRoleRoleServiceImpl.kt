package com.eloboostum.usermanagement.superadmin.service.impl

import com.eloboostum.common.exception.RoleMismatchException
import com.eloboostum.usermanagement.superadmin.service.SuperAdminRoleService
import com.eloboostum.usermanagement.user.domain.model.Role
import com.eloboostum.usermanagement.user.domain.model.User
import com.eloboostum.usermanagement.user.domain.repository.UserRepository
import com.eloboostum.usermanagement.user.dto.UserResponse
import com.eloboostum.usermanagement.user.exception.UserNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class SuperAdminRoleRoleServiceImpl (
    private val userRepository: UserRepository,
): SuperAdminRoleService {
    override fun makeAdmin(userId: Long) {
        val user = findUser(userId)
        if (user.role== Role.ROLE_ADMIN){
            throw RoleMismatchException("User is already admin")
        }
        user.role=Role.ROLE_ADMIN
        userRepository.save(user)
    }

    override fun removeAdmin(userId: Long) {

        val user =findUser(userId)
        if (user.role!= Role.ROLE_ADMIN){
            throw RoleMismatchException("User is not admin")
        }
        user.role= Role.ROLE_USER
        userRepository.save(user)
    }

    override fun getAllUsers(pageable: Pageable): Page<UserResponse> {
        return userRepository.findAll(pageable)
            .map {user-> userToUserResponse(user)}
    }



    fun userToUserResponse(user: User): UserResponse{
        return UserResponse(
            user.id,
            user.username,
            user.role
        )
    }
    private fun findUser(userid: Long): User{
        return userRepository.findById(userid).orElseThrow { UserNotFoundException("User not Found") }
    }

}