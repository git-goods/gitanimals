package org.gitanimals.render.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<User, Long> {

    @Query("select u from user as u join fetch u.personas where u.name = :name")
    fun findByName(@Param("name") name: String): User?

    fun existsByName(name: String): Boolean
}
