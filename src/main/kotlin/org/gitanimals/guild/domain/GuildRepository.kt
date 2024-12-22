package org.gitanimals.guild.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface GuildRepository : JpaRepository<Guild, Long> {

    fun existsByTitle(title: String): Boolean

    @Query(
        """
            select g from Guild as g
            where g.id = :id
            and g.leader.userId = :leaderId
        """
    )
    fun findGuildByIdAndLeaderId(@Param("id") id: Long, @Param("leaderId") leaderId: Long): Guild?

    @Query(
        """
            select g from Guild as g
            join fetch g.members as m 
            where g.leader.userId = :userId or m.userId = :userId
        """
    )
    fun findAllGuildByUserIdWithMembers(@Param("userId") userId: String): List<Guild>

    @Query(
        """
            select g from Guild as g
            join fetch g.members as m
            where g.leader.name = :username or m.name = :username
        """
    )
    fun findAllGuildByUsernameWithMembers(@Param("username") username: String): List<Guild>

    @Query("select g from Guild as g")
    fun findAllWithLimit(pageable: Pageable): List<Guild>

    @Query(
        value = """
            SELECT g.* 
            FROM guild g 
            WHERE MATCH(g.title, g.body) AGAINST(:text IN BOOLEAN MODE)
        """,
        countQuery = "SELECT COUNT(*) FROM guild",
        nativeQuery = true,
    )
    fun search(@Param("text") text: String, pageable: Pageable): Page<Guild>
}
