package com.eloboostum.common.security.details

import com.eloboostum.user.domain.repository.UserRepository
import com.eloboostum.user.exception.UserIdNotFoundException

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
)  {


    @Throws(UsernameNotFoundException::class)
  fun loadUserByUserID(userId: Long): UserDetails {

        val user =  userRepository.findById(userId).orElseThrow{ UserIdNotFoundException("User with ID $userId not found") }
        return CustomUserDetails(user)
    }


}