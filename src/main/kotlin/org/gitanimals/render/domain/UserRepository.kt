package org.gitanimals.render.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<User, Long> {

    fun findByName(name: String): User?

    @Query(
        """
            select u from user as u
            left join fetch u.contributions
            where u.name = :name
        """
    )
    fun findByNameWithContributions(@Param("name") name: String): User?

    @Query(
        """
            select u from user as u
            left join fetch u.contributions
            where u.id in :userIds
        """
    )
    fun findAllByIdsWithContributions(@Param("userIds") userIds: Set<Long>): List<User>

    fun existsByName(name: String): Boolean
}
