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
    fun updateContributions(username: String, contribution: Int): Int {
        val user = getUserByName(username)
        val increasedContributionCount = user.updateContribution(contribution)
        user.giveNewPersona()

        return increasedContributionCount
    }

    fun isContributionUpdatedBeforeOneHour(name: String): Boolean =
        getUserByName(name).isContributionUpdatedBeforeOneHour()

    fun getUserByName(name: String): User = userRepository.findByName(name)
        ?: throw IllegalArgumentException("Cannot find exists user by name \"$name\"")

    @Transactional
    fun createNewUser(name: String, contributions: Map<Int, Int>): User =
        userRepository.save(User.newUser(name, contributions))

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 100)
    @Transactional
    fun givePersonaByCoupon(name: String, persona: String, code: String) {
        requireIdempotency("$name:$code")

        val user = getUserByName(name)

        user.giveNewPersonaByType(PersonaType.valueOf(persona.uppercase()))
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 100)
    @Transactional
    fun changePersona(name: String, personChangeRequest: PersonaChangeRequest): PersonaResponse {
        val user = getUserByName(name)

        val changedPersona = user.changePersonaVisible(
            personChangeRequest.personaId.toLong(),
            personChangeRequest.visible
        )

        return PersonaResponse.from(changedPersona)
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 100)
    @Transactional
    fun addPersona(
        name: String,
        id: Long,
        personaType: String,
        level: Int,
        idempotencyKey: String
    ): PersonaResponse {
        requireIdempotency("addPersona:$idempotencyKey")

        val user = getUserByName(name)

        return user.addPersona(id, PersonaType.valueOf(personaType.uppercase()), level)
    }

    private fun requireIdempotency(idempotencyKey: String) {
        val idempotency = idempotencyRepository.findByIdOrNull(idempotencyKey)

        require(idempotency == null) { "Duplicated request" }

        idempotencyRepository.save(Idempotency(idempotencyKey))
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 100)
    @Transactional
    fun deletePersona(name: String, personaId: Long): PersonaResponse {
        val user = getUserByName(name)

        return user.deletePersona(personaId)
    }

    @Transactional
    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 100)
    fun mergePersona(id: Long, increasePersonaId: Long, deletePersonaId: Long) {
        val user = userRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Cannot find user by id \"$id\"")

        user.mergePersona(increasePersonaId, deletePersonaId)
    }

    fun getPersona(name: String, personaId: Long): PersonaResponse {
        return getUserByName(name).personas
            .find { it.id == personaId }
            ?.let { PersonaResponse.from(it) }
            ?: throw IllegalArgumentException("Cannot find matched persona \"$personaId\" by user name \"$name\"")
    }
}
