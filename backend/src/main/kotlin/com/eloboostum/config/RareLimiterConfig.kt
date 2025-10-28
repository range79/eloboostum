package com.eloboostum.config

import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.github.resilience4j.ratelimiter.RateLimiterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class RareLimiterConfig {
    @Bean
    fun defaultRateLimiterConfig(): RateLimiterRegistry {
        val config = RateLimiterConfig.custom()
            .limitForPeriod(5)
            .limitRefreshPeriod(Duration.ofMinutes(1))             .timeoutDuration(Duration.ofMillis(500))
            .build()
        return RateLimiterRegistry.of(config)
    }
}