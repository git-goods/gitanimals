package org.gitanimals.render.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
) {

    fun existsByName(name: String): Boolean = userRepository.existsByName(name)

    fun getUserByName(name: String): User {
        return userRepository.findByName(name)
            ?: throw IllegalArgumentException("Cannot find exists user by name \"$name\"")
    }

    @Transactional
    fun createNewUser(name: String): User = userRepository.save(User.newUser(name))
}
