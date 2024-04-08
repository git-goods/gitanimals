package org.gitanimals.render.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
) {

    fun existsByName(name: String): Boolean = userRepository.existsByName(name)

    fun getSvgAnimationByUsername(username: String): String =
        getUserByName(username).createSvgAnimation()

    fun getUserByName(name: String): User {
        return userRepository.findByName(name)
            ?: throw IllegalArgumentException("Cannot find exists user by name \"$name\"")
    }

    @Transactional
    fun createNewUser(name: String, contributions: Map<Int, Int>): User =
        userRepository.save(User.newUser(name, contributions))
}
