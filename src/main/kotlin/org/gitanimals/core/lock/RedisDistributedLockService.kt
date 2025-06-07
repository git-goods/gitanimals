package org.gitanimals.core.lock

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedisDistributedLockService(
    private val redissonClient: RedissonClient,
) : DistributedLock.DistributedLockService {

    override fun <T> withLock(
        key: String,
        leaseMillis: Long,
        waitMillis: Long,
        action: () -> T
    ): T {
        val lock = redissonClient.getLock(key)
        val acquired = lock.tryLock(waitMillis, leaseMillis, TimeUnit.MILLISECONDS)

        return if (acquired) {
            runCatching {
                action.invoke()
            }.getOrElse {
                throw it
            }.also {
                lock.unlock()
            }
        } else {
            throw LockAcquireFailException(message = "Cannot acquire lock")
        }
    }
}

@Configuration
class RedissonConfig(
    @Value("\${netx.host}") private val host: String,
    @Value("\${netx.port}") private val port: String,
    @Value("\${netx.password:0000}") private val password: String,
) {

    @Bean
    fun redissonClient(): RedissonClient {
        val config = Config()

        config.useSingleServer()
            .setAddress("redis://$host:$port")
//            .setPassword(password)

        return Redisson.create(config)
    }
}
