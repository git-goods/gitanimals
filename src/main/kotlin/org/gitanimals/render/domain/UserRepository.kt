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
            where u.name in :usernames
        """
    )
    fun findAllByIdsWithContributions(@Param("usernames") usernames: Set<String>): List<User>

    @Query(
        """
            select u from user as u
            where u.authInfo.entryPoint = :entryPoint
            and u.authInfo.authenticationId = :authenticationId
        """
    )
    fun findByEntryPointAndAuthenticationId(
        @Param("entryPoint") entryPoint: EntryPoint,
        @Param("authenticationId") authenticationId: String,
    ): User?

    fun existsByName(name: String): Boolean

    fun deleteByName(name: String)
}
