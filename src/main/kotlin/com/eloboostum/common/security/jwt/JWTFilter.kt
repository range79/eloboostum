package com.eloboostum.common.security.jwt

import com.eloboostum.common.security.jwt.JWTUtil
import com.eloboostum.common.security.details.CustomUserDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JWTFilter(

    private val jwtUtil: JWTUtil,
    private val customUserDetailsService: CustomUserDetailsService
) : OncePerRequestFilter() {
    private val log: Logger = LoggerFactory.getLogger(JWTFilter::class.java)



    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            var token: String? = null

            val authHeader = request.getHeader("Authorization")
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7)
            }


            if (token == null) {
                val cookies = request.cookies
                token = cookies?.firstOrNull { it.name == "jwt" }?.value
            }



                val id = jwtUtil.getUserId(token)
            if (token != null && SecurityContextHolder.getContext().authentication == null) {
                val userDetails: UserDetails = customUserDetailsService.loadUserByUserID(id)
                if (jwtUtil.validateToken(token, userDetails)) {
                        val authToken =
                            UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.authorities
                            )


                        authToken.details = WebAuthenticationDetailsSource().buildDetails(request)

                        SecurityContextHolder.getContext().authentication = authToken
                    }
                }

        } catch (e: Exception) {
            log.error(e.message)
        }
        filterChain.doFilter(request, response)
    }
}