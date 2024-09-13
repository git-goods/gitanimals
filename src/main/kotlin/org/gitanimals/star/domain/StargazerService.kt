package org.gitanimals.star.domain

import jakarta.persistence.EntityManager
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class StargazerService(
    private val stargazersRepository: StargazersRepository,
    private val entityManager: EntityManager,
) {

    @Cacheable(value = ["exists_by_login_cache"])
    fun existsByLogin(login: String): Boolean = stargazersRepository.existsById(login)

    @Transactional
    fun updateAll(logins: List<String>) {
        stargazersRepository.deleteAllInBatch()

        logins.map { entityManager.persist(Stargazer(it)) }
        entityManager.flush()
        entityManager.clear()
    }
}
