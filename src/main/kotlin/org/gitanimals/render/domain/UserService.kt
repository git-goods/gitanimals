package org.gitanimals.render.domain

import org.springframework.orm.ObjectOptimisticLockingFailureException
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
) {

    fun existsByName(name: String): Boolean = userRepository.existsByName(name)

    fun getFarmAnimationByUsername(username: String): String {
        return getUserByName(username).createFarmAnimation()
    }

    fun getLineAnimationByUsername(username: String, personaId: Long, mode: Mode): String {
        return getUserByName(username).createLineAnimation(personaId, mode)
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    @Transactional
    fun increaseVisit(username: String) {
        getUserByName(username).increaseVisitCount()
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    @Transactional
    fun updateContributions(username: String, contribution: Int) {
        val user = getUserByName(username)
        user.updateContribution(contribution)
        user.giveNewPersona()
    }

    fun isContributionUpdatedBeforeOneHour(name: String): Boolean =
        getUserByName(name).isContributionUpdatedBeforeOneHour()

    fun getUserByName(name: String): User = userRepository.findByName(name)
        ?: throw IllegalArgumentException("Cannot find exists user by name \"$name\"")

    @Transactional
    fun createNewUser(name: String, contributions: Map<Int, Int>): User =
        userRepository.save(User.newUser(name, contributions))
}
