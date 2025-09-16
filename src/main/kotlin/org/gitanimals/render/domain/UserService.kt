package org.gitanimals.render.domain

import org.gitanimals.core.FieldType
import org.gitanimals.core.Mode
import org.gitanimals.core.PersonaType
import org.gitanimals.render.domain.request.PersonaChangeRequest
import org.gitanimals.render.domain.response.PersonaResponse
import org.hibernate.Hibernate
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

    fun isContributionUpdatedLongAgo(name: String): Boolean =
        getUserByName(name).isContributionUpdatedLongAgo()

    fun getUserByName(name: String): User = userRepository.findByName(name)
        ?: throw IllegalArgumentException("Cannot find exists user by name \"$name\"")

    fun getUserByNameWithAllContributions(name: String): User =
        userRepository.findByNameWithContributions(name)
            ?: throw IllegalArgumentException("Cannot find exists user by name \"$name\"")

    @Transactional
    fun createNewUser(
        name: String,
        contributions: Map<Int, Int>
    ): User {
        return userRepository.save(
            User.newUser(
                name = name,
                contributions = contributions,
            )
        )
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 3)
    @Transactional
    fun setAuthInfo(
        name: String,
        entryPoint: EntryPoint,
        authenticationId: String,
    ) {
        val user = getUserByName(name)

        require(user.isAuthInfoSet().not()) { "Already set authInfo. name: $name" }

        user.setAuthInfo(entryPoint, authenticationId)
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    @Transactional
    fun givePersonaByCoupon(name: String, persona: String, code: String) {
        requireIdempotency("$name:$code")

        val user = getUserByName(name)

        user.giveNewPersonaByType(PersonaType.valueOf(persona.uppercase()))
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    @Transactional
    fun changePersona(name: String, personaChangeRequest: PersonaChangeRequest): PersonaResponse {
        val user = getUserByName(name)

        val changedPersona = user.changePersonaVisible(
            personaChangeRequest.personaId.toLong(),
            personaChangeRequest.visible,
            personaChangeRequest.type,
        )

        return PersonaResponse.from(changedPersona)
    }

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
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

    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    @Transactional
    fun deletePersona(name: String, personaId: Long): PersonaResponse {
        val user = getUserByName(name)

        return user.deletePersona(personaId)
    }

    @Transactional
    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    fun mergePersona(
        name: String,
        increasePersonaId: Long,
        deletePersonaId: Long,
    ): PersonaResponse {
        val user = userRepository.findByName(name)
            ?: throw IllegalArgumentException("Cannot find user by name \"$name\"")

        return PersonaResponse.from(user.mergePersona(increasePersonaId, deletePersonaId))
    }

    @Transactional
    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    fun addField(name: String, fieldType: FieldType) {
        getUserByName(name).addField(fieldType)
    }

    @Transactional
    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    fun deleteField(name: String, fieldType: FieldType) {
        getUserByName(name).deleteField(fieldType)
    }

    @Transactional
    @Retryable(retryFor = [ObjectOptimisticLockingFailureException::class], maxAttempts = 10)
    fun changeField(name: String, fieldType: FieldType) {
        getUserByName(name).changeField(fieldType)
    }

    @Transactional
    fun deleteByName(name: String) = userRepository.deleteByName(name)

    fun getByNameWithLazyLoading(name: String, vararg lazyLoading: (User) -> Unit): User {
        val user = getUserByName(name)

        lazyLoading.forEach { it(user) }

        return user
    }

    fun getPersona(name: String, personaId: Long): PersonaResponse {
        return getUserByName(name).personas
            .find { it.id == personaId }
            ?.let { PersonaResponse.from(it) }
            ?: throw IllegalArgumentException("Cannot find matched persona \"$personaId\" by user name \"$name\"")
    }

    fun findAllUsersByNameWithContributions(usernames: Set<String>): List<User> {
        return userRepository.findAllByIdsWithContributions(usernames)
    }

    @Transactional(readOnly = true)
    fun findUserByEntryPointAndAuthenticationId(
        entryPoint: EntryPoint,
        authenticationId: String
    ): User? {
        return userRepository.findByEntryPointAndAuthenticationId(entryPoint, authenticationId)
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun updateUsernameById(id: Long, username: String) {
        val user = getUserById(id)
        user.updateName(username)
    }

    @Transactional
    fun evolutionPersona(name: String, personaId: Long): PersonaResponse {
        val user = getUserByName(name)
        val evolutionedPersona = user.evolution(personaId)

        return PersonaResponse.from(persona = evolutionedPersona)
    }

    @Transactional(readOnly = true)
    fun isEvoluationable(name: String, personaId: Long): Boolean {
        val user = getUserByName(name)

        return user.isEvolutionable(
            personaId = personaId
        )
    }

    private fun getUserById(id: Long): User {
        return userRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Cannot find user by id : \"$id\"")
    }

    companion object {
        val loadField: (User) -> Unit = { Hibernate.initialize(it.fields) }
    }
}
