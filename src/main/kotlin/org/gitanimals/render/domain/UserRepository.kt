package org.gitanimals.render.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByName(name: String): User?

    fun existsByName(name: String): Boolean
}
