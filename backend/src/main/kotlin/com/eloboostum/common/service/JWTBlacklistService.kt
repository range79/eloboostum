package com.eloboostum.common.service

import com.eloboostum.common.exception.TokenException
import com.eloboostum.common.security.jwt.JWTUtil
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class JWTBlacklistService(
    private val jwtUtil: JWTUtil,
    private val redisTemplate: RedisTemplate<String, String>
)
{
    fun blacklistToken(jwtToken: String){
        try {

            val isActive =jwtUtil.validateToken(jwtToken)
            val jti = jwtUtil.getJti(jwtToken)
            if (!isActive){
                throw TokenException("Token is expired or invalid")
            }
            if (checkToken(jwtToken)){
                throw TokenException("Token Already blacklisted!")
            }

            redisTemplate.opsForValue().set(jti, "blacklisted")

        } catch (e: Exception) {
           throw TokenException(e.message ?: "Redis Error Occurred")
        }



    }
    fun checkToken(jwtToken: String): Boolean {
        try {
            val jti = jwtUtil.getJti(jwtToken)
            return redisTemplate.hasKey(jti) ?: false
        } catch (e: Exception) {
            return true
        }
    }
}