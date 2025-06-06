package org.gitanimals.guild.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface GuildRepository : JpaRepository<Guild, Long> {

    @Query(
        """
            select g from Guild as g
            where g.title = :title
        """
    )
    fun findByTitle(@Param("title") title: String): Guild?

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
            left join fetch g.members as m 
            where g.leader.userId = :userId or m.userId = :userId
        """
    )
    fun findAllGuildByUserIdWithMembers(@Param("userId") userId: Long): List<Guild>

    @Query(
        """
            select g from Guild as g
            left join fetch g.members as m
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

    @Query(
        value = """
            select g from Guild as g
            order by case 
              when :filter = org.gitanimals.guild.domain.SearchFilter.PEOPLE_ASC then '%' 
              else :personaType 
            end
        """
    )
    fun search(pageable: Pageable, @Param("filter") filter: SearchFilter): Page<Guild>

    @Query(
        """
            select g from Guild as g 
            left join g.members as m group by g.id 
            order by count(m) asc
        """
    )
    fun searchByPeopleCountAsc(pageable: Pageable): Page<Guild>

    @Query(
        """
            select g from Guild as g 
            left join g.members as m group by g.id 
            order by count(m) desc
        """
    )
    fun searchByPeopleCountDesc(pageable: Pageable): Page<Guild>

    @Query(
        """
            select g from Guild as g
            left join g.members as m group by g.id
            order by (g.leader.contributions + coalesce(sum(m.contributions), 0)) asc
        """
    )
    fun searchByContributionCountAsc(pageable: Pageable): Page<Guild>

    @Query(
        """
            select g from Guild as g
            left join g.members as m group by g.id
            order by (g.leader.contributions + coalesce(sum(m.contributions), 0)) desc
        """
    )
    fun searchByContributionCountDesc(pageable: Pageable): Page<Guild>

    @Query(
        """
            select g from Guild as g
            left join fetch g.members as m
            left join g.waitMembers as wm
            where g.leader.name = :name or m.name = :name or wm.name = :name
        """
    )
    fun findAllByNameContains(@Param("name") name: String, pageable: Pageable): Slice<Guild>
}
