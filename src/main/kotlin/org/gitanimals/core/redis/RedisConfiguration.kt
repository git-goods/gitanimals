package org.gitanimals.core.redis

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate

@Configuration
class RedisConfiguration(
    @Value("\${netx.host}") private val host: String,
    @Value("\${netx.port}") private val port: String,
    @Value("\${netx.password:0000}") private val password: String,
) {

    @Bean
    fun gitanimalsRedisTemplate(): StringRedisTemplate =
        StringRedisTemplate(redisConnectionFactory())

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        val port: String = System.getProperty("netx.port") ?: port

        val redisStandaloneConfiguration = RedisStandaloneConfiguration()
        redisStandaloneConfiguration.hostName = host
        redisStandaloneConfiguration.port = port.toInt()
        redisStandaloneConfiguration.password = RedisPassword.of(password)

        return LettuceConnectionFactory(redisStandaloneConfiguration)
    }
}
