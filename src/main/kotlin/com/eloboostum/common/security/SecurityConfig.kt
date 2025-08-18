package com.eloboostum.common.security

import com.eloboostum.common.security.jwt.JWTFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
class SecurityConfig(private val jwtFilter: JWTFilter) {
@Value("\${api.prefix}")
private lateinit var prefix: String;
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http{
            csrf { disable() }
            authorizeHttpRequests {
                authorize("$prefix/auth/register",permitAll)
                authorize("$prefix/auth/login", permitAll)



                //admin endpoints
                authorize ("$prefix/admin/group/**",hasAuthority("ROLE_ADMIN"))
                authorize ("$prefix/admin/user/**",hasAuthority("ROLE_ADMIN"))


                authorize(anyRequest, permitAll)
            }
            formLogin { disable() }
            addFilterBefore<UsernamePasswordAuthenticationFilter>(jwtFilter)
        }
        return http.build()
    }



}