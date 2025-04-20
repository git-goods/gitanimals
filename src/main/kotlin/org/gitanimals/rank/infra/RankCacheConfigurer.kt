package org.gitanimals.rank.infra

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.time.Duration.Companion.minutes
import kotlin.time.toJavaDuration

@Configuration
class RankCacheConfigurer {

    @Bean
    fun rankTotalCountCacheManager(): CacheManager {
        val caffeineConfig = Caffeine.newBuilder().expireAfterWrite(10.minutes.toJavaDuration())

        val caffeineCacheManager = CaffeineCacheManager()
        caffeineCacheManager.setCaffeine(caffeineConfig)

        return caffeineCacheManager
    }
}
