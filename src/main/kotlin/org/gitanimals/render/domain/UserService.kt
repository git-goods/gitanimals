package org.gitanimals.render.domain

import org.gitanimals.render.domain.request.PersonaChangeRequest
import org.gitanimals.render.domain.response.PersonaResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.orm.ObjectOptimisticLockingFailureException
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
    private val idempotencyRepository: IdempotencyRepository,
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

    @Transactional
    fun giveBonusPersona(id: Long, persona: String) {
        requireIdempotency("$id:bonus")

        val user = getUserById(id)

        user.giveBonusPersona(persona)
    }

    @Transactional
    fun changePersona(id: Long, personChangeRequest: PersonaChangeRequest) {
        val user = getUserById(id)

        user.changePersonaVisible(
            personChangeRequest.personaId.toLong(),
            personChangeRequest.visible
        )
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 100)
    @Transactional
    fun addPersona(id: Long, personaType: String, idempotencyKey: String): PersonaResponse {
        requireIdempotency("addPersona:$idempotencyKey")

        val user = getUserById(id)

        return user.addPersona(PersonaType.valueOf(personaType.uppercase()))
    }

    private fun requireIdempotency(idempotencyKey: String) {
        val idempotency = idempotencyRepository.findByIdOrNull(idempotencyKey)

        require(idempotency == null) { "Duplicated request" }

        idempotencyRepository.save(Idempotency(idempotencyKey))
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 100)
    @Transactional
    fun deletePersona(id: Long, personaId: Long): PersonaResponse {
        val user = getUserById(id)

        return user.deletePersona(personaId)
    }

    private fun getUserById(id: Long) = (userRepository.findByIdOrNull(id)
        ?: throw IllegalArgumentException("Cannot find exists user by id \"$id\""))
}
